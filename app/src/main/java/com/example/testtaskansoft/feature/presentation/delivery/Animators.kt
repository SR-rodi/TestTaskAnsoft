package com.example.testtaskansoft.feature.presentation.delivery

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class Animators:DefaultItemAnimator() {

    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        holder?.itemView?.animate()?.translationX(holder.itemView.rootView.width.toFloat())
        return true
    }
    override fun getMoveDuration(): Long {
        return 1000
    }

}