package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
            GlobalScope.launch(Dispatchers.IO) {
                db.userDao().insert(User("Anshuman Yuvraj","9546610003","Bihar",20))
            }

        }


        //with live data no need to add onClickListener for btn2 the data will be updated automatically

        db.userDao().getAllUser().observe(this, Observer { list ->
                if(list.isNotEmpty()){
                    with(list[list.size-1]){
                        val tv1:TextView = findViewById(com.example.roomdb.R.id.tv1)
                        tv1.text = name + ": "+id
                        val tv2:TextView = findViewById(com.example.roomdb.R.id.tv2)
                        tv2.text = number
                        val tv3: TextView = findViewById(com.example.roomdb.R.id.tv3)
                        tv3.text = address
                        val tv4: TextView = findViewById(com.example.roomdb.R.id.tv4)
                        tv4.text = age.toString()
                    }
                }
        })




    }
}
//TODO: Learn Migration Schemas
/*
 * Room Db is a persistance library which provides abstraction layer over the sqlite database.
 */