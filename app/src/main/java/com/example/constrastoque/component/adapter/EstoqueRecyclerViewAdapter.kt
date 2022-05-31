package com.example.constrastoque.component.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.constrastoque.R
import com.example.constrastoque.component.model.Estoque
import com.example.constrastoque.view.DetailsActivity

class EstoqueRecyclerViewAdapter(val list: List<Estoque>,
                                 val onClickDelete: (Int) -> Unit, val onClickEdit: (Int) -> Unit) :
    RecyclerView.Adapter<EstoqueRecyclerViewAdapter.ExtraViewHolder>() {

    inner class ExtraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context
        private val stockImage = itemView.findViewById<ImageView>(R.id.acivStockImage)
        private val stockName = itemView.findViewById<TextView>(R.id.tvStockTitle)
        private val stockDescription = itemView.findViewById<TextView>(R.id.tvStockDescription)
        private val stockAmount = itemView.findViewById<TextView>(R.id.tvStockAmount)
        private val stockButton = itemView.findViewById<Button>(R.id.btnDetail)
        private val stockProgress = itemView.findViewById<ProgressBar>(R.id.progressBar)
        private val btnDelete = itemView.findViewById<Button>(R.id.btnExclude)
        private val ivEditItem = itemView.findViewById<ImageView>(R.id.ivEditItem)

        fun bindComponents(item: Estoque, index: Int) {
            stockProgress.visibility = View.VISIBLE
            stockName.text = item.titulo
            stockDescription.text = item.descricao
            stockAmount.text = item.quantidade.toString()

            Glide.with(context).load(item.imagem)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        stockProgress.visibility = View.GONE
                        return false
                    }

                })
                .into(stockImage)

            stockButton.setOnClickListener {
                val intent = Intent(itemView.context, DetailsActivity::class.java)
                itemView.context.startActivity(intent)
            }

            btnDelete.setOnClickListener { onClickDelete(index) }

            ivEditItem.setOnClickListener { onClickEdit(index) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate((R.layout.item_estoque_model_type), parent, false)
        return ExtraViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ExtraViewHolder, position: Int) {
        holder.bindComponents(list[position], position)
    }

}



