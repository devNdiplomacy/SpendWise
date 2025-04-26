package com.devndiplomacy.spendwise

import androidx.room.Room
import androidx.room.RoomDatabase
import com.devndiplomacy.spendwise.db.SpendWiseDb
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSApplicationSupportDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual fun getPlatformDataBaseBuilder(): RoomDatabase.Builder<SpendWiseDb> {

    return getDatabaseBuilder()
}

fun getDatabaseBuilder(): RoomDatabase.Builder<SpendWiseDb> {

    val dbFilePath = documentDirectory() + "/$SPEND_WISE_DB"
    println("Db file path is $dbFilePath")
    return Room.databaseBuilder<SpendWiseDb>(
        name = dbFilePath,
    )

}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSApplicationSupportDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = true,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}