package camp.codelab.fragments.models

import com.google.gson.annotations.SerializedName


data class AnimeSearchResponse(
        @SerializedName("results")
        var results: List<Anime> = listOf()
) : BaseSearchResponse()



