package com.example.constrastoque.component.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.constrastoque.R
import com.example.constrastoque.component.model.EstoqueModel
import com.example.constrastoque.view.DetailsActivity

class EstoqueRecyclerViewAdapter(val list: MutableList<EstoqueModel>): RecyclerView.Adapter<ExtraViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_estoque_model_type), parent, false)
        return ExtraViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExtraViewHolder, position: Int) {
        holder.bindComponents(list[position])
    }

    override fun getItemCount() = list.size
}

class ExtraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val stockImage: ImageView = itemView.findViewById(R.id.acivStockImage)
    private val stockName: TextView = itemView.findViewById(R.id.tvStockTitle)
    private val stockDescription: TextView = itemView.findViewById(R.id.tvStockDescription)
    private val stockAmount: TextView = itemView.findViewById(R.id.tvStockAmount)
    private val stockButton: Button = itemView.findViewById(R.id.btnDetail)

    fun bindComponents(item: EstoqueModel) {

        stockName.text = item.name
        stockDescription.text = item.description
        stockAmount.text = item.amount.toString()
        stockImage.setImageResource(item.image)
        stockButton.setOnClickListener {
            val intent = Intent(itemView.context, DetailsActivity::class.java)
            itemView.context.startActivity(intent)
        }
    }
}

