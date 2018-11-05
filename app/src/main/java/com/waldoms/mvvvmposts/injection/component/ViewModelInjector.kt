package com.waldoms.mvvvmposts.injection.component

import com.waldoms.mvvvmposts.injection.module.NetworkModule
import com.waldoms.mvvvmposts.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector
{
    fun inject(postListViewModel:PostListViewModel)

    @Component.Builder
    interface Builder
    {
        fun build():ViewModelInjector
        fun networkModule(networkModule:NetworkModule):Builder
    }
}