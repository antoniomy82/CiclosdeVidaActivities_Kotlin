package com.example.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast

/**
 *  Created by Antonio J Morales "el colega informático" on 26/05/2020
 *  Puedes ver como se ha realizado esta App : https://www.youtube.com/watch?v=UwQ_QS3Qizc
 *  Si te interesa, subscribete a mi Canal de Youtube: https://www.youtube.com/channel/UC2XTU132H9tHCnM_A3opCzQ
 *
 */

class MainActivity : AppCompatActivity() {

    private var nombre="Inicial"
    private val NOMBRE="nombre"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton=findViewById<Button>(R.id.boton)

        Toast.makeText(this,nombre,Toast.LENGTH_SHORT).show()

        boton.setOnClickListener {
            nombre="Nombre  ->OnCreate"
            Toast.makeText(this,nombre,Toast.LENGTH_SHORT).show()
        }
    }

    //Restauro el valor del nombre
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        nombre = savedInstanceState?.getString(NOMBRE)!!
        Toast.makeText(this,nombre,Toast.LENGTH_SHORT).show()
    }

    //Guardo el valor de nombre en el "TAG" nombre por si hay un cambio de estado
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(NOMBRE,nombre)
    }

    override fun onPause() {
       super.onPause()
       Toast.makeText(this,"En transición ->OnPause",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Pasa a 2ºPlano ->OnStop",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Pasa a 1ºPlano ->OnResume",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"App destruida ->onDestroy",Toast.LENGTH_SHORT).show()
    }
}
