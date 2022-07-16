package com.brm.espressotest.basicexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.brm.espressotest.R

class ShowTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)
        val text = intent.getStringExtra(KEY_EXTRA_MESSAGE)
        findViewById<TextView>(R.id.second_text_view).text = text
    }

    companion object{
        private const val KEY_EXTRA_MESSAGE = "com.brm.espressotest.basicexample.ShowTextActivity"
        fun newStartIntent(context: Context, message: String): Intent {
            val intent = Intent(context, ShowTextActivity::class.java)
            intent.putExtra(KEY_EXTRA_MESSAGE, message)
            return intent
        }
    }
}