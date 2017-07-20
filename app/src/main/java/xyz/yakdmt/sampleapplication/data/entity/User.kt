package xyz.yakdmt.sampleapplication.data.entity

import java.util.*

/**
 * Created by yakdmt on 19/07/2017.
 */
data class User (
    val login: String? = null,
    val id: Long = 0,
    val avatar_url: String? = null,
    val gravatar_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val followers_url: String? = null,
    val following_url: String? = null,
    val gists_url: String? = null,
    val starred_url: String? = null,
    val subscriptions_url: String? = null,
    val organizations_url: String? = null,
    val repos_url: String? = null,
    val events_url: String? = null,
    val received_events_url: String? = null,
    val type: String? = null,
    val name: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val email: String? = null,
    val public_repos: Int = 0,
    val public_gists: Int = 0,
    val followers: Int = 0,
    val following: Int = 0,
    val created_at: Date? = null,
    val updated_at: Date? = null
)