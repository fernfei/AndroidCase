package com.banshion.uibestpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.msg_left_item.view.*
import kotlinx.android.synthetic.main.msg_right_item.view.*

class MsgAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {



    override fun getItemViewType(position: Int): Int {
        return msgList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder =
        if (viewType == Msg.TYPE_RECEIVED) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            LeftViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            RightViewHolder(view)
        }

    override fun getItemCount() = msgList.size

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }



}