package com.devndiplomacy.spendwise

import androidx.room.Room
import androidx.room.RoomDatabase
import com.devndiplomacy.spendwise.db.SpendWiseDb
import java.io.File

actual fun getPlatformDataBaseBuilder(): RoomDatabase.Builder<SpendWiseDb> {

    val dbFile = File(System.getProperty("java.io.tmpdir"), SPEND_WISE_DB)
    println("Db file path is ${dbFile.absolutePath}")
    return Room.databaseBuilder<SpendWiseDb>(
        name = dbFile.absolutePath,
    )
}