package camp.codelab.fragments.retrofit

import camp.codelab.fragments.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchInterface {


    @GET("search/anime")
    fun searchAnime(@Query("q") searchQuery: String): Call<AnimeSearchResponse>

    @GET(".")
    fun getAnimeInfo(@Query("q") id: String): Call<Anime>
    @GET(".")
    fun getMangaInfo(@Query("q") id: String): Call<Manga>
    @GET(".")
    fun getCharacterInfo(@Query("q") id: String): Call<CharacterAnime>

    @GET("search/manga")
    fun searchManga(@Query("q") searchQuery: String): Call<MangaSearchResponse>

    @GET("search/character")
    fun searchCharacter(@Query("q") searchQuery: String): Call<CharacterSearchResponse>
}