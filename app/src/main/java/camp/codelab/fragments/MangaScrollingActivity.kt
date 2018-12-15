package camp.codelab.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import camp.codelab.fragments.models.Anime
import camp.codelab.fragments.models.Manga
import camp.codelab.fragments.retrofit.SearchInterface
import camp.codelab.fragments.utils.Consts
import camp.codelab.fragments.utils.setImageFromUrl
import kotlinx.android.synthetic.main.activity_manga_scrolling.*
import kotlinx.android.synthetic.main.content_manga_scrolling.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MangaScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_scrolling)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val manga = intent.getParcelableExtra<Manga>("MANGA")

        toolbar_layout.title = manga.title
        titleMangaTextView.text = manga.title
        mangaDescriptionTextView.text = manga.synopsis
        imageMangaPoster.setImageFromUrl(manga.imageUrl)
        var websiteLink = manga.url
        fabManga.setOnClickListener() {

            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteLink)))
        }

    }
}
