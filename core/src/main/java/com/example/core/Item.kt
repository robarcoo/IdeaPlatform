package com.example.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey
    val id : Int = -1,
    val name : String = "",
    val time : Long = -1,
    val tags : List<String> = listOf(),
    var amount : Int = 0
)