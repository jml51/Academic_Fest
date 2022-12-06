package com.example.academic_fest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.academic_fest.databinding.ActivityMapsBinding
import com.google.android.material.navigation.NavigationView

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
            val intent3 = Intent( this,Bilhetes::class.java)
            val intent4 = Intent( this,MainActivity::class.java)
            val intent5 = Intent( this,MapsActivity::class.java)

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
                    startActivity(intent5)

            }
            true
        }
        // -------------------  drawer-------------------------//

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val viana = LatLng(41.694501, -8.846950)
        mMap.addMarker(MarkerOptions().position(viana).title("Marker in Viana"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(viana))
        mMap.setMinZoomPreference(14F)}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return  true
        }

        return super.onOptionsItemSelected(item)
    }

    // -------------------  drawer-------------------------//
    }