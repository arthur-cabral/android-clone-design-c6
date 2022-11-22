package com.example.projectdesignc6.constants

class DataBaseConstants {
    object User {
        const val USER_TABLE_NAME = "user"

        object COLUMNS {
            const val USER_ID = "id"
            const val USER_NAME = "name"
            const val USER_EMAIL = "email"
            const val USER_CPF = "cpf"
            const val USER_PASSWORD = "password"
        }
    }
}