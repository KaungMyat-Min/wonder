package com.kaungmyatmin.wonder.features.main.ui.wonderlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaungmyatmin.wonder.features.main.models.Wonder
import com.kaungmyatmin.wonder.features.main.data.repository.WonderLocalRepository
import com.kaungmyatmin.wonder.features.main.data.repository.WonderRemoteRepository
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

    init{
        getWonders()
    }
    fun getWonders() {
        Log.d("wonderlist","fetching")
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
                            wonderLocalRepository.updateOrDelete()
                            wonderLocalRepository.insertAll(it)
                        }


                    }

                },
                    { e ->


                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposible.clear()
    }
}