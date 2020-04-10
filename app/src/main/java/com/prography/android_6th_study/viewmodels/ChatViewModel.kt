package com.prography.android_6th_study.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prography.android_6th_study.BaseViewModel
import com.prography.android_6th_study.adapters.ChatAdapter
import com.prography.android_6th_study.models.ChatItem

class ChatViewModel : BaseViewModel() {

    var chatAdapter: ChatAdapter = ChatAdapter(this)

    var textToSend: ObservableField<String> = ObservableField()
    var chatList: LiveData<List<ChatItem>> = MutableLiveData(listOf())


}