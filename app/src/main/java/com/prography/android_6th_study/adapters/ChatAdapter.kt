package com.prography.android_6th_study.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prography.android_6th_study.databinding.ItemMineChatBinding
import com.prography.android_6th_study.databinding.ItemOthersChatBinding
import com.prography.android_6th_study.models.ChatItem
import com.prography.android_6th_study.viewmodels.ChatViewModel

class ChatAdapter(var viewmodel: ChatViewModel) :
    ListAdapter<ChatItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> MyChatViewHolder(
                ItemMineChatBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            1 -> OtherChatViewHolder(
                ItemOthersChatBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> MyChatViewHolder(
                ItemMineChatBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return viewmodel.chatList.value?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyChatViewHolder) {
            viewmodel.chatList.value?.get(position)?.let { holder.bindTo(it) }
        } else if (holder is OtherChatViewHolder) {
            viewmodel.chatList.value?.get(position)?.let { holder.bindTo(it) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    class MyChatViewHolder(var binding: ItemMineChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: ChatItem) {

        }
    }

    class OtherChatViewHolder(var binding: ItemOthersChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: ChatItem) {

        }
    }

    companion object DIFF_CALLBACK : DiffUtil.ItemCallback<ChatItem>() {
        override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem.no == newItem.no
        }

        override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem == newItem
        }

    }
}