package xyz.yakdmt.sampleapplication.di

import dagger.Subcomponent
import xyz.yakdmt.sampleapplication.presentation.viewmodel.ProjectListViewModel
import xyz.yakdmt.sampleapplication.presentation.viewmodel.ProjectViewModel

/**
 * Created by yakdmt on 19/07/2017.
 */
@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun projectListViewModel(): ProjectListViewModel
    fun projectViewModel(): ProjectViewModel
}