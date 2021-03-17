package com.banshion.broadcastbestpracticekotlin

import android.app.Activity

/**
 * @author hufei
 * @date 2021-03-11
 * @desc 单例类用于管理所有Activity
 */
object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }

}