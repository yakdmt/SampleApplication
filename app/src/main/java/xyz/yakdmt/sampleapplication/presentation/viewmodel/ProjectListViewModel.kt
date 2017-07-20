package xyz.yakdmt.sampleapplication.presentation.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import xyz.yakdmt.sampleapplication.data.entity.Project
import xyz.yakdmt.sampleapplication.data.repository.ProjectRepository
import javax.inject.Inject

/**
 * Created by yakdmt on 19/07/2017.
 */
class ProjectListViewModel @Inject
constructor(projectRepository: ProjectRepository, application: Application) : AndroidViewModel(application) {

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    val projectListObservable: LiveData<List<Project>>

    init {

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = projectRepository.getProjectList("Google")
    }
}
