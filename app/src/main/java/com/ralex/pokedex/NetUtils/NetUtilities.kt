package com.ralex.pokedex.NetUtils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.io.Serializable
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetUtilities {

    companion object {

        val POKE_API_BASE_URL: String = "https://pokeapi.co/api/v2/pokemon?limit=964"

        fun verifyNetwork(activity: AppCompatActivity):Boolean{
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
            val networkInf = connectivityManager.activeNetworkInfo
            return networkInf != null && networkInf.isConnected
        }

        fun data():String {



            var inputStream : InputStream? = null

            try {

                val url = URL(POKE_API_BASE_URL)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connect()

                inputStream = connection.inputStream
                return inputStream.bufferedReader().use{
                    it.readText()
                }
            }finally {
                inputStream?.close()
            }
        }
    }
}
