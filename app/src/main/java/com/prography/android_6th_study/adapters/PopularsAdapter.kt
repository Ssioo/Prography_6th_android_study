package com.prography.android_6th_study.adapters

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prography.android_6th_study.databinding.ItemPopularsBinding
import com.prography.android_6th_study.models.PopularsMyTrip
import com.prography.android_6th_study.viewmodels.MyTripViewModel

class PopularsAdapter(private val viewModel: MyTripViewModel) :
    ListAdapter<PopularsMyTrip, PopularsAdapter.PopularsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularsViewHolder {
        return PopularsViewHolder(
            ItemPopularsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return viewModel.popularsMyTripList.value!!.size;
    }

    override fun onBindViewHolder(holder: PopularsViewHolder, position: Int) {
        viewModel.popularsMyTripList.value?.get(position)?.let { holder.bindTo(it) }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addItemDecoration(PopularsItemDecoration())
    }

    class PopularsViewHolder(var binding: ItemPopularsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: PopularsMyTrip) {
            binding.tvTitleItemPopulars.text = item.title
            Glide.with(binding.root)
                .load(item.imgUrl)
                .thumbnail(0.1f)
                .into(binding.ivBackgroundItemPopulars)
        }
    }

    class PopularsItemDecoration : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.right = 20
        }
    }

    companion object DIFF_CALLBACK : DiffUtil.ItemCallback<PopularsMyTrip>() {
        override fun areItemsTheSame(oldItem: PopularsMyTrip, newItem: PopularsMyTrip): Boolean {
            return oldItem.no == newItem.no
        }

        override fun areContentsTheSame(oldItem: PopularsMyTrip, newItem: PopularsMyTrip): Boolean {
            return oldItem == newItem
        }
    }
}