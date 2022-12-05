package com.example.academic_fest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.academic_fest.Slider.ViewPagerAdapter
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.delay

class MainMenu : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)


        //------------slider-------------------//
        viewPager = findViewById(R.id.viewPager2)
        val imageList = listOf(R.drawable.image1, R.drawable.image2,R.drawable.a,
            R.drawable.b,R.drawable.c,R.drawable.d)
        val adapter = ViewPagerAdapter(imageList)
        viewPager.adapter = adapter
        viewPager.autoScroll(lifecycleScope, 1200 )
        //------------slider-------------------//





        // -------------------  drawer-------------------------//

        var drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle( this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            val intent = Intent( this,MainMenu::class.java)
            val intent2 = Intent( this,Perfil::class.java)

            when(it.itemId){

                R.id.nav_home ->

                    startActivity(intent)

                R.id.nav_bilhetes ->
                    Toast.makeText(applicationContext,"clicked bilhetes", Toast.LENGTH_SHORT).show()

                R.id.nav_perfil ->
                    startActivity(intent2)

            }
            true
        }
    }

    private fun ViewPager2.autoScroll(lifeCycleScope: LifecycleCoroutineScope, interval: Long ){
        lifeCycleScope.launchWhenResumed{
            scrollIndefinitely(interval)
        }
    }


    private  suspend fun ViewPager2.scrollIndefinitely(interval: Long){
        delay(interval)
        val numberOfItems = adapter?.itemCount ?:0
        val lastIndex = if(numberOfItems>0) numberOfItems-4 else 0
        val nextItem = if(currentItem==lastIndex) 0 else currentItem+1
        setCurrentItem(nextItem, true)
        scrollIndefinitely(interval)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         if(toggle.onOptionsItemSelected(item)){

             return  true
         }

        return super.onOptionsItemSelected(item)
    }

    // -------------------  drawer-------------------------//


}