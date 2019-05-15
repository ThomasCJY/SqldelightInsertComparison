package com.example.sqldelighttest

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.HockeyPlayerModel

class DbOpenCallback(version: Int): SupportSQLiteOpenHelper.Callback(version) {
    override fun onCreate(db: SupportSQLiteDatabase?) {
        db?.execSQL(HockeyPlayerModel.CREATE_TABLE)
    }

    override fun onUpgrade(db: SupportSQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}