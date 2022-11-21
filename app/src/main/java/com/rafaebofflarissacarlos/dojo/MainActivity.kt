package com.rafaebofflarissacarlos.dojo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var listaLivros = mutableListOf<Livro>()
//    var listaLidos = arrayListOf<Livro>()
//    var listaNaoLidos = arrayListOf<Livro>()
    var adapter= LivroAdapter(listaLivros)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateAdapter()
        initRecyclerView()

        val btnAdd = findViewById<Button>(R.id.buttonAdd)
//        val btnDel = findViewById<Button>(R.id.btnDel)
        val btnUpd = findViewById<Button>(R.id.editar)

        btnAdd.setOnClickListener {
            val itLivro = Intent(this, SaveActivity::class.java)
            startActivity(itLivro)
        }

    }

    override fun onResume() {
        super.onResume()
        updateAdapter()
        initRecyclerView()
    }

    private fun updateAdapter(){
        var rvDados = findViewById<RecyclerView>(R.id.rvDados)
        var txtMsg = findViewById<TextView>(R.id.txtMsg)
        val livroDao = LivroDao(this)
        listaLivros.clear() //todo
        listaLivros = livroDao.getAll()
        if (listaLivros.isEmpty()) {
            rvDados.setVisibility(View.GONE)
            txtMsg.setVisibility(View.VISIBLE)
            txtMsg.setText("Sem dados para exibir")
        }
        else {
            rvDados.setVisibility(View.VISIBLE)
            txtMsg.setVisibility(View.GONE)
        }
        rvDados.adapter?.notifyDataSetChanged()
    }

    private fun initRecyclerView(){
        val rvDados = findViewById<RecyclerView>(R.id.rvDados)
        rvDados.adapter = adapter

        val layoutManager= LinearLayoutManager(this)
        rvDados.layoutManager=layoutManager
    }
}