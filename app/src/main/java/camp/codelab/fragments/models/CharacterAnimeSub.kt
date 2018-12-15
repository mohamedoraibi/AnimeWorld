package camp.codelab.fragments.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CharacterAnimeSub(

        @SerializedName("mal_id")
        var malId: String = "",
        @SerializedName("type")
        var type: String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("url")
        var url: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(malId)
        writeString(type)
        writeString(name)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CharacterAnimeSub> = object : Parcelable.Creator<CharacterAnimeSub> {
            override fun createFromParcel(source: Parcel): CharacterAnimeSub = CharacterAnimeSub(source)
            override fun newArray(size: Int): Array<CharacterAnimeSub?> = arrayOfNulls(size)
        }
    }
}