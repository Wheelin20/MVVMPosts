package com.waldoms.mvvvmposts.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

import com.waldoms.mvvvmposts.network.PostApi

@Module
@Suppress("unused")
object NetworkModule
{
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): PostApi
    {
        return retrofit.create(PostApi::class.java)
    }
}