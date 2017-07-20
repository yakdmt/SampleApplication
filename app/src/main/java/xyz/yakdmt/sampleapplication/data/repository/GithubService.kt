package xyz.yakdmt.sampleapplication.data.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import xyz.yakdmt.sampleapplication.data.entity.Project

/**
 * Created by yakdmt on 19/07/2017.
 */
interface GithubService {

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Call<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>

    companion object {
        val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }
}
