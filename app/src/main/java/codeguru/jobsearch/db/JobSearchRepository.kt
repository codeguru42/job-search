package codeguru.jobsearch.db

class JobSearchRepository(private val db: JobSearchDatabase) {
    private val positionDao = db.getPositionDao()

    fun insertPositions(vararg positions: Position) {
        db.queryExecutor.execute{
            positionDao.insertPositions(*positions)
        }
    }

    fun updatePositions(vararg positions: Position) {
        db.queryExecutor.execute{
            positionDao.insertPositions(*positions)
        }
    }

    fun deletePositions(vararg positions: Position) {
        db.queryExecutor.execute{
            positionDao.insertPositions(*positions)
        }
    }

    fun getPositions() = positionDao.getPositions()
}
