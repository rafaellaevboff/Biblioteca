package com.rafaebofflarissacarlos.dojo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UpdateActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar)

        val titulo = findViewById<EditText>(R.id.titulo2)
        val paginas = findViewById<EditText>(R.id.paginas2)
        val paginasLidas = findViewById<EditText>(R.id.paginasLidas2)
        val tipo = findViewById<EditText>(R.id.tipo2)
        val autor = findViewById<EditText>(R.id.autor2)
        val FABRemove = findViewById<FloatingActionButton>(R.id.FABRemove)
        val FABSave = findViewById<FloatingActionButton>(R.id.FABSave)
        val FABBack = findViewById<FloatingActionButton>(R.id.FABBack)
        val livro = intent.getParcelableExtra<Livro>("livro")

        titulo.setText(livro?.titulo.toString())
        paginas.setText(livro?.paginas.toString())
        tipo.setText(livro?.tipo.toString())
        autor.setText(livro?.autor.toString())
        paginasLidas.setText(livro?.paginasLidas.toString())

        FABRemove.setOnClickListener{
            val livroDao = LivroDao(this)
            if(livro != null){
                livroDao.remove(livro)
            }
            onBackPressed()
        }

        FABSave.setOnClickListener {
            var livroUP = Livro(livro?.id, titulo.text.toString(),paginas.text.toString().toInt(), paginasLidas.text.toString().toInt(), tipo.text.toString(), autor.text.toString())
            var livroDao = LivroDao(this)
            livroDao.update(livroUP)
            onBackPressed()
        }

        FABBack.setOnClickListener {
            onBackPressed()
        }
    }
}


