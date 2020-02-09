package com.kaungmyatmin.wonder.features.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaungmyatmin.wonder.api.MainApiService
import com.kaungmyatmin.wonder.models.Wonder
import com.kaungmyatmin.wonder.models.responses.SchemaWonders
import com.kaungmyatmin.wonder.repository.WonderLocalRepository
import com.kaungmyatmin.wonder.repository.WonderRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val wonderRepository: WonderRepository,
    private val wonderLocalRepository: WonderLocalRepository
) : ViewModel() {
    val wonders: MutableLiveData<List<Wonder>> = MutableLiveData()
    private val disposible: CompositeDisposable = CompositeDisposable()

    fun getWonders() {
        disposible.add(
            wonderLocalRepository.getAllWonders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    Log.d("MainActivity", "on next")
                    response?.let {
                        wonders.postValue(it)
                        GlobalScope.launch(Dispatchers.IO) {
                            wonderLocalRepository.insertAll(it)
                        }

                    }

                },
                    { e ->
                        Log.d("MainActivity", "on error")
                    })
        )


    }
}