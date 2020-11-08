package codeguru.jobsearch.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PositionDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertPositions(vararg positions: Position)

    @Update
    fun updatePositions(vararg positions: Position)

    @Delete
    fun deletePositions(vararg positions: Position)

    @Query("SELECT * FROM position")
    fun getPositions(): LiveData<List<Position>>
}
