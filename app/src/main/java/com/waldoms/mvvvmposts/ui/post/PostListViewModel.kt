package com.waldoms.mvvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.waldoms.mvvvmposts.R
import com.waldoms.mvvvmposts.base.BaseViewModel
import com.waldoms.mvvvmposts.model.Post
import com.waldoms.mvvvmposts.network.PostApi
import javax.inject.Inject
class PostListViewModel:BaseViewModel()
{
    @Inject

    lateinit var postApi:PostApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init
    {
        loadPosts()
    }

    override fun onCleared()
    {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts(){
        subscription = postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { onRetrievePostListSuccess() },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart()
    {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish()
    {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess()
    {
    }

    private fun onRetrievePostListError()
    {
    }
}