package com.rafaebofflarissacarlos.dojo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save_activity)

        val titulo= findViewById<EditText>(R.id.titulo)
        val paginas= findViewById<EditText>(R.id.paginas)
        val paginasLidas= findViewById<EditText>(R.id.paginasLidas)
        val tipo= findViewById<EditText>(R.id.tipo)
        val autor= findViewById<EditText>(R.id.autor)

        val back= findViewById<FloatingActionButton>(R.id.BBack)
        val save= findViewById<FloatingActionButton>(R.id.BSave)

        save.setOnClickListener{
            var livro = Livro(null, titulo.text.toString(),paginas.text.toString().toInt(), paginasLidas.text.toString().toInt(), tipo.text.toString(), autor.text.toString())
            var livroDao = LivroDao(this)
            livroDao.insert(livro)
            onBackPressed()
        }

        back.setOnClickListener {
            onBackPressed()
        }

    }


}