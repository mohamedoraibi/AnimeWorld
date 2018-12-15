package camp.codelab.fragments.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import camp.codelab.fragments.MangaScrollingActivity
import camp.codelab.fragments.R
import camp.codelab.fragments.models.Manga
import camp.codelab.fragments.utils.setImageFromUrl
import kotlinx.android.synthetic.main.item_manga.view.*

class MangaAdapter(val mangaList: List<Manga>) : RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {

    //Convert GUI to Code
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_manga, parent, false)
        return MangaViewHolder(view)
    }

    //Calculate the size of list
    override fun getItemCount(): Int {
        return mangaList.size
    }

    //Put correct value with correct position of GUI that created
    override fun onBindViewHolder(viewHolder: MangaViewHolder, position: Int) {
        viewHolder.setManga(mangaList[position])
    }

    //
    inner class MangaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.cardManga.setOnClickListener {
                val clickedManga = mangaList[layoutPosition]
                val intent = Intent(view.context, MangaScrollingActivity::class.java)
                intent.putExtra("MANGA", clickedManga)
                view.context.startActivity(intent)
            }
        }

        fun setManga(manga: Manga) {
            view.titleTextViewManga.text = manga.title
            view.mangaImageView.setImageFromUrl(manga.imageUrl)
        }

    }
}