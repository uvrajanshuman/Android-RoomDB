package com.example.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

//Dao interface: provide methods for interaction to db

@Dao
interface UserDao{
    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert
    fun insert(user:User)

    @Insert
    fun insertAll(userList: List<User>)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User")
    fun getAllUser():LiveData<List<User>>

    @Query("SELECT * FROM User WHERE age >= :age")
    fun getUserWithAge(age:Int):List<User>
}