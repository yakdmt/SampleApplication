package xyz.yakdmt.sampleapplication.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.yakdmt.sampleapplication.data.entity.Project
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by yakdmt on 19/07/2017.
 */
@Singleton
class ProjectRepository
@Inject
constructor(private val gitHubService: GithubService) {

    fun getProjectList(userId: String): LiveData<List<Project>> {
        val data = MutableLiveData<List<Project>>()

        gitHubService.getProjectList(userId).enqueue(object : Callback<List<Project>> {
            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
                data.setValue(response.body())
            }

            override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                // TODO better error handling in part #2 ...
                data.setValue(null)
            }
        })

        return data
    }

    fun getProjectDetails(userID: String, projectName: String): LiveData<Project> {
        val data = MutableLiveData<Project>()

        gitHubService.getProjectDetails(userID, projectName).enqueue(object : Callback<Project> {
            override fun onResponse(call: Call<Project>, response: Response<Project>) {
                simulateDelay()
                data.setValue(response.body())
            }

            override fun onFailure(call: Call<Project>, t: Throwable) {
                // TODO better error handling in part #2 ...
                data.setValue(null)
            }
        })

        return data
    }

    private fun simulateDelay() {
        try {
            Thread.sleep(10)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}
