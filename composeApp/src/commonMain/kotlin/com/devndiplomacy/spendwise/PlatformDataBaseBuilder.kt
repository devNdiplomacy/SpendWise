package com.devndiplomacy.spendwise

import androidx.room.RoomDatabase
import  androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.devndiplomacy.spendwise.db.SpendWiseDb
import kotlinx.coroutines.Dispatchers

expect fun getPlatformDataBaseBuilder(): RoomDatabase.Builder<SpendWiseDb>

fun getDataBase(
    dbBuilder: RoomDatabase.Builder<SpendWiseDb> = getPlatformDataBaseBuilder()
): SpendWiseDb {

    return dbBuilder
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.Default)
        .build()
}