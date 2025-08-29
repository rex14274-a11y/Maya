package com.maya.app

import android.app.Application
import androidx.room.Room
import net.sqlcipher.database.SupportFactory
import net.zetetic.sqlcipher.SQLCipherUtils

class MayaApplication : Application() {
    val db: MemoryDb by lazy {
        Room.databaseBuilder(this, MemoryDb::class.java, "maya_enc")
            .openHelperFactory(SupportFactory(SQLCipherUtils.getPassphrase(this)))
            .build()
    }
}
