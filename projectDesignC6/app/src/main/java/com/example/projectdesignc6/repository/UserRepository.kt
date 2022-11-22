package com.example.projectdesignc6.repository

import android.content.ContentValues
import android.content.Context
import com.example.projectdesignc6.constants.DataBaseConstants
import com.example.projectdesignc6.model.UserModel

class UserRepository private constructor(context: Context) {
    private val database = UserDatabase(context)

    companion object {
        private lateinit var repository: UserRepository

        fun getInstance(context: Context): UserRepository {
            if (!::repository.isInitialized) {
                repository = UserRepository(context)
            }
            return repository
        }
    }

    fun insert(user: UserModel): Boolean {
        return try {
            val db = database.writableDatabase

            val values = ContentValues()
            values.put(DataBaseConstants.User.COLUMNS.USER_NAME, user.name)
            values.put(DataBaseConstants.User.COLUMNS.USER_EMAIL, user.email)
            values.put(DataBaseConstants.User.COLUMNS.USER_PASSWORD, user.password)

            db.insert(DataBaseConstants.User.USER_TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun login(email: String, password: String): Boolean {
        return try {
            val db = database.readableDatabase

            val values = ContentValues()
            values.put(DataBaseConstants.User.COLUMNS.USER_EMAIL, email)
            values.put(DataBaseConstants.User.COLUMNS.USER_PASSWORD, password)

            val sql = "SELECT * FROM " + DataBaseConstants.User.USER_TABLE_NAME + " WHERE " +
                    DataBaseConstants.User.COLUMNS.USER_EMAIL + " = ? AND " +
                    DataBaseConstants.User.COLUMNS.USER_PASSWORD + " = ?"

            val cursor = db.rawQuery(sql, arrayOf(email, password))

            cursor.count > 0
        } catch (e: Exception) {
            false
        }
    }
}
