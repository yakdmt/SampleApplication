package xyz.yakdmt.sampleapplication.presentation.view.ui

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.yakdmt.sampleapplication.R
import xyz.yakdmt.sampleapplication.data.entity.Project
import xyz.yakdmt.sampleapplication.databinding.FragmentProjectDetailsBinding
import xyz.yakdmt.sampleapplication.di.Injectable
import xyz.yakdmt.sampleapplication.presentation.viewmodel.ProjectViewModel
import javax.inject.Inject

/**
 * Created by yakdmt on 19/07/2017.
 */
class ProjectFragment : LifecycleFragment(), Injectable {

    private lateinit var binding: FragmentProjectDetailsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false)

        // Create and set the adapter for the RecyclerView.
        return binding.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ProjectViewModel::class.java)

        viewModel.setProjectID(arguments.getString(KEY_PROJECT_ID))

        binding.setProjectViewModel(viewModel)
        binding.setIsLoading(true)

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectViewModel) {
        // Observe project data
        viewModel.projectObservable.observe(this, Observer<Project> { project ->
            if (project != null) {
                binding.setIsLoading(false)
                viewModel.setProject(project)
            }
        })
    }

    companion object {
        private val KEY_PROJECT_ID = "project_id"

        /** Creates project fragment for specific project ID  */
        fun forProject(projectID: String): ProjectFragment {
            val fragment = ProjectFragment()
            val args = Bundle()

            args.putString(KEY_PROJECT_ID, projectID)
            fragment.arguments = args

            return fragment
        }
    }
}
