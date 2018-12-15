package camp.codelab.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import camp.codelab.fragments.models.Anime
import camp.codelab.fragments.utils.gone
import camp.codelab.fragments.utils.setImageFromUrl
import kotlinx.android.synthetic.main.activity_anime_scrolling.*
import kotlinx.android.synthetic.main.content_anime_scrolling.*

class AnimeScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_scrolling)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val anime: Anime = intent.getParcelableExtra("ANIME")

        toolbar_layout.title = anime.title
        titleAnimeTextView.text = anime.rated
        typeAnime.text = anime.type
        animeDescriptionTextView.text = anime.synopsis
        imageAnimePoster.setImageFromUrl(anime.imageUrl)
        var websiteLink = anime.url
        if (websiteLink != ""){
            fab.setOnClickListener() {

                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteLink)))
            }
        }
        else{
            fab.gone()
        }

    }
}
