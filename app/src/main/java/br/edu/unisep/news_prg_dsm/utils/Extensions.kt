package br.edu.unisep.timesbooks.utils

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val NEWS_SCIENCE = "science"
const val NEWS_BUSINESS = "business"
const val NEWS_HEALTH = "health"
const val NEWS_SPORTS = "sports"
const val NEWS_TECHNOLOGY = "technology"


fun EditText.hideKeyboard() {
    val inputManager =
        context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(
        windowToken,
        InputMethodManager.RESULT_UNCHANGED_SHOWN
    )
    
}



