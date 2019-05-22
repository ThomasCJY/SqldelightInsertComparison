package com.example.sqldelighttest

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import com.example.HockeyPlayerModel
import com.squareup.sqlbrite3.BriteDatabase
import com.squareup.sqlbrite3.SqlBrite
import com.squareup.sqldelight.prerelease.SqlDelightQuery
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var insertTeam: HockeyPlayerModel.InsertTeam
    lateinit var statement: AndroidxToSupportSqliteStatement
    lateinit var briteDb: BriteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = SupportSQLiteOpenHelper.Configuration.builder(applicationContext)
                .name("test.db")
                .callback(DbOpenCallback(1))
                .build()
        val helper = FrameworkSQLiteOpenHelperFactory().create(config)
        helper.setWriteAheadLoggingEnabled(true)
        val sqlBrite = SqlBrite.Builder().build()
        briteDb = sqlBrite.wrapDatabaseHelper(AndroidxToSupportSQLiteOpenHelper(helper), Schedulers.io())
        insertTeam = HockeyPlayerModel.InsertTeam(helper.writableDatabase)
        insertTeam.bind("name1", "coach1", false)
        statement = AndroidxToSupportSqliteStatement(insertTeam)

        insertItem()

        setContentView(R.layout.activity_main)
    }

    fun insertItem() {
        briteDb.executeInsert(HockeyPlayerModel.TABLE_NAME, statement)
    }
}
