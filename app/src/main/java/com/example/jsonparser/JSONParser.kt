package com.example.jsonparser

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

class JSONParser {
    private val TAG = javaClass.simpleName
    val userJson = "{\n" +
            "  \"name\": \"bha\",\n" +
            "  \"hobbies\": [\"dancing\",\"singing\"],\n" +
            "\"friends\": [\n" +
            "    {\n" +
            "      \"Fame\": \"Trevor\",\n" +
            "      \"friends\": [\n" +
            "        {\n" +
            "          \"name\": null,\n" +
            "          \"num\": 12\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"
    fun parseJSON(data: String){
        Log.d(TAG,"Bha")
        val jsonArray = JSONArray(data)
        for(i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i)
            if(jsonObject.getString("name").equals("Bob Johnson")){
                Log.d(TAG,"Email:  ${jsonObject.getString("email")}")
            }
        }

        val user = JSONObject(userJson)
        val hobbies = user.getJSONArray("hobbies")
        Log.d(TAG,"Hobbies: ${hobbies[1]}")
        val friends = user.getJSONArray("friends").getJSONObject(0)
        Log.d(TAG,"Name of friend: ${friends.getString("Fame")}")
        val hisFriends = friends.getJSONArray("friends")
        val hisFriendsName = hisFriends.getJSONObject(0).getString("name")
        Log.d(TAG,"His friend's name: $hisFriendsName ,  number: ${hisFriends.getJSONObject(0).getInt("num")}")
    }
}
