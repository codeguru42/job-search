package codeguru.jobsearch.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Position(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var title: String,
    var businessName: String
)
