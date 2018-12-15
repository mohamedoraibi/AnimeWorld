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
import camp.codelab.fragments.adapter.MangaAdapter
import camp.codelab.fragments.models.Manga
import camp.codelab.fragments.models.MangaSearchResponse
import camp.codelab.fragments.retrofit.SearchInterface
import camp.codelab.fragments.utils.Consts
import camp.codelab.fragments.utils.gone
import camp.codelab.fragments.utils.visible
import kotlinx.android.synthetic.main.fragment_manga.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MangaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mangaSearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                circleProgressBarManga.visible()
            }

            override fun afterTextChanged(s: Editable?) {
                searchImageView2.gone()
                searchManga(s.toString())
            }

        })
    }

    private fun searchManga(searchQuery: String) {
        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val mangaInterface = retrofit.create(SearchInterface::class.java)
        mangaInterface.searchManga(searchQuery)
                .enqueue(object : Callback<MangaSearchResponse> {
                    override fun onFailure(call: Call<MangaSearchResponse>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<MangaSearchResponse>, response: Response<MangaSearchResponse>) {
                        circleProgressBarManga?.gone()
                        response.body()?.let {
                            prepareRecycleView(it.results)
                        }

                    }
                })
    }

    fun prepareRecycleView(mangaList: List<Manga>) {

        recycleViewManga?.layoutManager = GridLayoutManager(activity, 3)
        recycleViewManga?.adapter = MangaAdapter(mangaList)
    }
}
