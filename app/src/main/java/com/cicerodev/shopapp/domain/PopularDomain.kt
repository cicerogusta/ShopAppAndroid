package com.cicerodev.shopapp.domain

import java.io.Serializable

class PopularDomain(
    var title: String,
    var picUrl: String,
    var review: Int,
    var score: Double,
    var numberInChart: Int,
    var price: Double,
    var description: String

): Serializable {
}