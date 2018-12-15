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
import camp.codelab.fragments.adapter.CharacterAdapter
import camp.codelab.fragments.models.CharacterAnime
import camp.codelab.fragments.models.CharacterSearchResponse
import camp.codelab.fragments.retrofit.SearchInterface
import camp.codelab.fragments.utils.Consts
import camp.codelab.fragments.utils.gone
import camp.codelab.fragments.utils.visible
import kotlinx.android.synthetic.main.fragment_character.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharacterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchCharacter("Man")

        super.onViewCreated(view, savedInstanceState)
        characterSearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


                cirlceProgressBarCharacter.visible()

            }

            override fun afterTextChanged(s: Editable?) {
                searchCharacter(s.toString())
            }

        })
    }

    private fun searchCharacter(searchQuery: String) {
        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val characterInterface = retrofit.create(SearchInterface::class.java)
        characterInterface.searchCharacter(searchQuery)
                .enqueue(object : Callback<CharacterSearchResponse> {
                    override fun onFailure(call: Call<CharacterSearchResponse>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<CharacterSearchResponse>, response: Response<CharacterSearchResponse>) {


                        cirlceProgressBarCharacter?.gone()
                        response.body()?.let {
                            prepareRecycleView(it.results)
                        }

                    }
                })
    }

    fun prepareRecycleView(characterList: List<CharacterAnime>) {
        recycleViewCharacter?.layoutManager = GridLayoutManager(activity, 3)
        recycleViewCharacter?.adapter = CharacterAdapter(characterList)
    }
}
