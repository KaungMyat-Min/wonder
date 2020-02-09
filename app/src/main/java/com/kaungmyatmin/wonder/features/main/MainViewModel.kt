package com.kaungmyatmin.wonder.features.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaungmyatmin.wonder.api.MainApiService
import com.kaungmyatmin.wonder.models.Wonder
import com.kaungmyatmin.wonder.models.responses.SchemaWonders
import com.kaungmyatmin.wonder.repository.WonderRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel
@Inject constructor(private val wonderRepository: WonderRepository) : ViewModel() {
    val wonders: MutableLiveData<List<Wonder>> = MutableLiveData()
    private val disposible: CompositeDisposable = CompositeDisposable()

    fun getWonders() {
        disposible.add(
            wonderRepository.getWonders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ retrievedNews ->
                    Log.d("MainActivity","on next")
                    Log.d("MainActivity",retrievedNews.toString())
                    wonders.postValue(retrievedNews.wonders)
                },
                    { e ->
                        Log.d("MainActivity","on error")
                    })
        )


    }
}