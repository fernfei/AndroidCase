package com.banshion.uibestpractice

import java.lang.StringBuilder

/**
 * 消息实体类
 */
class Msg(val content: String, val type: Int) {
    companion object {
        const val TYPE_RECEIVED = 0//表示这是一条收到的消息
        const val TYPE_SENT = 1//表示这是一条发出去的消息
    }
}