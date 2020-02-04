package com.example.moviesmvp.features.data.mapper

import com.example.moviesmvp.features.data.model.Movie
import com.example.moviesmvp.features.data.network.response.MovieResponse

class MovieMapper {

    companion object {
        fun fromResponseToMovieDomain(movieResponseList: List<MovieResponse>) : List<Movie> {
            var moviesList = mutableListOf<Movie>()

            for (movieResponse in movieResponseList) {
                val movie = Movie(movieResponse.id,
                    movieResponse.originalTitle,
                    movieResponse.posterPath)
                moviesList.add(movie)
            }

            return moviesList
        }
    }
}