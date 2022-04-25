package com.example.baladeyti.models

data class Claim(
    val _id: String,
    val addresse: List<Double>,
    val author: String,
    val date: String,
    val designation: String,
    val photos: String,
    val text: String
)