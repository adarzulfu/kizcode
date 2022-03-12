package com.zulfu.adar.kizcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topla.setOnClickListener {
            val sayi1 = sayiGiris1.text.toString().toInt()
            val sayi2 = sayiGiris2.text.toString().toInt()
            val sonucText = "Sonuc = ${sayi1 + sayi2}"
            sonuc.text = sonucText
        }

        cikar.setOnClickListener {
            val sayi1 = sayiGiris1.text.toString().toInt()
            val sayi2 = sayiGiris2.text.toString().toInt()
            val sonucText = "Sonuc = ${sayi1 - sayi2}"
            sonuc.text = sonucText
        }

        carp.setOnClickListener {
            val sayi1 = sayiGiris1.text.toString().toInt()
            val sayi2 = sayiGiris2.text.toString().toInt()
            val sonucText = "Sonuc = ${sayi1 * sayi2}"
            sonuc.text = sonucText
        }

        bol.setOnClickListener {
            val sayi1 = sayiGiris1.text.toString().toFloat()
            val sayi2 = sayiGiris2.text.toString().toFloat()
            val formatter = DecimalFormat("0.#")
            val sonucText = "Sonuc = ${formatter.format(sayi1 / sayi2)}"
            sonuc.text = sonucText
        }
    }

    private fun islemYap1(islemTipi: String) {

        val sayi1 = sayiGiris1.text.toString().toFloatOrNull() ?: return
        val sayi2 = sayiGiris2.text.toString().toFloatOrNull() ?: return

        val islemSonucu = when (islemTipi) {
            "+" -> {
                sayi1 + sayi2
            }
            "-" -> {
                sayi1 - sayi2
            }
            "*" -> {
                sayi1 * sayi2
            }
            else -> {
                sayi1 / sayi2
            }
        }
        val formatter = DecimalFormat("0.#")
        val sonucText = "Sonuç = ${formatter.format(islemSonucu)}"
        sonuc.text = sonucText
    }

    private fun islemYap2(islem: (sayi1: Float, sayi2: Float) -> Float) {
        val sayi1 = sayiGiris1.text.toString().toFloatOrNull() ?: return
        val sayi2 = sayiGiris2.text.toString().toFloatOrNull() ?: return

        val islemSonucu = islem.invoke(sayi1, sayi2)

        val formatter = DecimalFormat("0.#")
        val sonucText = "Sonuç = ${formatter.format(islemSonucu)}"
        sonuc.text = sonucText
    }
}