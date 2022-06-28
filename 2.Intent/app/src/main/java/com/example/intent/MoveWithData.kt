package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithData : AppCompatActivity() {
    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_AGE = "extra_age"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceive = findViewById<TextView>(R.id.tv_data_receive)
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val age = intent.getIntExtra(EXTRA_AGE,0)


        val text = "Nama Saya $nama, dan Umur saya $age"

        tvDataReceive.text = text

    }
}