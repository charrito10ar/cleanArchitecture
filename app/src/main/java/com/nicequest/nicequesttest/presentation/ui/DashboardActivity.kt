package com.nicequest.nicequesttest.presentation.ui

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.nicequest.nicequesttest.R
import com.nicequest.nicequesttest.presentation.adapters.CatAdapter
import com.nicequest.nicequesttest.presentation.adapters.EndlessRecyclerViewScrollListener
import com.nicequest.nicequesttest.di.components.ApplicationComponent
import com.nicequest.nicequesttest.di.components.DaggerDashboardComponent
import com.nicequest.nicequesttest.di.modules.DashboardModule
import com.nicequest.nicequesttest.domain.model.ItemCat
import com.nicequest.nicequesttest.presentation.BaseActivity
import com.nicequest.nicequesttest.presentation.presenters.DashboardFragmentPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardFragmentView{

    @Inject lateinit var catsAdapter: CatAdapter
    @Inject lateinit var presenter: DashboardFragmentPresenter

    private lateinit var appComponent: ApplicationComponent

    override fun setupComponent(appComponent: ApplicationComponent?) {
        this.appComponent = appComponent!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "NiceQuestTest"
        setUpRecyclerView()
        DaggerDashboardComponent.builder()
                .dashboardModule(DashboardModule(this, applicationContext))
                .build().inject(this)
        setupList()
        presenter.subscribe(1)
    }

    private fun setUpRecyclerView() {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS;
        recycler_view_items.layoutManager = staggeredGridLayoutManager
        recycler_view_items.addOnScrollListener(object : EndlessRecyclerViewScrollListener(staggeredGridLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                presenter.loadMoreItems(page)
            }
        })
        swipe_refresh_layout.setProgressViewOffset(false, 0,200)
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun setupList() {
        recycler_view_items.adapter = catsAdapter
    }

    override fun showList(list: List<ItemCat>) {
        catsAdapter.addResults(list)
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessageError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        swipe_refresh_layout.isEnabled = false
        swipe_refresh_layout.isRefreshing = false
    }

    override fun showLoading() {
        swipe_refresh_layout.isEnabled = true
        swipe_refresh_layout.isRefreshing = true
    }
}
