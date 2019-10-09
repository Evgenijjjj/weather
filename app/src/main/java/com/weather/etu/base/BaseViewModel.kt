package com.weather.etu.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel: ViewModel() {
    protected val disposable = CompositeDisposable()

    val errorLivaData = MutableLiveData<Throwable>()

    protected fun <T> Single<T>.safeSubscribe(onSuccess: (T) -> Unit) =
        subscribeOn(Schedulers.io()).subscribe(onSuccess, errorLivaData::postValue)

    protected fun <T> Maybe<T>.safeSubscribe(onSuccess: (T) -> Unit) =
        subscribeOn(Schedulers.io()).subscribe(onSuccess, errorLivaData::postValue)

    protected fun Completable.safeSubscribe(onSuccess: () -> Unit) =
        subscribeOn(Schedulers.io()).subscribe(onSuccess, errorLivaData::postValue)

    protected fun <T> Observable<T>.safeSubscribe(onSuccess: (T) -> Unit) =
        subscribeOn(Schedulers.io()).subscribe(onSuccess, errorLivaData::postValue)

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}