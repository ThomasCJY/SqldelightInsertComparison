package com.example.sqldelighttest

import android.arch.persistence.db.SupportSQLiteQuery
import android.arch.persistence.db.SupportSQLiteStatement
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteTransactionListener
import android.os.CancellationSignal
import android.util.Pair
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.Locale

/**
 * Wrapper class to convert androidx SupportSQLiteDatabase to support lib SupportSQLiteDatabase, so we can keep using
 * sqlBrite
 *
 */
/**
 * Wrapper Class for SupportSQLiteDatabase.
 * In Sqldelight 0.9.0 we introduced androidx dependencies to all our db related classes.
 * However, Sqlbrite 3.0 is still using the legacy android db api. Before migrating to sqldelight 1.0 and remove our
 * usage of Sqlbrite, we will need this wrapper class to resolve dependency issue.
 */
class AndroidxToSupportSqliteDatabase constructor(val database: SupportSQLiteDatabase)
    : android.arch.persistence.db.SupportSQLiteDatabase {
    override fun setMaximumSize(numBytes: Long): Long {
        return database.setMaximumSize(numBytes)
    }

    override fun insert(table: String?, conflictAlgorithm: Int, values: ContentValues?): Long {
        return database.insert(table, conflictAlgorithm, values)
    }

    override fun enableWriteAheadLogging(): Boolean {
        return database.enableWriteAheadLogging()
    }

    override fun isDatabaseIntegrityOk(): Boolean {
        return database.isDatabaseIntegrityOk
    }

    override fun isWriteAheadLoggingEnabled(): Boolean {
        return database.isWriteAheadLoggingEnabled
    }

    override fun disableWriteAheadLogging() {
        database.disableWriteAheadLogging()
    }

    override fun compileStatement(sql: String): SupportSQLiteStatement {
        return AndroidxToSupportSqliteStatement(database.compileStatement(sql))
    }

    override fun beginTransactionWithListenerNonExclusive(transactionListener: SQLiteTransactionListener) {
        database.beginTransactionWithListenerNonExclusive(transactionListener)
    }

    override fun isDbLockedByCurrentThread(): Boolean {
        return database.isDbLockedByCurrentThread
    }

    override fun setPageSize(numBytes: Long) {
        database.pageSize = numBytes
    }

    override fun query(query: String?): Cursor {
        return database.query(query)
    }

    override fun query(query: String?, bindArgs: Array<out Any>?): Cursor {
        return database.query(query, bindArgs)
    }

    override fun query(query: SupportSQLiteQuery): Cursor {
        return database.query(SupportSQLiteToAndroidxQuery(query))
    }

    override fun query(query: SupportSQLiteQuery, cancellationSignal: CancellationSignal?): Cursor {
        return database.query(SupportSQLiteToAndroidxQuery(query), cancellationSignal)
    }

    override fun endTransaction() {
        database.endTransaction()
    }

    override fun getMaximumSize(): Long {
        return database.maximumSize
    }

    override fun setLocale(locale: Locale?) {
        database.setLocale(locale)
    }

    override fun beginTransaction() {
        database.beginTransaction()
    }

    override fun update(table: String?,
                        conflictAlgorithm: Int,
                        values: ContentValues?,
                        whereClause: String?, whereArgs: Array<out Any>?): Int {
        return database.update(table, conflictAlgorithm, values, whereClause, whereArgs)
    }

    override fun isOpen(): Boolean {
        return database.isOpen
    }

    override fun getAttachedDbs(): MutableList<Pair<String, String>> {
        return database.attachedDbs
    }

    override fun getVersion(): Int {
        return database.version
    }

    override fun execSQL(sql: String?) {
        database.execSQL(sql)
    }

    override fun execSQL(sql: String?, bindArgs: Array<out Any>?) {
        database.execSQL(sql, bindArgs)
    }

    override fun yieldIfContendedSafely(): Boolean {
        return database.yieldIfContendedSafely()
    }

    override fun yieldIfContendedSafely(sleepAfterYieldDelay: Long): Boolean {
        return database.yieldIfContendedSafely(sleepAfterYieldDelay)
    }

    override fun close() {
        database.close()
    }

    override fun delete(table: String?, whereClause: String?, whereArgs: Array<out Any>?): Int {
        return database.delete(table, whereClause, whereArgs)
    }

    override fun needUpgrade(newVersion: Int): Boolean {
        return database.needUpgrade(newVersion)
    }

    override fun setMaxSqlCacheSize(cacheSize: Int) {
        database.setMaxSqlCacheSize(cacheSize)
    }

    override fun setForeignKeyConstraintsEnabled(enable: Boolean) {
        database.setForeignKeyConstraintsEnabled(enable)
    }

    override fun beginTransactionNonExclusive() {
        database.beginTransactionNonExclusive()
    }

    override fun setTransactionSuccessful() {
        database.setTransactionSuccessful()
    }

    override fun setVersion(version: Int) {
        database.version = version
    }

    override fun beginTransactionWithListener(transactionListener: SQLiteTransactionListener?) {
        database.beginTransactionWithListener(transactionListener)
    }

    override fun inTransaction(): Boolean {
        return database.inTransaction()
    }

    override fun isReadOnly(): Boolean {
        return database.isReadOnly
    }

    override fun getPath(): String {
        return database.path
    }

    override fun getPageSize(): Long {
        return database.pageSize
    }
}