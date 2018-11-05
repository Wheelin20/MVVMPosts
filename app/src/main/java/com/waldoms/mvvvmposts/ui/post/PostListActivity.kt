package com.waldoms.mvvvmposts.ui.post

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.waldoms.mvvvmposts.R
import com.waldoms.mvvvmposts.databinding.ActivityPostListBinding

class PostListActivity: AppCompatActivity()
{
    private lateinit var binding: ActivityPostListBinding
    private lateinit var viewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        binding.viewModel = viewModel
    }
}