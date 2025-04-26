package com.devndiplomacy.spendwise

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devndiplomacy.spendwise.db.SpendWiseDb

@SuppressLint("StaticFieldLeak")
object GetContext{

    private lateinit var ctx: Context

    fun setContext(ctx: Context){
        this.ctx = ctx
    }

    fun getContext(): Context{
        return ctx
    }
}
actual fun getPlatformDataBaseBuilder(): RoomDatabase.Builder<SpendWiseDb> {
    val appContext = GetContext.getContext().applicationContext
    val dbFile = appContext.getDatabasePath(SPEND_WISE_DB)
    return Room.databaseBuilder<SpendWiseDb>(
        context = appContext,
        name = dbFile.absolutePath
    )
}