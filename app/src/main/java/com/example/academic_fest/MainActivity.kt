package com.example.academic_fest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun button2(view: View) {

        val secondButton = findViewById<Button>(R.id.bt2)
        secondButton.setOnClickListener{
            val intent= Intent( this,MainMenu::class.java)
            startActivity(intent)
        }
    }

    fun button3(view: View) {
        val register = findViewById<Button>(R.id.Button3)
        register.setOnClickListener{
            val intent= Intent( this,Register::class.java)
            startActivity(intent)
        }
    }
}