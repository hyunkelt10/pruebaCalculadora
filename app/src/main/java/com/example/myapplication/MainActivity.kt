package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var n1 = 0
    private var n2 = 0
    private var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnDot.setOnClickListener {
            if (!b.tvPantalla.text.toString().contains('.'))
                b.tvPantalla.text = b.tvPantalla.text.toString().plus(".")
        }

        b.btnIgual.setOnClickListener {
            if (op != "") {
                n2 = b.tvPantalla.text.toString().toInt()
                b.tvPantalla.text = when (op) {
                    "/" -> (n1 / n2).toString()
                    "*" -> (n1 * n2).toString()
                    "-" -> (n1 - n2).toString()
                    "+" -> (n1 + n2).toString()
                    else -> "error"
                }
            }
            op =""
        }


        b.btnLimpiar.setOnClickListener { b.tvPantalla.text ="0"
            n1 = 0
            n2 = 0
            op = ""}

    }
    fun onClickNumber (view: View) {
        if ( view is Button) {
            val textBtn = view.text.toString()
            if (b.tvPantalla.text.toString()!="0") {
                b.tvPantalla.text = b.tvPantalla.text.toString().plus(textBtn)

            } else {
                b.tvPantalla.text = textBtn
            }

        }
    }
    fun onClickOp (view: View) {
        if ( view is Button) {
            n1 = b.tvPantalla.text.toString().toInt()
            op = view.text.toString() //el view es el boton que pulsamos
            b.tvPantalla.text = "0"







        }

    }

}