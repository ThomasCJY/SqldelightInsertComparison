package com.example.sqldelighttest

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

interface BenchmarkDatabase : Transacter {
    val hockeyPlayerQueries: BenchmarkHockeyPlayerQueries

    companion object {
        val Schema: SqlDriver.Schema
            get() = BenchmarkDatabase::class.schema

        operator fun invoke(driver: SqlDriver): BenchmarkDatabase = BenchmarkDatabase::class.newInstance(driver)}
}
