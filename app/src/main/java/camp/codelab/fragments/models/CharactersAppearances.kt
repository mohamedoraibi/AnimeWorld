package camp.codelab.fragments.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CharactersAppearances(
        @SerializedName("mal_id")
        var malId: Int = 0, // 17265
        @SerializedName("type")
        var type: String = "", // anime
        @SerializedName("name")
        var name: String = "", // Log Horizon
        @SerializedName("url")
        var url: String = "" // https://myanimelist.net/anime/17265/Log_Horizon
) : Parcelable {
        constructor(source: Parcel) : this(
                source.readInt(),
                source.readString(),
                source.readString(),
                source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
                writeInt(malId)
                writeString(type)
                writeString(name)
                writeString(url)
        }

        companion object {
                @JvmField
                val CREATOR: Parcelable.Creator<CharactersAppearances> =
                        object : Parcelable.Creator<CharactersAppearances> {
                                override fun createFromParcel(source: Parcel): CharactersAppearances =
                                        CharactersAppearances(source)

                                override fun newArray(size: Int): Array<CharactersAppearances?> = arrayOfNulls(size)
                        }
        }
}