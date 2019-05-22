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

        queryAndMapToList(HockeyPlayer.FACTORY.query1(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query2(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query3(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query4(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query5(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query6(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query7(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query8(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query9(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query10(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query11(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query12(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query13(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query14(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query15(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query16(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query17(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query18(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query19(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query20(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query21(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query22(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query23(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query24(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query25(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query26(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query27(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query28(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query29(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query30(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query31(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query32(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query33(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query34(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query35(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query36(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query37(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query38(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query39(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query40(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query41(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query42(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query43(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query44(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query45(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query46(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query47(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query48(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query49(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query50(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query51(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query52(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query53(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query54(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query55(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query56(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query57(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query58(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query59(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query60(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query61(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query62(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query63(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query64(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query65(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query66(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query67(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query68(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query69(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query70(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query71(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query72(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query73(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query74(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query75(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query76(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query77(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query78(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query79(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query80(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query81(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query82(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query83(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query84(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query85(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query86(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query87(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query88(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query89(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query90(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query91(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query92(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query93(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query94(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query95(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query96(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query97(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query98(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query99(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()
        queryAndMapToList(HockeyPlayer.FACTORY.query100(), HockeyPlayer.QUERY1_MAPPER::map).subscribe()

        insertItem()

        setContentView(R.layout.activity_main)
    }

    fun insertItem() {
        briteDb.executeInsert(HockeyPlayerModel.TABLE_NAME, statement)
    }

    private fun <T>queryAndMapToList(statement: SqlDelightQuery, mapper: Function1<Cursor, T>): Observable<List<T>> {
        return briteDb.createQuery(statement.tables, AndroidxToSupportSQLiteQuery(statement))
                .observeOn(Schedulers.io())
                .lift<List<T>>(SqlBrite.Query.mapToList<T>(mapper))
    }
}
