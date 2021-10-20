package com.matveichuk.smartkids

import android.content.Context
import android.net.ConnectivityManager
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

        if (checkConnection(context)) {
            error.visibility = View.GONE
            btCheck.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.recycleList, AnimalVoiceFragment())
                .commit()
        } else {
            error.visibility = View.VISIBLE
            btCheck.visibility = View.VISIBLE
        }
        btCheck.setOnClickListener {
            recreate()
        }

    }

    fun checkConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}