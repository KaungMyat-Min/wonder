package com.codingwithmitch.openapi.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.kaungmyatmin.wonder.api.ApiEmptyResponse
import com.kaungmyatmin.wonder.api.ApiErrorResponse
import com.kaungmyatmin.wonder.api.ApiSuccessResponse
import com.kaungmyatmin.wonder.api.GenericApiResponse
import com.kaungmyatmin.wonder.utli.*
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.util.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

abstract class NetworkBoundResource<ResponseObject, CacheObject, ViewStateType>
    (
    isNetworkAvailable: Boolean, // is there a network connection?
    isNetworkRequest: Boolean, // is this a network request?
    shouldCancelIfNoInternet: Boolean, // should this job be cancelled if there is no network?
    shouldLoadFromCache: Boolean // should the cached data be loaded?
) {

    private val TAG: String = "AppDebug"

    protected val result = PublishSubject.create<DataState<ViewStateType>>()
    private val disposible: CompositeDisposable = CompositeDisposable()
    protected lateinit var job: CompletableJob
    protected lateinit var coroutineScope: CoroutineScope

    init {
        //setJob(initNewJob())
        setValue(DataState.loading(isLoading = true, cachedData = null))

        if (shouldLoadFromCache) {
            // view cache to start
            disposible.add(
                loadFromCache().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { viewStateType ->
                        setValue(DataState.loading(isLoading = true, cachedData = viewStateType))
                    }
            )

        }

        if (isNetworkRequest) {
            if (isNetworkAvailable) {
                doNetworkRequest()
            } else {
                if (shouldCancelIfNoInternet) {
                    onErrorReturn(
                        ErrorHandler.UNABLE_TODO_OPERATION_WO_INTERNET,
                        shouldUseDialog = true,
                        shouldUseToast = false
                    )
                } else {
                    doCacheRequest()
                }
            }
        } else {
            doCacheRequest()
        }
    }

    fun doCacheRequest() {
        createCacheRequestAndReturn()
//        coroutineScope.launch {
////            delay(Constants.TESTING_CACHE_DELAY)
//            // View data from cache only and return
//
//        }
    }

    fun doNetworkRequest() {
        disposible.add(
            createCall().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response ->
                    handleNetworkCall(response)
//                    coroutineScope.launch {
//
//                    }
                }
        )
//        coroutineScope.launch {
//
//
//            withContext(Main) {
//
//
//            }
//        }

//        GlobalScope.launch(IO) {
//
//            if (!job.isCompleted) {
//                Log.e(TAG, "NetworkBoundResource: JOB NETWORK TIMEOUT.")
//                job.cancel(CancellationException(ErrorHandler.UNABLE_TO_RESOLVE_HOST))
//            }
//        }
    }

     fun handleNetworkCall(response: GenericApiResponse<ResponseObject>) {

        when (response) {
            is ApiSuccessResponse -> {
                handleApiSuccessResponse(response)
            }
            is ApiErrorResponse -> {
                Log.e(TAG, "NetworkBoundResource: ${response.errorMessage}")
                onErrorReturn(response.errorMessage, true, false)
            }
            is ApiEmptyResponse -> {
                Log.e(TAG, "NetworkBoundResource: Request returned NOTHING (HTTP 204).")
                onErrorReturn("HTTP 204. Returned NOTHING.", true, false)
            }
        }
    }

    fun onCompleteJob(dataState: DataState<ViewStateType>) {
        setValue(dataState)
//        GlobalScope.launch(Main) {
//            job.complete()
//            setValue(dataState)
//        }
    }

    fun onErrorReturn(errorMessage: String?, shouldUseDialog: Boolean, shouldUseToast: Boolean) {
        var msg = errorMessage
        var useDialog = shouldUseDialog
        var responseType: ResponseType = ResponseType.None()
        if (msg == null) {
            msg = ErrorHandler.ERROR_UNKNOWN
        } else if (ErrorHandler.isNetworkError(msg)) {
            msg = ErrorHandler.ERROR_CHECK_NETWORK_CONNECTION
            useDialog = false
        }
        if (shouldUseToast) {
            responseType = ResponseType.Toast()
        }
        if (useDialog) {
            responseType = ResponseType.Dialog()
        }

        onCompleteJob(DataState.error(Response(msg, responseType)))
    }

    fun setValue(dataState: DataState<ViewStateType>) {
        result.onNext(dataState)
    }

//    @UseExperimental(InternalCoroutinesApi::class)
//    private fun initNewJob(): Job {
//        Log.d(TAG, "initNewJob: called.")
//        job = Job() // create new job
//        job.invokeOnCompletion(
//            onCancelling = true,
//            invokeImmediately = true,
//            handler = object : CompletionHandler {
//                override fun invoke(cause: Throwable?) {
//                    if (job.isCancelled) {
//                        Log.e(TAG, "NetworkBoundResource: Job has been cancelled.")
//                        cause?.let {
//                            onErrorReturn(it.message, false, true)
//                        } ?: onErrorReturn("Unknown error.", false, true)
//                    } else if (job.isCompleted) {
//                        Log.e(TAG, "NetworkBoundResource: Job has been completed.")
//                        // Do nothing? Should be handled already
//                    }
//                }
//            })
//        coroutineScope = CoroutineScope(IO + job)
//        return job
//    }

    fun asObervable() = result as Observable<DataState<ViewStateType>>

    abstract  fun createCacheRequestAndReturn()

    abstract  fun handleApiSuccessResponse(response: ApiSuccessResponse<ResponseObject>)

    abstract fun createCall(): Observable<GenericApiResponse<ResponseObject>>

    abstract fun loadFromCache(): Observable<ViewStateType>

    abstract fun updateLocalDb(cacheObject: CacheObject?)

    abstract fun setJob(job: Job)

}















