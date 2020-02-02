package com.example.moviesmvp.features.popularmovieslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesmvp.R
import com.example.moviesmvp.features.data.model.Movie

class PopularMoviesAdapter(private val clickItem: (Int) -> Unit):
    RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {
    private var listOfPopularMovies = mutableListOf<Movie>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfPopularMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listOfPopularMovies[position]
        holder.bindView(movie, clickItem, context)
    }

    fun addAll(newMoviesList: List<Movie>) {
        if (listOfPopularMovies.isNullOrEmpty()) {
            listOfPopularMovies.addAll(newMoviesList)
            notifyDataSetChanged()
        } else {
            val curSize = itemCount
            listOfPopularMovies.addAll(newMoviesList)
            notifyItemRangeInserted(curSize, listOfPopularMovies.size - 1)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(movie: Movie, onClick: (Int) -> Unit, context: Context) {
            val urlPoster = "https://image.tmdb.org/t/p/w342${movie.posterPath}"
            val movieTitle = itemView.findViewById<TextView>(R.id.textview_movielist_title)
            val moviePoster = itemView.findViewById<ImageView>(R.id.imageview_movielist_poster)

            movieTitle.text = movie.title
            Glide
                .with(itemView.context)
                .load(urlPoster)
                .placeholder(R.drawable.ic_submit_progress)
                .error(R.drawable.ic_unavailable)
                .into(moviePoster)

            val favoriteIcon = itemView.findViewById<ImageView>(R.id.imageview_favored_title)
            val favoriteEmptyIcon = ContextCompat.getDrawable(context, R.drawable.ic_favorite_empty_icon)
            favoriteIcon.setImageDrawable(favoriteEmptyIcon)

            val movieId = movie.id
            itemView.setOnClickListener {
                onClick(movieId)
            }
        }
    }
}