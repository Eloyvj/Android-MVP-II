package com.example.moviesmvp.data.mapper

import com.example.moviesmvp.data.model.Movie
import com.example.moviesmvp.data.network.response.MovieResponse

class MovieMapper {

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