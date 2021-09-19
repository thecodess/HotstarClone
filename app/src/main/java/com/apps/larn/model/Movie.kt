package com.apps.larn.model

import androidx.compose.runtime.Immutable
import com.apps.larn.R

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class Movie(
    val id: Long,
    val steps: Int,
    val step: Int,
    val image: Int
)

/**
 * A fake repo
 */
object MovieRepo {
    fun getMovie(movieId: Long): Movie = movies.find { it.id == movieId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") movieId: Long): List<Movie> = movies
}

val movies = listOf(
    Movie(
        id = 0,
        steps = 5,
        step = 1,
        image = R.drawable.con1
    ),
    Movie(
        id = 1,
        steps = 5,
        step = 2,
        image = R.drawable.con2
    ),
    Movie(
        id = 2,
        steps = 5,
        step = 3,
        image = R.drawable.con3
    ),
    Movie(
        id = 3,
        steps = 5,
        step = 4,
        image = R.drawable.con4
    )
)