package com.globant.counter.mvp.view

import android.app.Activity
import android.app.FragmentManager
import android.content.Context

import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    open  val activity: Activity?
        get() = activityRef.get()


}
