package camp.codelab.fragments.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import camp.codelab.fragments.CharacterScrollingActivity
import camp.codelab.fragments.R
import camp.codelab.fragments.models.CharacterAnime
import camp.codelab.fragments.utils.setImageFromUrl
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter(val characterList: List<CharacterAnime>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    //Convert GUI to Code
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    //Calculate the size of list
    override fun getItemCount(): Int {
        return characterList.size
    }

    //Put correct value with correct position of GUI that created
    override fun onBindViewHolder(viewHolder: CharacterViewHolder, position: Int) {
        viewHolder.setCharacter(characterList[position])
    }

    //
    inner class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        init {
            view.cardCharacter.setOnClickListener {
                val clickedAnime = characterList[layoutPosition]
                val intent = Intent(view.context, CharacterScrollingActivity::class.java)
                intent.putExtra("CHARACTER", clickedAnime)
                view.context.startActivity(intent)

            }
        }

        fun setCharacter(character: CharacterAnime) {
            view.titleTextViewCharacter.text = character.name
            view.characterImageView.setImageFromUrl(character.imageUrl)
        }
    }

}