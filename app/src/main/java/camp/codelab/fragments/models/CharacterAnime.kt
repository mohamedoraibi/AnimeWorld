package camp.codelab.fragments.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CharacterAnime(
    @SerializedName("mal_id")
    var malId: Int = 0, // 134344
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/134344/Smoking_Lightning
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/8/294183.jpg?s=2abc6fe83b0151670935e0ab135332d7
    @SerializedName("name")
    var name: String = "", // Smoking Lightning
    @SerializedName("alternative_names")
    var alternativeNames: List<String> = listOf(),
    @SerializedName("anime")
    var anime: List<CharactersAppearances> = listOf(),
    @SerializedName("manga")
    var manga: List<CharactersAppearances> = listOf()
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.createStringArrayList(),
        source.createTypedArrayList(CharactersAppearances.CREATOR),
        source.createTypedArrayList(CharactersAppearances.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(malId)
        writeString(url)
        writeString(imageUrl)
        writeString(name)
        writeStringList(alternativeNames)
        writeTypedList(anime)
        writeTypedList(manga)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CharacterAnime> = object : Parcelable.Creator<CharacterAnime> {
            override fun createFromParcel(source: Parcel): CharacterAnime = CharacterAnime(source)
            override fun newArray(size: Int): Array<CharacterAnime?> = arrayOfNulls(size)
        }
    }
}