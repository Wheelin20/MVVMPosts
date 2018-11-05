package com.waldoms.mvvvmposts.base

import android.arch.lifecycle.ViewModel
import com.waldoms.mvvvmposts.injection.component.DaggerViewModelInjector
import com.waldoms.mvvvmposts.injection.component.ViewModelInjector
import com.waldoms.mvvvmposts.injection.module.NetworkModule
import com.waldoms.mvvvmposts.ui.post.PostListViewModel

abstract class BaseViewModel : ViewModel()
{
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init
    {
        inject()
    }

    private fun inject()
    {
        when(this)
        {
            is PostListViewModel -> injector.inject(this)
        }
    }
}