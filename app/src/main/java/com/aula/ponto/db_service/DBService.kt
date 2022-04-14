package com.aula.ponto.db_service

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBService (context: Context): SQLiteOpenHelper(
    context, "pontos_db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        // Tabela de usuários
        db?.execSQL("CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, registration TEXT, department TEXT, role TEXT)")
        db?.execSQL("INSERT INTO user (name, registration, department, role) VALUES ('Luis Otavio Zimermann', '12345', 'Dados', 'DBA')")

        // Tabela de atividades
        db?.execSQL("CREATE TABLE activity(id INTEGER PRIMARY KEY AUTOINCREMENT, activity TEXT, day TEXT, hour TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}