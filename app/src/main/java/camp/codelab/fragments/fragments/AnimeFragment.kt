package camp.codelab.fragments.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import camp.codelab.fragments.R
import camp.codelab.fragments.adapter.AnimeAdapter
import camp.codelab.fragments.models.Anime
import camp.codelab.fragments.models.AnimeSearchResponse
import camp.codelab.fragments.retrofit.SearchInterface
import camp.codelab.fragments.utils.Consts
import camp.codelab.fragments.utils.gone
import camp.codelab.fragments.utils.visible
import kotlinx.android.synthetic.main.fragment_anime.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AnimeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animeSearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                searchAnime(s.toString())
            }

        })
    }

    private fun searchAnime(searchQuery: String) {
        cirlceProgressBarAnime.visible()
        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val animeInterface = retrofit.create(SearchInterface::class.java)
        animeInterface.searchAnime(searchQuery)
            .enqueue(object : Callback<AnimeSearchResponse> {
                override fun onFailure(call: Call<AnimeSearchResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    cirlceProgressBarAnime?.gone()
                }

                override fun onResponse(call: Call<AnimeSearchResponse>, response: Response<AnimeSearchResponse>) {
                    cirlceProgressBarAnime?.gone()
                    response.body()?.let {
                        prepareRecycleView(it.results)
                    }

                }
            })
    }

    fun prepareRecycleView(animeList: List<Anime>) {
        recycleViewAnime?.layoutManager = GridLayoutManager(activity, 3)
        recycleViewAnime?.adapter = AnimeAdapter(animeList)
    }
}
