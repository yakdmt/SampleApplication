package xyz.yakdmt.sampleapplication.presentation.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.databinding.ObservableField
import android.util.Log
import xyz.yakdmt.sampleapplication.data.entity.Project
import xyz.yakdmt.sampleapplication.data.repository.ProjectRepository
import javax.inject.Inject

/**
 * Created by yakdmt on 19/07/2017.
 */
class ProjectViewModel @Inject
constructor(projectRepository: ProjectRepository, application: Application) : AndroidViewModel(application) {
    init {

        ABSENT.value = null
    }

    val projectObservable: LiveData<Project>
    private val projectID: MutableLiveData<String>

    var project: ObservableField<Project> = ObservableField()

    init {

        this.projectID = MutableLiveData<String>()

        projectObservable = Transformations.switchMap<String, Project>(projectID) { input ->
            if (input.isEmpty()) {
                Log.i(TAG, "ProjectViewModel projectID is absent!!!")
            }

            Log.i(TAG, "ProjectViewModel projectID is " + projectID.value!!)

            projectRepository.getProjectDetails("Google", projectID.value!!)
        }
    }

    fun setProject(project: Project) {
        this.project.set(project)
    }

    fun setProjectID(projectID: String) {
        this.projectID.value = projectID
    }

    companion object {
        private val TAG = ProjectViewModel::class.java.name
        private val ABSENT = MutableLiveData<ProjectViewModel>()
    }
}