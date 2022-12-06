package com.example.academic_fest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.academic_fest.adapter.MyAdapter
import com.example.academic_fest.adapter.News
import com.google.android.material.navigation.NavigationView

lateinit var toggle : ActionBarDrawerToggle

private lateinit var newRecyclerview: RecyclerView
private lateinit var newArrayList: ArrayList<News>

lateinit var imageId : Array<Int>
lateinit var heading : Array<String>
lateinit var news:     Array<String>


class Bilhetes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bilhetes)


        //------------ dreawer----------//
        var drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout2)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle( this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            val intent= Intent( this,MainMenu::class.java)
            val intent2= Intent( this,Bilhetes::class.java)
            val intent3= Intent( this,Perfil::class.java)
            val intent4= Intent( this,MainActivity::class.java)

            when(it.itemId){

                R.id.nav_home ->
                    startActivity(intent)

                R.id.nav_bilhetes ->
                    startActivity(intent2)

                R.id.nav_perfil ->
                    startActivity(intent3)

                R.id.nav_logout ->
                    startActivity(intent4)

            }
            true
        }
        //------------ dreawer----------//

        imageId = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.c,
            R.drawable.d,


            )

        heading = arrayOf(
            "Semana academica Viana do castelo",
            "Enterro da gata",
            "Local trains to be suspended in Bengal from tomorrow in view of covid-19",
            "MHA asks states,UTs to ensure there are no fires in hospitals",
            "Australian citizen sues PM Morrison over flight ban from india",
            "Former India hockey coach Kaushik hospitalised after testing positive for COVID",
            "Delhi records 20,960 fresh covid-19 infections, positivity rate at 26.37%",
            "Barcelona church offers open-air space for Ramadan",
            "Trillions of cicadas set to emerge in the US, here's why",
            "Homemaker, economist: Cadidates from all walks of life in Bengal assembly"
        )

        news = arrayOf(

                    getString(R.string.news_a),
                    getString(R.string.news_b)
        )

        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager( this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserdata()



    }
    //------------ dreawer----------//
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return  true
        }

        return super.onOptionsItemSelected(item)
    }
    //------------ dreawer----------//

    private fun getUserdata(){
        for(i in imageId. indices){
            val news = News(imageId[i],heading[i])
            newArrayList.add(news)

        }

        var adapter =  MyAdapter(newArrayList)
        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@Bilhetes, "boas a todos $position", Toast.LENGTH_SHORT).show()

                val intent= Intent(this@Bilhetes,NewsActivity::class.java)
                intent.putExtra("heading", newArrayList[position].heading)
                intent.putExtra("imageId", newArrayList[position].tittleImage)
                intent.putExtra("news", news[position])

                startActivity(intent)

            }


        })
    }

}