package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class MoveWithResault : AppCompatActivity() {

    companion object{
        const val EXTRA_NAMA_RESAULT = "extra_nama_resault"
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val EXTRA_NAMA = "extra_nama"
        const val RESAUL_CODE = 7
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_resault)

        val rgPilih = findViewById<RadioGroup>(R.id.rg_pilih)
        val rbLaki = findViewById<RadioButton>(R.id.rb_laki)
        val rbPerempuan = findViewById<RadioButton>(R.id.rb_perempuan)
        val btnPilih = findViewById<Button>(R.id.btn_pilih)

        val tvNamaRecieve = findViewById<TextView>(R.id.tv_nama_receive)
        val nama = intent.getStringExtra(EXTRA_NAMA_RESAULT)
        val text  = "Nama Saya $nama"
        tvNamaRecieve.text = text

        btnPilih.setOnClickListener {
            if(rgPilih.checkedRadioButtonId > 0){
                var value = ""

                when (rgPilih.checkedRadioButtonId) {
                    R.id.rb_laki -> value = "Laki-Laki"
                    R.id.rb_perempuan -> value = "Perempuan"
                }

                val resulIntent = Intent()
                Log.e("get data", "$value")
                resulIntent.putExtra(EXTRA_SELECTED_VALUE,value)
                resulIntent.putExtra(EXTRA_NAMA,nama)
                setResult(RESAUL_CODE,resulIntent)
                finish()
            }


        }
    }
}