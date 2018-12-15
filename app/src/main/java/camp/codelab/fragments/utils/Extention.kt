package camp.codelab.fragments.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun ImageView.setImageFromUrl(url: String) {
    Picasso.get()
            .load(url)
            .into(this)
}

public fun EditText.setTextChangedListener(textChanged: (newText: String) -> Unit) {

    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            textChanged(s.toString())
        }

    })

}