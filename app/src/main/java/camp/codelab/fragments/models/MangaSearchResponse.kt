package camp.codelab.fragments.models

import com.google.gson.annotations.SerializedName

data class MangaSearchResponse(
        @SerializedName("results")
        var results: List<Manga> = listOf()
) : BaseSearchResponse()

