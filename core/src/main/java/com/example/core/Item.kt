package com.example.core

import androidx.room.Entity

@Entity
data class Item(
    val id : Int = -1,
    val name : String = "",
    val time : Long = -1,
    val tags : List<String> = listOf(),
    val amount : Int = 0
)