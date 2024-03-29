package com.example.academic_fest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Perfil : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        var drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout2)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle( this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            val intent= Intent( this,MainMenu::class.java)
            val intent2= Intent( this,Perfil::class.java)
            val intent3= Intent( this,Bilhetes::class.java)
            val intent4= Intent( this,MainActivity::class.java)
            val intent5= Intent( this,MapsActivity::class.java)

            when(it.itemId){

                R.id.nav_home ->
                    startActivity(intent)

                R.id.nav_bilhetes ->
                    startActivity(intent3)

                R.id.nav_perfil ->
                    startActivity(intent2)

                R.id.nav_logout ->
                    startActivity(intent4)
                R.id.nav_mapa ->
                    startActivity(intent4)

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return  true
        }

        return super.onOptionsItemSelected(item)
    }
}