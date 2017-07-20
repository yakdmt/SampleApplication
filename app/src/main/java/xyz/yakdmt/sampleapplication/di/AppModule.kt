package xyz.yakdmt.sampleapplication.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.yakdmt.sampleapplication.data.repository.GithubService
import xyz.yakdmt.sampleapplication.presentation.viewmodel.ProjectViewModelFactory
import javax.inject.Singleton

/**
 * Created by yakdmt on 19/07/2017.
 */
@Module(subcomponents = arrayOf(ViewModelSubComponent::class))
internal class AppModule {
    @Singleton
    @Provides
    fun provideGithubService(): GithubService {
        return Retrofit.Builder()
                .baseUrl(GithubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(
            viewModelSubComponent: ViewModelSubComponent.Builder): ViewModelProvider.Factory {

        return ProjectViewModelFactory(viewModelSubComponent.build())
    }
}
