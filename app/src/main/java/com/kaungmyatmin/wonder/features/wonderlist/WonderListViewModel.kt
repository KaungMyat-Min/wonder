package com.kaungmyatmin.wonder.features.wonderlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaungmyatmin.wonder.models.Wonder
import com.kaungmyatmin.wonder.repository.WonderRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class WonderListViewModel @Inject constructor(private val wonderRepository: WonderRepository) :
    ViewModel() {
    val wonders: MutableLiveData<List<Wonder>> = MutableLiveData()
    private val disposible: CompositeDisposable = CompositeDisposable()

    fun getWonders() {
        disposible.add(
            wonderRepository.getWonders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    Log.d("MainActivity", "on next")
                    response?.wonders?.let {
                        wonders.postValue(it)
                        GlobalScope.launch(Dispatchers.IO) {

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