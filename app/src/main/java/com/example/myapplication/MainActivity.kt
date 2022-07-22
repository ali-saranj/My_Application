package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var btn :Button
    lateinit var edt : TextInputEditText
    companion object{
        var name = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findid()
        var sharedPreferences = getSharedPreferences("name", MODE_PRIVATE);
        if (sharedPreferences.getString("name","no").equals("no")){

            btn.setOnClickListener {
                it.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,android.R.anim.fade_in))
                if (edt.text!!.isNotEmpty()) {
                    val editor = getSharedPreferences("name", MODE_PRIVATE).edit()
                    editor.putString("name",edt.text.toString())
                    editor.apply()
                    name = sharedPreferences.getString("name","no").toString()
                    startActivity(Intent(this@MainActivity,ChatActivity::class.java))
                    finish()
                }else{
                    edt.error = "Enter your name"
                }
            }

        }else{
            name = sharedPreferences.getString("name","no").toString()
            startActivity(Intent(this@MainActivity,ChatActivity::class.java))
            finish()
        }
    }

    private fun findid() {
        btn = findViewById(R.id.btn_submit_main)
        edt = findViewById(R.id.edt_name_main)
    }
}