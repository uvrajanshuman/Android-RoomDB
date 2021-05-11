package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    val db by lazy {
        Room.databaseBuilder(
            this, AppDatabase::class.java,
            "user.db")
            .allowMainThreadQueries() //To allow operations on main thread.
            .fallbackToDestructiveMigration() //In case of migration old db is discarded and new one is considered.
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveBtn:Button = findViewById(R.id.btn1)
        saveBtn.setOnClickListener {
            db.userDao().insert(User("Anshuman Yuvraj","9546610003","Bihar",20))
        }

        val fetchBtn: Button = findViewById(R.id.btn2)
        fetchBtn.setOnClickListener {
            val list: List<User> = db.userDao().getAllUser();
            if(list.isNotEmpty()){
                with(list[0]){
                    val tv1:TextView = findViewById(R.id.tv1)
                    tv1.text = name
                    val tv2:TextView = findViewById(R.id.tv2)
                    tv2.text = number
                    val tv3: TextView = findViewById(R.id.tv3)
                    tv3.text = address
                    val tv4: TextView = findViewById(R.id.tv4)
                    tv4.text = age.toString()
                }
            }
        }

    }
}
//TODO: Learn Migration Schemas
/*
 * Room Db is a persistance library which provides abstraction layer over the sqlite database.
 */