package com.example.moviesmvp.features.popularmovieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvp.R
import com.example.moviesmvp.features.Application.App
import com.example.moviesmvp.features.popularmovieslist.di.PopularMoviesModule
import com.example.moviesmvp.features.data.model.Movie
import com.example.moviesmvp.features.popularmovieslist.di.DaggerPopularMoviesComponent
import kotlinx.android.synthetic.main.error_message_and_load_retry.*
import kotlinx.android.synthetic.main.fragment_popular_movies.*
import javax.inject.Inject


private const val POSITION_OF_LAYOUT_PROGRESS_BAR = 0
private const val POSITION_OF_LAYOUT_MOVIES_LIST = 1
private const val POSITION_OF_LAYOUT_ERROR = 2
private const val POSITION_OF_LAYOUT_SEARCH_EMPTY = 3
private const val NUMBER_OF_COLUMNS = 2

class PopularMoviesFragment : Fragment(), PopularMoviesView {

    @Inject
    lateinit var presenter: PopularMoviesPresenter

    private lateinit var adapter: PopularMoviesAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    private var visibleItemCount = 0
    private var totalItemCount = 0
    private var pastVisiblesItems = 0
    private var isScrolling = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerPopularMoviesComponent
            .builder()
            .appComponent(App.getComponent())
            .popularMoviesModule(
                PopularMoviesModule(
                    this
                )
            )
            .build()
            .inject(this)

        setUpRecyclerView()
        presenter.loadItems()
        setUpRecyclerView()
        setUpScrollListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }

    override fun setUpListForAdapter(movies: List<Movie>) {
        movies.let {
            hideProgressBar()
            adapter.addAll(it)
        }
    }

    override fun reloadFromError() {
        button_main_load_movies.setOnClickListener {
            presenter.loadItems()
        }
    }

    override fun showProgressBar() {
        viewflipper_main_movies_list.setDisplayedChild(POSITION_OF_LAYOUT_PROGRESS_BAR)
    }

    override fun hideProgressBar() {
        viewflipper_main_movies_list.setDisplayedChild(POSITION_OF_LAYOUT_MOVIES_LIST)
    }

    override fun showErrorLayout() {
        viewflipper_main_movies_list.setDisplayedChild(POSITION_OF_LAYOUT_ERROR)
    }

    private fun setUpScrollListener() {
        recyclerview_main_movies_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                visibleItemCount = gridLayoutManager.childCount
                totalItemCount = gridLayoutManager.itemCount
                pastVisiblesItems = gridLayoutManager.findFirstVisibleItemPosition()

                if (isScrolling && (visibleItemCount + pastVisiblesItems == totalItemCount)) {
                    isScrolling = false
                    presenter.loadItems()
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        adapter = PopularMoviesAdapter { movieId -> openMovieDetailActivity(movieId)}
        gridLayoutManager = GridLayoutManager(context, NUMBER_OF_COLUMNS)

        recyclerview_main_movies_list.layoutManager = gridLayoutManager
        recyclerview_main_movies_list.adapter = adapter
    }

    private fun openMovieDetailActivity(movieId: Int) {
        activity?.let {
            val id = movieId.toString()
            /*val intent = MovieDetailActivity.newIntent(it, id)
            it.startActivity(intent)*/
        }
    }
}
