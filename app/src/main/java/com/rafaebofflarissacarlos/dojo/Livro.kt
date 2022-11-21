package com.rafaebofflarissacarlos.dojo

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class Livro(
    val id: Int?,
    val titulo: String?,
    val paginas: Int,
    val paginasLidas: Int,
    val tipo: String?,
    val autor: String?,
//    var lido: Boolean

):Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
//        parcel.readBoolean(),
    ) {
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(titulo)
        parcel.writeInt(paginas)
        parcel.writeInt(paginasLidas)
        parcel.writeString(tipo)
        parcel.writeString(autor)
//        parcel.writeBoolean(lido)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Livro> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Livro {
            return Livro(parcel)
        }

        override fun newArray(size: Int): Array<Livro?> {
            return arrayOfNulls(size)
        }
    }
}