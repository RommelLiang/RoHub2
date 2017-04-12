package com.qiqiaoban.rommel.rohub.bean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import java.util.*

/**
 * Created by 梁文硕 on 2017/4/12.
 */

class Users {

    /**
     * login : defunkt
     * id : 2
     * avatar_url : https://avatars3.githubusercontent.com/u/2?v=3
     * gravatar_id :
     * url : https://api.github.com/users/defunkt
     * html_url : https://github.com/defunkt
     * followers_url : https://api.github.com/users/defunkt/followers
     * following_url : https://api.github.com/users/defunkt/following{/other_user}
     * gists_url : https://api.github.com/users/defunkt/gists{/gist_id}
     * starred_url : https://api.github.com/users/defunkt/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/defunkt/subscriptions
     * organizations_url : https://api.github.com/users/defunkt/orgs
     * repos_url : https://api.github.com/users/defunkt/repos
     * events_url : https://api.github.com/users/defunkt/events{/privacy}
     * received_events_url : https://api.github.com/users/defunkt/received_events
     * type : User
     * site_admin : true
     * name : Chris Wanstrath
     * company : @github
     * blog : http://chriswanstrath.com/
     * location : San Francisco
     * email : chris@github.com
     * hireable : true
     * bio : 🍔
     * public_repos : 107
     * public_gists : 273
     * followers : 16101
     * following : 208
     * created_at : 2007-10-20T05:24:19Z
     * updated_at : 2017-03-30T21:03:38Z
     */

    var login: String? = null
    var id: Int = 0
    var avatar_url: String? = null
    var gravatar_id: String? = null
    var url: String? = null
    var html_url: String? = null
    var followers_url: String? = null
    var following_url: String? = null
    var gists_url: String? = null
    var starred_url: String? = null
    var subscriptions_url: String? = null
    var organizations_url: String? = null
    var repos_url: String? = null
    var events_url: String? = null
    var received_events_url: String? = null
    var type: String? = null
    var isSite_admin: Boolean = false
    var name: String? = null
    var company: String? = null
    var blog: String? = null
    var location: String? = null
    var email: String? = null
    var isHireable: Boolean = false
    var bio: String? = null
    var public_repos: Int = 0
    var public_gists: Int = 0
    var followers: Int = 0
    var following: Int = 0
    var created_at: String? = null
    var updated_at: String? = null

    companion object {

        fun objectFromData(str: String): Users {

            return Gson().fromJson(str, Users::class.java)
        }

        fun objectFromData(str: String, key: String): Users? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), Users::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayUsersFromData(str: String): List<Users> {

            val listType = object : TypeToken<ArrayList<Users>>() {

            }.type

            return Gson().fromJson<List<Users>>(str, listType)
        }

        fun arrayUsersFromData(str: String, key: String): List<Users> {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<Users>>() {

                }.type

                return Gson().fromJson<List<Users>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
