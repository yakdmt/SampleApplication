package xyz.yakdmt.sampleapplication.data.entity

import java.util.*

/**
 * Created by yakdmt on 19/07/2017.
 */
data class Project (
    var id: Long = 0,
    var name: String = "",
    val full_name: String? = null,
    val owner: User? = null,
    val html_url: String? = null,
    val description: String? = null,
    val url: String? = null,
    val created_at: Date? = null,
    val updated_at: Date? = null,
    val pushed_at: Date? = null,
    val git_url: String? = null,
    val ssh_url: String? = null,
    val clone_url: String? = null,
    val svn_url: String? = null,
    val homepage: String? = null,
    val stargazers_count: Int = 0,
    val watchers_count: Int = 0,
    val language: String? = null,
    val has_issues: Boolean = false,
    val has_downloads: Boolean = false,
    val has_wiki: Boolean = false,
    val has_pages: Boolean = false,
    val forks_count: Int = 0,
    val open_issues_count: Int = 0,
    val forks: Int = 0,
    val open_issues: Int = 0,
    val watchers: Int = 0,
    val default_branch: String? = null
)
