package com.example.jsonparser

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

class JSONParser {
    private val TAG = javaClass.simpleName
    val data = ("[\n" +
            "  {\n" +
            "    \"date\": \"2023-12-21\",\n" +
            "    \"time\": \"14:30:00\",\n" +
            "    \"name\": \"John Doe\",\n" +
            "    \"email\": \"john.doe@example.com\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\": \"2023-12-22\",\n" +
            "    \"time\": \"09:45:00\",\n" +
            "    \"name\": \"Jane Smith\",\n" +
            "    \"email\": \"jane.smith@example.com\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\": \"2023-12-23\",\n" +
            "    \"time\": \"18:15:00\",\n" +
            "    \"name\": \"Bob Johnson\",\n" +
            "    \"email\": \"bob.johnson@example.com\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\": \"2023-12-31\",\n" +
            "    \"time\": \"20:00:00\",\n" +
            "    \"name\": \"Alice Williams\",\n" +
            "    \"email\": \"alice.williams@example.com\"\n" +
            "  }\n" +
            "]")
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
    fun parseJSON(){
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
