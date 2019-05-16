package com.example.sqldelighttest

import androidx.sqlite.db.SupportSQLiteStatement
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Boolean
import kotlin.Long
import kotlin.String

interface BenchmarkHockeyPlayerQueries: Transacter {
    fun select_changes(): Query<Long>

    fun select_lastInsertRow(): Query<Long>

    fun insertTeam(
            compiledStatement: SupportSQLiteStatement,
            name: String,
            coach: String,
            won_cup: Boolean
    )
}
