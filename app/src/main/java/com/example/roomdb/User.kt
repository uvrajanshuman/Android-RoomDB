package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

//Data entity class: Each instance represents a row in table

@Entity
data class User(val name: String,
                val number: String,
                val address: String,
                val age: Int,
                @PrimaryKey(autoGenerate = true)
                val id:Long=0 )