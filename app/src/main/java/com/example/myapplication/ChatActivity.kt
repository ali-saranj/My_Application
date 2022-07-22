package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener

lateinit var btn_send :ImageView
lateinit var edt_send :EditText
class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        findId()

        btn_send.isEnabled = false;

        edt_send.addTextChangedListener{ text -> btn_send.isEnabled = text!!.isNotEmpty()}

        btn_send.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(this@ChatActivity,android.R.anim.fade_in))
            Toast.makeText(this@ChatActivity, edt_send.text, Toast.LENGTH_SHORT).show()
            edt_send.setText("")
        }
    }

    private fun findId() {
        btn_send = findViewById(R.id.btn_send_chat)
        edt_send = findViewById(R.id.edt_send_chat)
    }
}