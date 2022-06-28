package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etPanjang:EditText
    private lateinit var etLebar:EditText
    private lateinit var etTinggi:EditText
    private lateinit var btnCalculate:Button
    private lateinit var tvHasil:TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        etTinggi = findViewById(R.id.et_tinggi)
        btnCalculate = findViewById(R.id.btn_hitung)
        tvHasil = findViewById(R.id.tv_hasil)

        btnCalculate.setOnClickListener {
            val inputPanjang = etPanjang.text.toString().trim()
            val inputLebar = etLebar.text.toString().trim()
            val inputTinggi = etTinggi.text.toString().trim()

            var isEmptyFields = false
            if(inputPanjang.isEmpty()){
                isEmptyFields = true
                etPanjang.error = "Field ini tidak boleh kosong"
            }

            if(inputLebar.isEmpty()){
                isEmptyFields = true
                etLebar.error = "Field ini tidak boleh kosong"
            }

            if(inputTinggi.isEmpty()){
                isEmptyFields = true
                etTinggi.error = "Field ini tidak boleh kosong"
            }

            if(!isEmptyFields){
                val volume = inputPanjang.toDouble()*inputLebar.toDouble()*inputTinggi.toDouble()
                tvHasil.text = volume.toString()

                etPanjang.text.clear()
                etLebar.text.clear()
                etTinggi.text.clear()

            }




        }

//        if(savedInstanceState != null){
//            val hasil = savedInstanceState.getString(STATE_RESULT)
//            tvHasil.text = hasil
        }

    }

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//        outState.putString(STATE_RESULT, tvHasil.text.toString())
//    }
//}
