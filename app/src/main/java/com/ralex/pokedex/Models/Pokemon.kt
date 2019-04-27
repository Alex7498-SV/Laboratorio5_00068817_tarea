package com.ralex.pokedex.Models

import android.os.Parcel
import android.os.Parcelable

data class Pokemon( val id: String = "N/M", val name: String = "N/M", val weight: String = "N/M", val baseExp: String = "N/M", val height: String = "N/M"): Parcelable{
    constructor(parcel: Parcel) : this(
        id = parcel.readString(),
        name = parcel.readString(),
        weight = parcel.readString(),
        baseExp = parcel.readString(),
        height = parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(weight)
        parcel.writeString(baseExp)
        parcel.writeString(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }

}
