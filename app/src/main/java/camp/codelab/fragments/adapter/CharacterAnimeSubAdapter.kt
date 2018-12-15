package camp.codelab.fragments.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import camp.codelab.fragments.R
import kotlinx.android.synthetic.main.item_character_anime_sub.view.*

class CharacterAnimeSubAdapter : RecyclerView.Adapter<CharacterAnimeSubAdapter.CharacterViewHolder> {

    val characterAnimeSubList: List<String>

    constructor(characterAnimeSubList: List<String>) {
        this.characterAnimeSubList = characterAnimeSubList
    }

    //Convert GUI to Code
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAnimeSubAdapter.CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character_anime_sub, parent, false)
        return CharacterViewHolder(view)
    }

    //Calculate the size of list
    override fun getItemCount(): Int {
        return characterAnimeSubList.size
    }

    //Put correct value with correct position of GUI that created
    override fun onBindViewHolder(viewHolder: CharacterViewHolder, position: Int) {
        viewHolder.setCharacter(characterAnimeSubList[position])
    }

    //
    inner class CharacterViewHolder : RecyclerView.ViewHolder {
        val view: View

        constructor(view: View) : super(view) {
            this.view = view

//            view.cardCharacter.setOnClickListener {
//                val clickedAnime = characterList[layoutPosition]
//                val intent = Intent(view.context, CharacterScrollingActivity::class.java)
//                intent.putExtra("CHARACTER", clickedAnime)
//                view.context.startActivity(intent)
//
//            }
        }

        fun setCharacter(character: String) {
            view.characterAnimeSub.text = character
//            view.characterImageView.setImageFromUrl(character.imageUrl)
        }
    }

}