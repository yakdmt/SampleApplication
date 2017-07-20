package xyz.yakdmt.sampleapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xyz.yakdmt.sampleapplication.presentation.view.ui.ProjectFragment
import xyz.yakdmt.sampleapplication.presentation.view.ui.ProjectListFragment

/**
 * Created by yakdmt on 19/07/2017.
 */
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    internal abstract fun contributeProjectFragment(): ProjectFragment

    @ContributesAndroidInjector
    internal abstract fun contributeProjectListFragment(): ProjectListFragment
}