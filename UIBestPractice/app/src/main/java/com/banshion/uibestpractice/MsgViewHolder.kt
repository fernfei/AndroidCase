package com.banshion.uibestpractice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.msg_left_item.view.*
import kotlinx.android.synthetic.main.msg_right_item.view.*

sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)
class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val leftMsg: TextView = view.lefMsg
}
class RightViewHolder(view: View) : MsgViewHolder(view) {
    val rightMsg: TextView = view.rightMsg
}