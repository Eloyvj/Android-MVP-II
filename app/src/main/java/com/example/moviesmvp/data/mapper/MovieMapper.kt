package com.example.moviesmvp.data.mapper

import com.example.moviesmvp.data.model.Genre
import com.example.moviesmvp.data.model.Movie
import com.example.moviesmvp.data.model.MovieDetail
import com.example.moviesmvp.data.network.response.MovieDetailResponse
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

        fun fromResponseToMovieDetailDomain(movieDetailResponse: MovieDetailResponse): MovieDetail {
            var genresList = mutableListOf<Genre>()
            for (genreResponse in movieDetailResponse.genres) {
                val genre = Genre(genreResponse.id,
                    genreResponse.name)
                genresList.add(genre)
            }

            var movieDetail = MovieDetail(
                genresList,
                movieDetailResponse.id,
                movieDetailResponse.overview,
                movieDetailResponse.posterPath,
                movieDetailResponse.releaseDate,
                movieDetailResponse.title
            )
            return movieDetail
        }
}