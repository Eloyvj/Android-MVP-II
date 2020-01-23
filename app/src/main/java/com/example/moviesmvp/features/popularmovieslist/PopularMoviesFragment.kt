package com.example.moviesmvp.features.popularmovieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviesmvp.R
import com.example.moviesmvp.features.data.model.Result

class PopularMoviesFragment : Fragment(), PopularMoviesFragmentView {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }


    // View implementations
    override fun setUpScrollListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadMoreItems() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUpObservables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUpRecyclerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reloadFromError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMovieDetailActivity(movieId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUpListForAdapter(moviesList: List<Result>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptySearchLayout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchAllMoviesCaseQueryIsEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
