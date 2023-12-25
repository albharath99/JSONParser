package com.example.jsonparser

import android.content.res.AssetManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = getJson()
        val parser = JSONParser()
        parser.parseJSON(json)
    }
    private fun getJson(): String{
        val manager: AssetManager = applicationContext.assets
        val file = manager.open("data.json")
        val formArray = ByteArray(file.available())
        file.read(formArray)
        file.close()
        return String(formArray)
    }
}