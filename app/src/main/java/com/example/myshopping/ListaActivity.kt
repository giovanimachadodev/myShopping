package com.example.myshopping

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myshopping.model.Produto
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_adicionar_item.*

class ListaActivity : AppCompatActivity() {
//    lateinit var dados : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

//        dados = getSharedPreferences("PRODUTO", MODE_PRIVATE)

        val nomeRecebido = intent.extras?.get("NOME").toString()
        val preco = intent.extras?.get("PRECO").toString().toDouble()
//        val nomeRecebido = dados.getString("NOME", "")
//        val preco = dados.getString("PRECO", "")
//
//        val gson = Gson()


        val rvProdutos = findViewById<RecyclerView>(R.id.rvProdutos)
        val adapterProdutos = ProdutosAdapter(listaProdutos)
        rvProdutos.adapter = adapterProdutos

      adapterProdutos.adicionarProduto(listaProdutos, Produto(nomeRecebido, preco))

        rvProdutos.layoutManager = LinearLayoutManager(this)


    }

    companion object{
        val listaProdutos: MutableList<Produto> = mutableListOf(
            Produto("Feijão", 5.00),
            Produto("Arroz", 20.00),
            Produto("Farinha", 2.00)
        )
    }
}
