package com.prography.android_6th_study.adapters

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prography.android_6th_study.R
import com.prography.android_6th_study.databinding.ItemThemeBinding

class ThemeAdapter : RecyclerView.Adapter<ThemeAdapter.ThemeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeHolder {
        return ThemeHolder(
            ItemThemeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ThemeHolder, position: Int) {
        holder.bindTo(position)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addItemDecoration(ThemeItemDecoration())
    }

    class ThemeHolder(binding: ItemThemeBinding) : RecyclerView.ViewHolder(binding.root) {
        var bind: ItemThemeBinding = binding

        fun bindTo(position: Int) {
            bind.tvTitleItemTheme.text = when (position) {
                0 -> "달콤한 파라다이스, 휴양지"
                1 -> "올해 우리 가족 여행지는 여기"
                2 -> "배낭 여행객의 성지"
                else -> "달콤한 파라다이스, 휴양지"
            }
            Glide.with(bind.root)
                .load(
                    when (position) {
                        0 -> R.drawable.img_trip_theme_1
                        1 -> R.drawable.img_trip_theme_2
                        2 -> R.drawable.img_trip_theme_3
                        else -> R.drawable.img_trip_theme_1
                    }
                )
                .thumbnail(0.1f)
                .into(bind.ivBackgroundItemTheme)
        }
    }

    class ThemeItemDecoration : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
            super.getItemOffsets(outRect, itemPosition, parent)
            outRect.bottom = 40
        }
    }
}

