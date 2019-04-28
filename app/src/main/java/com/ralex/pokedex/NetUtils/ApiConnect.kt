package com.ralex.pokedex.NetUtils

import android.net.Network
import android.os.AsyncTask
import com.ralex.pokedex.Interface.AuxInterface
import java.io.IOException

class ApiConnect (var auxListener: AuxInterface?): AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String): String {
        try {
            return NetUtilities.data()
        }catch (e: IOException){
            return "Error"
        }
        return "Error"
    }

    override fun onPostExecute(result: String) {
        try {
            auxListener?.finished(result)
        }catch (e:Exception){

        }
    }
}