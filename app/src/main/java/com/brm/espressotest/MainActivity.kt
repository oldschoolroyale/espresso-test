package com.brm.espressotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var textView: TextView
    private lateinit var mEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<Button>(R.id.activityChangeTextBtn).setOnClickListener(this)

        textView = findViewById(R.id.textToBeChanged)
        mEditText = findViewById(R.id.editTextUserInput)
    }

    override fun onClick(p0: View?) {
        val text = mEditText.text.toString()

        val changeTextBtId = R.id.changeTextBt
        val activityChangeTextBtId = R.id.activityChangeTextBtn

        if (p0 != null){
            if (p0.id == changeTextBtId)
                textView.text = text
            else if(p0.id == activityChangeTextBtId){
                val intent = ShowTextActivity.newStartIntent(this, text)
                startActivity(intent)
            }
        }
    }
}