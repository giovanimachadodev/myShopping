package com.example.myshopping

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myshopping.model.Produto

class AdicionarItemActivity : AppCompatActivity() {
    lateinit var botaoAdicionar: Button
    lateinit var nomeProduto: EditText
    lateinit var preco: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_item)

        botaoAdicionar = findViewById(R.id.btnAdicionarProduto)
        nomeProduto = findViewById(R.id.edtNomeProduto)
        preco  = findViewById(R.id.edtPreco)

        botaoAdicionar.setOnClickListener {
            val telaLista = Intent(this, ListaActivity::class.java)
            telaLista.putExtra("NOME", nomeProduto.text )
            telaLista.putExtra("PRECO", preco.text)
            startActivity(telaLista)
            nomeProduto.setText("")
            preco.setText("")
//            salvarProduto()

        }

    }

//    fun salvarProduto(){
//        val editor: SharedPreferences.Editor = getSharedPreferences("PRODUTO", MODE_PRIVATE).edit()
//        editor.putString("NOME", nomeProduto.toString())
//        editor.putString("PRECO", preco.toString())
//        editor.commit()
//    }

}