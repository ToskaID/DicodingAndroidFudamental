package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import java.net.URI

class MainActivity : AppCompatActivity() {
    lateinit var btnPindahActivity:Button

    lateinit var etNama:EditText
    lateinit var etUmur:EditText
    lateinit var  btnIntentData:Button
    lateinit var tvHasilResult:TextView

    private val resultLauncher:ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result->
        if(result.resultCode == MoveWithResault.RESAUL_CODE && result.data != null){
            val selectedValue = result.data?.getStringExtra(MoveWithResault.EXTRA_SELECTED_VALUE)
            val namaResult = result.data?.getStringExtra(MoveWithResault.EXTRA_NAMA)
            tvHasilResult.text = "Nama Saya $namaResult, dan saya seorang $selectedValue"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //pindah aktivity
        btnPindahActivity = findViewById(R.id.btn_pidah_aktifity)
        btnPindahActivity.setOnClickListener {
            startActivity(Intent(this,MoveActivity::class.java))
        }

        //pindah aktifity dengan data
        etNama = findViewById(R.id.et_nama)
        etUmur = findViewById(R.id.et_umur)
        btnIntentData = findViewById(R.id.btn_intent_data)
        tvHasilResult = findViewById(R.id.tv_hasil_resault)

        btnIntentData.setOnClickListener {
            val inputNama = etNama.text.toString().trim()
            val inputUmur = etUmur.text.toString().trim()

            if(inputNama.isEmpty()){
                etNama.error = "Field Tidak Boleh Kosong"
                etNama.requestFocus()
            }

            if(inputUmur.isEmpty()){
                etUmur.error = "Field Tidak Boleh Kosong"
                etUmur.requestFocus()
            }

            if(inputNama.isNotEmpty() && inputUmur.isNotEmpty()){
                val moveWithData = Intent(this,MoveWithData::class.java)
                moveWithData.putExtra(MoveWithData.EXTRA_NAMA,inputNama)
                moveWithData.putExtra(MoveWithData.EXTRA_AGE,inputUmur.toInt())
                startActivity(moveWithData)
                etNama.text.clear()
                etUmur.text.clear()
            }
        }

        //pindah aktivity dengan parclable
        val etNamaParc = findViewById<EditText>(R.id.et_nama_parc)
        val etUmurParc = findViewById<EditText>(R.id.et_umur_parc)
        val etBeratBadanParc = findViewById<EditText>(R.id.et_beratBadan_parc)
        val btnIntentParc = findViewById<Button>(R.id.btn_intent_parc)

        btnIntentParc.setOnClickListener {
            val inputNamaParc = etNamaParc.text.toString().trim()
            val inputUmurParc = etUmurParc.text.toString().trim()
            val inputBeratBadanParc = etBeratBadanParc.text.toString().trim()

            if(inputNamaParc.isEmpty()){
                etNamaParc.error= "Field harus diisi"
                etNamaParc.requestFocus()
            }

            if(inputUmurParc.isEmpty()){
                etUmurParc.error = "Field harus diisi"
                etUmurParc.requestFocus()
            }

            if(inputBeratBadanParc.isEmpty()){
                etBeratBadanParc.error="Field harus diisi"
                etBeratBadanParc.requestFocus()
            }
            if(inputNamaParc.isNotEmpty() && inputUmurParc.isNotEmpty() && inputBeratBadanParc.isNotEmpty()){
                var dataPerson = Person(inputNamaParc,inputUmurParc.toInt(),inputBeratBadanParc.toFloat())
                val intentParc= Intent(this,MoveWithParclable::class.java)
                intentParc.putExtra(MoveWithParclable.DATA_PERSON,dataPerson)
                startActivity(intentParc)

                etNamaParc.text.clear()
                etUmurParc.text.clear()
                etBeratBadanParc.text.clear()
            }

        }

        //intent implicit dial a number
        val btnDial = findViewById<Button>(R.id.btn_dial_number)
        btnDial.setOnClickListener {
            val phoneNumber = ""
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }


        //intent resault
        val etNamaAr = findViewById<EditText>(R.id.et_nama_ar)
        val tvHasilResault = findViewById<TextView>(R.id.tv_hasil_resault)
        val btnIntentResault = findViewById<Button>(R.id.btn_intent_resault)

        btnIntentResault.setOnClickListener {
            val inputNama = etNamaAr.text.toString().trim()

            if(inputNama.isEmpty()){
                etNamaAr.error = "Field tidak boleh kosong"
                etNamaAr.requestFocus()
            }

            if(inputNama.isNotEmpty()){
                val intent = Intent(this,MoveWithResault::class.java)
                intent.putExtra(MoveWithResault.EXTRA_NAMA_RESAULT,inputNama)
                //startActivity(intent)
                resultLauncher.launch(intent)
            }

        }





    }
}