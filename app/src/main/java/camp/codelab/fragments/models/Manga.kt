package camp.codelab.fragments.models


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Manga(
        @SerializedName("mal_id")
        var malId: Int = 0, // 77419
        @SerializedName("url")
        var url: String = "", // https://myanimelist.net/manga/77419/Kiruto
        @SerializedName("image_url")
        var imageUrl: String = "", // https://cdn.myanimelist.net/images/manga/2/134043.jpg?s=e836117eb56accffdfc1485d8eedf123
        @SerializedName("title")
        var title: String = "", // Kiruto
        @SerializedName("publishing")
        var publishing: Boolean = false, // false
        @SerializedName("synopsis")
        var synopsis: String = "",
        @SerializedName("type")
        var type: String = "", // Manga
        @SerializedName("chapters")
        var chapters: Int = 0, // 0
        @SerializedName("volumes")
        var volumes: Int = 0, // 4
        @SerializedName("score")
        var score: Double = 0.0, // 0
        @SerializedName("start_date")
        var startDate: String = "", // 2002-02-06T00:00:00+00:00
        @SerializedName("end_date")
        var endDate: String = "", // 2003-05-06T00:00:00+00:00
        @SerializedName("members")
        var members: Int = 0 // 54
) : Parcelable {
        constructor(source: Parcel) : this(
                source.readInt(),
                source.readString(),
                source.readString(),
                source.readString(),
                1 == source.readInt(),
                source.readString(),
                source.readString(),
                source.readInt(),
                source.readInt(),
                source.readDouble(),
                source.readString(),
                source.readString(),
                source.readInt()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
                writeInt(malId)
                writeString(url)
                writeString(imageUrl)
                writeString(title)
                writeInt((if (publishing) 1 else 0))
                writeString(synopsis)
                writeString(type)
                writeInt(chapters)
                writeInt(volumes)
                writeDouble(score)
                writeString(startDate)
                writeString(endDate)
                writeInt(members)
        }

        companion object {
                @JvmField
                val CREATOR: Parcelable.Creator<Manga> = object : Parcelable.Creator<Manga> {
                        override fun createFromParcel(source: Parcel): Manga = Manga(source)
                        override fun newArray(size: Int): Array<Manga?> = arrayOfNulls(size)
                }
        }
}