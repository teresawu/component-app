package data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(BorrowModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemAndPersonModel(): BorrowModelDao

    //This object is a companion of the instance
    companion object {
        private var instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "borrow_db")
                        .build()
            }
            return instance!!
        }
    }
}
