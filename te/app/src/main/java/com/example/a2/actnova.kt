package com.example.a2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class actnova : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actnova)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(param_1name)

        val textView = findViewById<TextView>(R.id.text3).apply {
            text = message
        }
    }


    fun oncli(view: View) {
        var edit1 = findViewById<EditText>(R.id.edit)
        //Toast.makeText(this, edit1.text, Toast.LENGTH_SHORT).show()
        findViewById<TextView> (R.id.text).setText(edit1.text)

        //findViewById<TextView>(R.id.txt1).setText(editTextHello.text)

    }
}