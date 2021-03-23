package com.example.test_base_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "BDD"
val TABLE_NAME = "ModeleLapin"
val COL_NOM = "nom"
val COL_AGE = "age"
val COL_ID = "id"



class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_NOM + " VARCHAR(256),"+
                COL_AGE + " INTEGER"

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }
    fun insertData(user: User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NOM, user.nom)
        cv.put(COL_AGE, user.age)

        var result = db.insert(TABLE_NAME, null, cv)

        if(result == -1.toLong()){
            Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Reussite", Toast.LENGTH_SHORT).show()
        }
    }

}