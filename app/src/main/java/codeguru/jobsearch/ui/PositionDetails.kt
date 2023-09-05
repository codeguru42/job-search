package codeguru.jobsearch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import codeguru.jobsearch.R
import codeguru.jobsearch.db.JobSearchDatabase
import codeguru.jobsearch.db.JobSearchRepository
import codeguru.jobsearch.db.Position
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PositionDetails : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.position_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = activity?.let { JobSearchDatabase.getDatabase(it) }!!
        val repository = JobSearchRepository(db)
        val viewModel = PositionViewModel(repository)

        view.findViewById<FloatingActionButton>(R.id.position_save).setOnClickListener {
            val title = view.findViewById<EditText>(R.id.text_title).text.toString()
            val company = view.findViewById<EditText>(R.id.text_business_name).text.toString()
            val position = Position(null, title, company)
            viewModel.insertPositions(position)

            findNavController().navigate(R.id.position_list)
        }
    }
}
