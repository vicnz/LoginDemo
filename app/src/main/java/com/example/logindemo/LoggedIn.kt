package com.example.logindemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class LoggedIn : AppCompatActivity() {
    override fun onCreate(bundlesavestate: Bundle?){
        super.onCreate(bundlesavestate)
        setContentView(R.layout.logged_in)

        val closeBtn = findViewById<Button>(R.id.closeBtn)
        val userinfo = findViewById<TextView>(R.id.userInfo)

        val username : Bundle? = intent.extras

        if(username != null){
            userinfo.text = username.getString("username", "No User")
        }
        //close activity
        closeBtn.setOnClickListener {
            this.closeApplication()
        }
    }

    private fun closeApplication(){
        exitProcess(-1)
    }


}