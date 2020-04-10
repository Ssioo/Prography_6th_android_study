package com.prography.android_6th_study.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prography.android_6th_study.BaseActivity
import com.prography.android_6th_study.R
import com.prography.android_6th_study.databinding.ActivityChatBinding
import com.prography.android_6th_study.viewmodels.ChatViewModel

class ChatActivity : BaseActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var vmChat: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        vmChat = ViewModelProvider(this)[ChatViewModel::class.java]
        binding.viewmodel = vmChat

        /* ActionBar */
        setSupportActionBar(binding.tbChat)
        var actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back)

        /* RecyclerView */
        binding.rvChat.adapter = vmChat.chatAdapter

        /* ChatList */
        vmChat.chatList.observe(this, Observer { list -> vmChat.chatAdapter.submitList(list) })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}