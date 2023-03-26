package com.example.testtaskansoft.feature.presentation.adapter

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class Animators : DefaultItemAnimator() {

    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        holder?.itemView?.animate()?.alpha(0.5f)
        holder?.itemView?.animate()?.translationX(holder.itemView.rootView.width.toFloat())
        holder?.itemView?.animate()?.alpha(0.0f)
        return true
    }
}