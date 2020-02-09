package com.kaungmyatmin.wonder.features.wonderlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaungmyatmin.wonder.models.Wonder
import com.kaungmyatmin.wonder.repository.WonderLocalRepository
import com.kaungmyatmin.wonder.repository.WonderRemoteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class WonderListViewModel @Inject constructor(
    private val wonderRemoteRepository: WonderRemoteRepository,
    private val wonderLocalRepository: WonderLocalRepository
) :
    ViewModel() {
    val wonders: MutableLiveData<List<Wonder>> = MutableLiveData()
    private val disposible: CompositeDisposable = CompositeDisposable()

    fun getWonders() {
        disposible.add(
            wonderLocalRepository.getCachedWonder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    it?.let {
                        wonders.postValue(it)
                    }
                }
        )


        disposible.add(
            wonderRemoteRepository.getLatestWonders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    response?.wonders?.let {
                        wonders.postValue(it)
                        GlobalScope.launch(Dispatchers.IO) {
                            wonderLocalRepository.deleteAll()
                            wonderLocalRepository.insertAll(it)
                        }


                    }

                },
                    { e ->
                        Log.d("MainActivity", "on error")

                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposible.clear()
    }
}