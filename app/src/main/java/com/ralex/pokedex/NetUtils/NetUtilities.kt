package com.ralex.pokedex.NetUtils

import android.net.Uri
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.io.Serializable
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetUtilities {

    val POKE_API_BASE_URL: String = "https://pokeapi.co/api/v2/pokemon?limit=964"


    fun buildUrl(root: String, pokemonID:String): URL {
        val buildUri: Uri = Uri.parse(POKE_API_BASE_URL)
            .buildUpon()
            .build()

        val url = try {
            URL(buildUri.toString())
        } catch (e: MalformedURLException ){
            URL("")

        }

        Log.d("Net", "Url formada: ${url}")
        return url
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url:URL):String{

        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection

        try {
            Log.d("Cmurio", "c Conecto")
            val `input` : InputStream = urlConnection.inputStream
            Log.d("Cmurio", "c Conecto")
            val scn: Scanner = Scanner(`input`)
            scn.useDelimiter("\\A")

            val hasInput: Boolean = scn.hasNext()

            Log.d("Cmurio", scn.toString())

            return if (hasInput){
                scn.next()
            } else {
                ""
            }
        }finally {
            urlConnection.disconnect()
        }
    }
}
