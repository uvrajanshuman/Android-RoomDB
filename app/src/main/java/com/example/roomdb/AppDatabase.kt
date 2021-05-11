package com.example.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

/*
The following code defines an AppDatabase class to hold the database. AppDatabase defines the database configuration and serves as the app's main access point to the persisted data. The database class must satisfy the following conditions:

The class must be annotated with a @Database annotation that includes an entities array that lists all of the data entities associated with the database.
The class must be an abstract class that extends RoomDatabase.
For each DAO class that is associated with the database, the database class must define an abstract method that has zero arguments and returns an instance of the DAO class.
 */
@Database(entities = [User::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    //All the dao must be returned by a abstract function
    abstract fun userDao():UserDao
}