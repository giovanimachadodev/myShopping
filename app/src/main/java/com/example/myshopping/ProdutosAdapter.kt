package com.example.myshopping

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myshopping.model.Produto
import kotlinx.android.synthetic.main.activity_adicionar_item.view.*

class ProdutosAdapter(private val listaProdutos: MutableList<Produto> ) : RecyclerView.Adapter<ProdutosAdapter.ProdutosHolder>() {
    fun adicionarProduto(listaProdutos: MutableList<Produto>, produto: Produto){
        listaProdutos.add(produto)
        notifyDataSetChanged()
    }


    class ProdutosHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeProduto: TextView = view.findViewById(R.id.txtNomeProduto)
        val precoProduto: TextView = view.findViewById(R.id.txtPreco)
        val separador: TextView = view.findViewById(R.id.txtSeparador)
        val moeda: TextView = view.findViewById(R.id.txtMoeda)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carrinho, parent, false)
        return ProdutosHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutosHolder, position: Int) {
        holder.nomeProduto.text = listaProdutos[position].nome
        holder.precoProduto.text = "%.2f".format(listaProdutos[position].preco)
        holder.separador.text = "-"
        holder.moeda.text = "R$"

        holder.itemView.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Produto")
            builder.setMessage("Você deseja deletar o produto?")
            builder.setPositiveButton("Sim"){dialog, which ->
                listaProdutos.removeAt(position)
                notifyDataSetChanged()
            }
            builder.setNegativeButton("Não"){dialog, which ->}

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

    }

    override fun getItemCount(): Int {
        return listaProdutos.size
    }


}