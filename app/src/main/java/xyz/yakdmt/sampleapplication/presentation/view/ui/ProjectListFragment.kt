package xyz.yakdmt.sampleapplication.presentation.view.ui

import android.arch.lifecycle.*
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.yakdmt.sampleapplication.R
import xyz.yakdmt.sampleapplication.data.entity.Project
import xyz.yakdmt.sampleapplication.databinding.FragmentProjectListBinding
import xyz.yakdmt.sampleapplication.di.Injectable
import xyz.yakdmt.sampleapplication.presentation.view.adapter.CustomBindingAdapter
import xyz.yakdmt.sampleapplication.presentation.view.adapter.ProjectAdapter
import xyz.yakdmt.sampleapplication.presentation.view.callback.IProjectClickCallback
import xyz.yakdmt.sampleapplication.presentation.viewmodel.ProjectListViewModel
import javax.inject.Inject

/**
 * Created by yakdmt on 19/07/2017.
 */
class ProjectListFragment : LifecycleFragment(), Injectable {
    private var projectAdapter: ProjectAdapter? = null
    private var binding: FragmentProjectListBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false)

        projectAdapter = ProjectAdapter(projectClickCallback)
        binding!!.projectList.setAdapter(projectAdapter)
        binding!!.setIsLoading(true)

        return binding!!.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(ProjectListViewModel::class.java)

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel) {
        // Update the list when the data changes
        viewModel.projectListObservable.observe(this, Observer<List<Project>> { projects ->
            if (projects != null) {
                binding!!.setIsLoading(false)
                projectAdapter!!.setProjectList(projects)
            }
        })
    }

    private val projectClickCallback = object : IProjectClickCallback {
        override fun onClick(project: Project) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as MainActivity).show(project)
            }
        }
    }

    companion object {
        val TAG = "ProjectListFragment"
    }
}
