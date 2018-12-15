package camp.codelab.fragments.models

import com.google.gson.annotations.SerializedName

data class CharacterSearchResponse(
        @SerializedName("results")
        var results: List<CharacterAnime> = listOf()
) : BaseSearchResponse()
