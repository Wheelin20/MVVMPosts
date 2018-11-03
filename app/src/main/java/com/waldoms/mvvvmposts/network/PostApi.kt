package com.waldoms.mvvvmposts.network

import com.waldoms.mvvvmposts.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi
{
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}