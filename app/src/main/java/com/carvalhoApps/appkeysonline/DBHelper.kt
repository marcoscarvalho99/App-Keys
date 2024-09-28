package com.carvalhoApps.appkeysonline

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.carvalhoApps.appkeysonline.Model.Datakey


    class DBHelper(context: Context) :
        SQLiteOpenHelper( context, "databasekeyses.db", null, 1){

        val sql = arrayOf(
            "CREATE TABLE datakey (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, password TEXT)"

        )

        override fun onCreate(db: SQLiteDatabase) {
            sql.forEach {
                db.execSQL(it)
            }

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE datakey")
            onCreate(db)
        }

        fun keysInsert(descricao:String, password: String): Long{
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put("descricao", descricao)
            contentValues.put("password", password)
            val res =db.insert("datakey",null,contentValues)
            db.close()
            return res
        }

        fun keysUpdate(id:Int,descricao:String, password: String): Int{
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put("descricao", descricao)
            contentValues.put("password", password)
            val res = db.update("datakey", contentValues,"id=?", arrayOf(id.toString()))
            db.close()
            return res
        }
        fun keysDelete(id:Int): Int{
            val db = this.writableDatabase
            val res = db.delete("datakey", "id=?", arrayOf(id.toString()))
            db.close()
            return res
        }
        fun keysSelectAll(): Cursor {
            val db = this.readableDatabase
            val c = db.rawQuery("SELECT * FROM datakey", null)
            db.close()
            return c
        }

        fun keysSelectById(id:Int):Cursor{
            val db = this.readableDatabase
            val c = db.rawQuery("SELECT * FROM datakey WHERE id=?", arrayOf(id.toString()))
            db.close()

            return c
        }

        fun keysObjectSelectById(id: Int):Datakey{
            val db = this.readableDatabase
            val c = db.rawQuery("SELECT * FROM datakey WHERE id=?", null)
            var datakey = Datakey()
            if(c.count ==1){
                c.moveToFirst()
                val idIndex = c.getColumnIndex("id")
                val usernameIndex = c.getColumnIndex("descricao")
                val passwordIndex = c.getColumnIndex("password")
                val id =  c.getInt(idIndex)
                val username = c.getString(usernameIndex)
                val password = c.getString(passwordIndex)
                datakey = Datakey(id, username, password)


            }
            db.close()
            return datakey
        }

        fun keysListSelectAll() : ArrayList<Datakey>{
            val db = this.readableDatabase
            val c = db.rawQuery("SELECT * FROM datakey", null)
            val listaKeys : ArrayList<Datakey> =  ArrayList()

            if ( c.count > 0){
                c.moveToFirst()
                do {
                    val idIndex = c.getColumnIndex("id")
                    val usernameIndex = c.getColumnIndex("descricao")
                    val passwordIndex = c.getColumnIndex("password")
                    val id =  c.getInt(idIndex)
                    val username = c.getString(usernameIndex)
                    val password = c.getString(passwordIndex)
                    listaKeys.add(Datakey(1, username.toString(),password.toString()))
                }   while (c.moveToNext())
            }
            db.close()
            return listaKeys
        }

    }
