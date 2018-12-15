package camp.codelab.fragments.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import camp.codelab.fragments.AnimeScrollingActivity
import camp.codelab.fragments.R
import camp.codelab.fragments.models.Anime
import camp.codelab.fragments.utils.setImageFromUrl
import kotlinx.android.synthetic.main.item_anime.view.*

class AnimeAdapter(val animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    //Convert GUI to Code
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    //Calculate the size of list
    override fun getItemCount(): Int {
        return animeList.size
    }

    //Put correct value with correct position of GUI that created
    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.setAnime(animeList[position])
    }

    //
    inner class AnimeViewHolder//                val animeId = clickedAnime.malId
    (val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.cardAnime.setOnClickListener {
                val clickedAnime = animeList[layoutPosition]
//                val animeId = clickedAnime.malId
                val intent = Intent(view.context, AnimeScrollingActivity::class.java)
                intent.putExtra("ANIME", clickedAnime)
                view.context.startActivity(intent)
            }
        }

        fun setAnime(anime: Anime) {
            view.titleTextViewAnime.text = anime.title
            view.animeImageView.setImageFromUrl(anime.imageUrl)
        }
    }
}