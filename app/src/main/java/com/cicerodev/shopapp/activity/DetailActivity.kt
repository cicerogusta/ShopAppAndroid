package com.cicerodev.shopapp.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.cicerodev.shopapp.R
import com.cicerodev.shopapp.databinding.ActivityDetailBinding
import com.cicerodev.shopapp.domain.PopularDomain

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var objectPopular: PopularDomain
    private var numberOrder = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundles()

    }

    private fun getBundles() {
        objectPopular = intent.getSerializableExtra("object") as PopularDomain
        val drawableResourceId =
            resources.getIdentifier(objectPopular.picUrl, "drawable", packageName)
        Glide.with(this).load(drawableResourceId).into(binding.imageItemDetails)

        binding.tituloDetails.text = objectPopular.title
        binding.priceDetails.text = "R$" + objectPopular.price
        binding.descDetails.text = objectPopular.description
        binding.comentarioDetails.text = objectPopular.review.toString()+""
        binding.pontuacaoDetails.text = objectPopular.score.toString() + ""

        binding.buttonComprar.setOnClickListener {
            objectPopular.numberInChart = numberOrder
        }

        binding.back.setOnClickListener { finish() }
    }
}