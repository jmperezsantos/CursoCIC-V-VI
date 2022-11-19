package mx.ipn.cic.locationmanagerexample.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.getSystemService
import mx.ipn.cic.locationmanagerexample.R

class LocationFragment : Fragment() {

    private lateinit var locationManager: LocationManager

    private lateinit var tvLocations: TextView

    companion object {
        @JvmStatic
        fun newInstance() =
            LocationFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_location,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.tvLocations = view.findViewById(R.id.tvLocations)
    }

    //Se ejecuta cuando el fragmento es "pegado" a la Actividad
    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.startLocationCollection()
    }

    private fun startLocationCollection() {

        val finePermission = ActivityCompat.checkSelfPermission(
            this.requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val coarsePermission = ActivityCompat.checkSelfPermission(
            this.requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        if (finePermission != PackageManager.PERMISSION_GRANTED ||
            coarsePermission != PackageManager.PERMISSION_GRANTED
        ) {
            val permissionLauncher = registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {
                    Log.d("MPS", "Los permisos se han otorgado")

                    //Para empezar la colecta
                    startLocationCollection()
                } else {
                    Log.e("MPS", "Los permisos NO se han otorgado")
                }
            }

            //Se pide el permiso "ubicación fina"
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {

            //Sensores
            val sensorManager =
                this.requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
            val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
            sensorManager.registerListener(
                object : SensorEventListener {
                    override fun onSensorChanged(event: SensorEvent?) {
                        Log.i("MPS", "E: ${event!!.values[0]} ${event!!.values[1]} ${event!!.values[2]}")
                    }
                    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                        Log.i("MPS", "${sensor?.name}")
                    }
                },
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )

            this.locationManager =
                this.requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager

            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000, // 5 segundos
                10f, // 10 metros
                object : LocationListener {
                    override fun onLocationChanged(location: Location) {

                        Log.i("MPS", "Latitud: ${location.latitude}")
                        Log.i("MPS", "Longitude: ${location.longitude}")
                        Log.i("MPS", "Altitude: ${location.altitude}")

                        val text: String = tvLocations.text.toString()
                        tvLocations.text =
                            "$text \n Latitude: ${location.latitude}" +
                                    "\n Longitude: ${location.longitude}" +
                                    "\n Altitud: ${location.altitude}"

                    }
                }
            )
        }
    }

    /*override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 999) {
            if (
                grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
                Log.d("MPS", "Los permisos se han otorgado")

                //Para empezar la colecta
                startLocationCollection()
            } else {
                Log.e("MPS", "Los permisos NO se han otorgado")
            }
        }

    }*/

}