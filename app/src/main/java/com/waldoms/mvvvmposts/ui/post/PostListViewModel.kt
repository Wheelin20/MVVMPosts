package com.waldoms.mvvvmposts.ui.post

import com.waldoms.mvvvmposts.base.BaseViewModel
import com.waldoms.mvvvmposts.network.PostApi
import javax.inject.Inject

class PostListViewModel:BaseViewModel()
{
    @Inject
    lateinit var postApi:PostApi
}