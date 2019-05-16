package com.example.sqldelighttest

import androidx.sqlite.db.SupportSQLiteStatement
import com.example.HockeyPlayerQueries
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlDriver
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<BenchmarkDatabase>.schema: SqlDriver.Schema
    get() = BenchmarkDatabaseImpl.Schema

internal fun KClass<BenchmarkDatabase>.newInstance(driver: SqlDriver): BenchmarkDatabase = BenchmarkDatabaseImpl(driver)

private class BenchmarkDatabaseImpl(driver: SqlDriver) : TransacterImpl(driver), BenchmarkDatabase {
    override val hockeyPlayerQueries: HockeyPlayerQueriesImpl = HockeyPlayerQueriesImpl(this,
            driver)

    object Schema : SqlDriver.Schema {
        override val version: Int
            get() = 1

        override fun create(driver: SqlDriver) {
            driver.execute(null, """
                    |CREATE TABLE team (
                    |  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    |  name TEXT NOT NULL,
                    |  coach TEXT NOT NULL,
                    |  captain INTEGER,
                    |  won_cup INTEGER NOT NULL DEFAULT 0
                    |)
                    """.trimMargin(), 0)
        }

        override fun migrate(
                driver: SqlDriver,
                oldVersion: Int,
                newVersion: Int
        ) {
        }
    }
}

private class HockeyPlayerQueriesImpl(private val database: BenchmarkDatabaseImpl, private val driver:
SqlDriver) : TransacterImpl(driver), BenchmarkHockeyPlayerQueries {
    internal val select_changes: MutableList<Query<*>> =
            com.squareup.sqldelight.internal.copyOnWriteList()

    internal val select_lastInsertRow: MutableList<Query<*>> =
            com.squareup.sqldelight.internal.copyOnWriteList()

    override fun select_changes(): Query<Long> = Query(3, select_changes, driver,
            "SELECT changes()") { cursor ->
        cursor.getLong(0)!!
    }

    override fun select_lastInsertRow(): Query<Long> = Query(4, select_lastInsertRow, driver,
            "SELECT last_insert_rowid()") { cursor ->
        cursor.getLong(0)!!
    }

    override fun insertTeam(
            compiledStatement: SupportSQLiteStatement,
            name: String,
            coach: String,
            won_cup: Boolean
    ) {
        (driver as BenchmarkSqliteDriver).executeWithCompileStatement(5, compiledStatement , 3) {
            bindString(1, name)
            bindString(2, coach)
            bindLong(3, if (won_cup) 1L else 0L)
        }
    }
}
