package com.example.constrastoque.component.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.constrastoque.R
import com.example.constrastoque.component.model.Estoque
import com.example.constrastoque.view.DetailsActivity
import com.squareup.picasso.Picasso

class EstoqueRecyclerViewAdapter(val list: List<Estoque>): RecyclerView.Adapter<ExtraViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_estoque_model_type), parent, false)
        return ExtraViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExtraViewHolder, position: Int) {
        holder.bindComponents(list[position])
    }

    override fun getItemCount() = this.list.size
}

class ExtraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context
    private val stockImage: ImageView = itemView.findViewById(R.id.acivStockImage)
    private val stockName: TextView = itemView.findViewById(R.id.tvStockTitle)
    private val stockDescription: TextView = itemView.findViewById(R.id.tvStockDescription)
    private val stockAmount: TextView = itemView.findViewById(R.id.tvStockAmount)
    private val stockButton: Button = itemView.findViewById(R.id.btnDetail)
    private val stockProgress: ProgressBar = itemView.findViewById(R.id.progressBar)

    fun bindComponents(item: Estoque) {

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
    }
}

