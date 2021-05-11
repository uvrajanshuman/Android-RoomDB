package com.example.roomdb

import androidx.room.*

//Dao interface: provide methods for interaction to db

@Dao
interface UserDao{
    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert
    suspend fun insert(user:User)

    @Insert
    fun insertAll(userList: List<User>)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User")
    suspend fun getAllUser():List<User>

    @Query("SELECT * FROM User WHERE age >= :age")
    fun getUserWithAge(age:Int):List<User>
}