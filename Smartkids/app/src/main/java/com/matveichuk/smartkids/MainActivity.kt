package com.matveichuk.smartkids

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.matveichuk.smartkids.voicefragment.AnimalVoiceFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.matveichuk.smartkids.mainfragment.MainFragment
import com.matveichuk.smartkids.rightplacefragment.RightPlaceFragment
import com.matveichuk.smartkids.secondvoicefragment.SecondAnimalVoiceFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    var context: Context = this
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        val error = findViewById<TextView>(R.id.error)
        val btCheck = findViewById<Button>(R.id.btCheck)
        mAdView.loadAd(adRequest)

        if (isNetworkAvailable(context)) {
            error.visibility = View.GONE
            btCheck.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.recycleList, MainFragment())
                .commit()
        } else {
            error.visibility = View.VISIBLE
            btCheck.visibility = View.VISIBLE
        }
        btCheck.setOnClickListener {
            recreate()
        }

    }
    override fun onBackPressed(){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.to_right, R.anim.fade_out)
            .replace(R.id.recycleList, MainFragment())
            .commit()
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}