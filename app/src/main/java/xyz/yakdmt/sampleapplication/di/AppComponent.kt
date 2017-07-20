package xyz.yakdmt.sampleapplication.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import xyz.yakdmt.sampleapplication.SampleApplication
import javax.inject.Singleton

/**
 * Created by yakdmt on 19/07/2017.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, MainActivityModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }
    abstract fun inject(sampleApplication: SampleApplication)
}