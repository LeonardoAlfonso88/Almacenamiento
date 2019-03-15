package com.example.almacenamiento

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit private var contadorAlmacenado : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        almacenamientoInterno()
    }

    fun almacenamientoInterno()
    {
        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        contadorAlmacenado = preferencias.getString("entrada","")
        val textoContador = findViewById<TextView>(R.id.contador)
        val textoInicial = findViewById<TextView>(R.id.inicial)
        var contador: Int = 0
        val editor = preferencias.edit()

        if("".equals(contadorAlmacenado))
        {
            contador = 0
            textoInicial.text = "Primera vez en el app"
        }
        else
        {
            contador = Integer.parseInt(contadorAlmacenado)
            textoInicial.text = "Ya has entrado"
        }

        contador += 1
        editor.putString("entrada", contador.toString() )
        editor.commit()
        textoContador.text = contador.toString()

    }
}
