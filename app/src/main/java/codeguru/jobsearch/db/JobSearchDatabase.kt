package codeguru.jobsearch.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Position::class), version = 1)
abstract class JobSearchDatabase : RoomDatabase() {
    abstract fun getPositionDao(): PositionDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: JobSearchDatabase? = null

        fun getDatabase(context: Context): JobSearchDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JobSearchDatabase::class.java,
                    "job_search"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }}
