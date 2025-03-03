package com.example.core

import androidx.room.Entity

@Entity
data class Item(
    val id : Int,
    val name : String,
    val time : Long,
    val tags : List<String>,
    val amount : Int
)