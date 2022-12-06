package com.example.academic_fest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val headingNews: TextView = findViewById(R.id.Heading)
        val mainNews: TextView = findViewById(R.id.news)
        val imageNews: ImageView = findViewById(R.id.image_Heading)

        val bundle : Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt(  "imageId")
        val news = bundle.getString("news")

        headingNews.text = heading
        mainNews.text = news
        imageNews.setImageResource(imageId)

    }

    fun intent(view: View) {
        val register = findViewById<Button>(R.id.intent)
        register.setOnClickListener{
            val intent= Intent( this,Bilhetes::class.java)
            startActivity(intent)
        }

    }
}