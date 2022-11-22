package com.example.projectdesignc6.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.projectdesignc6.constants.DataBaseConstants

class UserDatabase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object{
        private const val NAME = "dbc6bank"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DataBaseConstants.User.USER_TABLE_NAME +" (" +
                DataBaseConstants.User.COLUMNS.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataBaseConstants.User.COLUMNS.USER_NAME + " TEXT, " +
                DataBaseConstants.User.COLUMNS.USER_EMAIL + " TEXT, " +
                DataBaseConstants.User.COLUMNS.USER_CPF + " TEXT, " +
                DataBaseConstants.User.COLUMNS.USER_PASSWORD + " TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}