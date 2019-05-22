package com.example.sqldelighttest


import android.arch.persistence.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

/**
 * Wrapper class to convert androidx SupportSQLiteOpenHelper to support lib SupportSQLiteOpenHelper, so we can still use
 * SqlBrite
 */

class AndroidxToSupportSQLiteOpenHelper constructor(val openHelper: SupportSQLiteOpenHelper) :
        android.arch.persistence.db.SupportSQLiteOpenHelper {

    override fun getDatabaseName(): String {
        return openHelper.databaseName
    }

    override fun getWritableDatabase(): SupportSQLiteDatabase {
        return AndroidxToSupportSqliteDatabase(openHelper.writableDatabase)
    }

    override fun getReadableDatabase(): SupportSQLiteDatabase {
        return AndroidxToSupportSqliteDatabase(openHelper.readableDatabase)
    }

    override fun close() {
        openHelper.close()
    }

    override fun setWriteAheadLoggingEnabled(enabled: Boolean) {
        openHelper.setWriteAheadLoggingEnabled(enabled)
    }
}