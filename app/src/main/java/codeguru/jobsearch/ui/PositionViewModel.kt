package codeguru.jobsearch.ui

import androidx.lifecycle.ViewModel
import codeguru.jobsearch.db.JobSearchRepository
import codeguru.jobsearch.db.Position

class PositionViewModel(private val repository: JobSearchRepository): ViewModel() {
    fun insertPositions(vararg positions: Position) = repository.insertPositions(*positions)
    fun updatePositions(vararg positions: Position) = repository.updatePositions(*positions)
    fun deletePositions(vararg positions: Position) = repository.deletePositions(*positions)
    fun getPositions() = repository.getPositions()
}
