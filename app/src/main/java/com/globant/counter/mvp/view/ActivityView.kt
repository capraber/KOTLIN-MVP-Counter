package com.globant.counter.mvp.view

import android.app.Activity
import android.app.FragmentManager
import android.content.Context

import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity>

    val activity: Activity?
        get() = activityRef.get()

    val context: Context?
        get() = activity

    val fragmentManager: FragmentManager?
        get() {
            val activity = activity
            return activity?.fragmentManager
        }

    init {
        activityRef = WeakReference(activity)
    }
}
