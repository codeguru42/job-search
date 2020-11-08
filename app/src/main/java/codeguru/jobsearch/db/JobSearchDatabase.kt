package codeguru.jobsearch.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Position::class), version = 1)
abstract class JobSearchDatabase : RoomDatabase() {
    abstract fun getPositionDao(): PositionDao
}
