package camp.codelab.fragments.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import camp.codelab.fragments.R
import camp.codelab.fragments.models.Anime
import camp.codelab.fragments.retrofit.SearchInterface
import camp.codelab.fragments.utils.Consts
import kotlinx.android.synthetic.main.activity_anime_scrolling.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_scrolling)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val animeInterface = retrofit.create(SearchInterface::class.java)

        val id = intent.getStringExtra("ID")

        animeInterface.getAnimeInfo(id = id)
                .enqueue(object : Callback<Anime> {
                    override fun onFailure(call: Call<Anime>, t: Throwable) {
                        Toast.makeText(this@AnimeActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
//
//                        response.body()?.let {
//                            toolbar_layout.title = it.title
//                            descripntionOfAnime.text = it.descriptionAnime
////                            supportActionBar!!.title=it.title
////                            supportActionBar!!.subtitle=it.year
//                            imageAnimePoster.setImageFromUrl(it.poster)
////                            Picasso.get()
////                                    .load(it.poster)
////                                    .into(posterImageView)
//                            var websiteLink = it.websiteURL
//                            fab.setOnClickListener() {
//
//                                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteLink)))
//                            }
//                        }
                    }
                })


    }


}
