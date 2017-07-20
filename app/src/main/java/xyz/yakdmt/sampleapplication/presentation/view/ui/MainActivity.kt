package xyz.yakdmt.sampleapplication.presentation.view.ui

import android.arch.lifecycle.LifecycleActivity
import android.databinding.DataBindingUtil.setContentView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import xyz.yakdmt.sampleapplication.R
import xyz.yakdmt.sampleapplication.data.entity.Project
import javax.inject.Inject

class MainActivity : LifecycleActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = ProjectListFragment()

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit()
        }
    }

    /** Shows the project detail fragment  */
    fun show(project: Project) {
        val projectFragment = ProjectFragment.forProject(project.name)

        supportFragmentManager
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container,
                        projectFragment, null).commit()
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
