package com.example.logindemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(bundlesavestate: Bundle?) {
        super.onCreate(bundlesavestate)
        setContentView(R.layout.activity_main)

        val logBtn = findViewById<Button>(R.id.loginBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        //button clicked for exit
        exitBtn.setOnClickListener {
            this.exitApp()
        }

        //button clicked for login
        logBtn.setOnClickListener {
            val usernameTextBox = findViewById<EditText>(R.id.usernameTxtBx)
            val passwordTextBox = findViewById<EditText>(R.id.passwordTxtBx)

            val username  = usernameTextBox.text.toString().toLowerCase()
            val password = passwordTextBox.text.toString().toLowerCase()

            this.validateUser(username, password)
        }
    }


    private fun validateUser(username: String?, password: String?){

        /*
        *   @By Default our username and password are
        *   @username = admin
        *   @password = admin
        *
        * anything else is return of invalid user
        * due to knowledge limitation i have not yet grasp the concept
        * of database operation in android so we'll hard code the valid user
         */

        if(username != ""){
            if(password != "" || password == "admin"){
                //render valid user
                val intent = Intent(this, LoggedIn::class.java)
                intent.putExtra("username", username)

                startActivity(intent)
            }else{
                //render invalid user
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show()
            }
        }else{
           //render  invalid user
            Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show()
        }

    }

    private fun exitApp() {
        exitProcess(-1)
    }
}