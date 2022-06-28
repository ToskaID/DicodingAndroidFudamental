package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithParclable : AppCompatActivity() {
    companion object{
        const val DATA_PERSON = "data_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_parclable)

        val tvReceive = findViewById<TextView>(R.id.tv_receive_parc)
        val dataPerson = intent.getParcelableExtra<Person>(DATA_PERSON) as Person
        val text = "Nama saya ${dataPerson.nama}, Umur saya ${dataPerson.umur.toString()} Tahun, Berat Badan Saya ${dataPerson.beratBadan.toString()} Kg"
        tvReceive.text = text
    }
}