package mx.ipn.cic.googlemapsexample

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Si fuera un fragment, se debe invocar en el método "onAttach"
        loadMap()
    }

    private fun loadMap() {

        //Validar permisos de ubicación.
        if (
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            val permissions = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            requestPermissions(
                permissions,
                999
            )

        } else {

            val gmMap =
                supportFragmentManager.findFragmentById(R.id.gmMap) as SupportMapFragment

            gmMap.getMapAsync { googleMap ->

                this.googleMap = googleMap
                this.googleMap.isMyLocationEnabled = true

                moveCamera()

                addMarks()

            }

        }
    }

    private fun addMarks() {

        val acapulcoMark = MarkerOptions()
        acapulcoMark.position(
            LatLng(16.8354485, -99.9323491)
        )
        acapulcoMark.title("Acapulco")

        val gmMarkZocalo = MarkerOptions()
        gmMarkZocalo.position(LatLng(19.4326068, -99.1353989))
        gmMarkZocalo.title("Zócalo CDMX")
        gmMarkZocalo.icon(
            BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)
        )

        val gmMarkMazatlan = MarkerOptions()
        gmMarkMazatlan.position(LatLng(23.2468188, -106.4573823))
        gmMarkMazatlan.title("Sucursal Mazatlán")
        gmMarkMazatlan.icon(
            BitmapDescriptorFactory.fromResource(R.drawable.pin_store)
        )

        this.googleMap.addMarker(acapulcoMark)
        this.googleMap.addMarker(gmMarkZocalo)
        this.googleMap.addMarker(gmMarkMazatlan)

    }

    @SuppressLint("MissingPermission")
    private fun moveCamera() {
        /** ZOOM:
        1: World
        5: Landmass/continent
        10: City
        15: Streets
        20: Buildings
         */
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(
            LatLng(19.4326018, -99.1332049),
            5f
        )

        //this.googleMap.moveCamera(cameraUpdate)
        this.googleMap.animateCamera(cameraUpdate)

        /*val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            5000,
            10f
        ) { location ->
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                LatLng(location.latitude, location.longitude),
                10f
            )
            this.googleMap.animateCamera(cameraUpdate)
        }*/

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 999) {
            loadMap()
        }
    }

}