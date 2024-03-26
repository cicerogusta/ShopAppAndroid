package com.cicerodev.shopapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.cicerodev.shopapp.activity.DetailActivity
import com.cicerodev.shopapp.databinding.ViewholderPupListBinding
import com.cicerodev.shopapp.domain.PopularDomain

class PopularAdapter(private val list: List<PopularDomain>, private val context: Context) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private lateinit var binding: ViewholderPupListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            ViewholderPupListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val popularItem = list[position]
        binding.title.text = popularItem.title
        binding.feeTxt.text = "R$" + popularItem.price
        binding.scoreText.text = "" + popularItem.score

        val drawableResource = holder.itemView.resources.getIdentifier(
            popularItem.picUrl,
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(context)
            .load(drawableResource)
            .transform(GranularRoundedCorners(30f, 30f, 0f, 0f))
            .into(binding.pic)

        binding.view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", popularItem)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: ViewholderPupListBinding) : RecyclerView.ViewHolder(binding.root)


}