package xyz.yakdmt.sampleapplication

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import xyz.yakdmt.sampleapplication.di.AppInjector
import xyz.yakdmt.sampleapplication.di.ViewModelSubComponent
import javax.inject.Inject

/**
 * Created by yakdmt on 19/07/2017.
 */
class SampleApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}

