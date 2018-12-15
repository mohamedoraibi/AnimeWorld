package camp.codelab.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import camp.codelab.fragments.adapter.CharacterAnimeSubAdapter
import camp.codelab.fragments.models.CharacterAnime
import camp.codelab.fragments.utils.gone
import camp.codelab.fragments.utils.setImageFromUrl
import kotlinx.android.synthetic.main.activity_character_scrolling.*
import kotlinx.android.synthetic.main.content_character_scrolling.*

class CharacterScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_scrolling)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val characterAnime = intent.getParcelableExtra<CharacterAnime>("CHARACTER")

        toolbar_layout.title = characterAnime.name
//        titleTextViewCharacter.text = characterAnime.name
        prepareRecycleView(characterAnime.alternativeNames)
        imageCharacterPoster.setImageFromUrl(characterAnime.imageUrl)


        var websiteLink = characterAnime.url
        if (websiteLink != "") {
            fabCharacter.setOnClickListener() {

                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteLink)))
            }
        } else {
            fabCharacter.gone()
        }

    }

    fun prepareRecycleView(characterAnimeSubList: List<String>) {
        characterAnimeSubRecycleView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        characterAnimeSubRecycleView?.adapter = CharacterAnimeSubAdapter(characterAnimeSubList)
    }
}
