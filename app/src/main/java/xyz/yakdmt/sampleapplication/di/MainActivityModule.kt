package xyz.yakdmt.sampleapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xyz.yakdmt.sampleapplication.presentation.view.ui.MainActivity

/**
 * Created by yakdmt on 19/07/2017.
 */
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    internal abstract fun contributeMainActivity(): MainActivity
}