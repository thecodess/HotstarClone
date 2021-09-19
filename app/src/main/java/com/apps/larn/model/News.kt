package com.apps.larn.model

import androidx.compose.runtime.Immutable
import com.apps.larn.R

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class News(
    val id: Long,
    val steps: Int,
    val step: Int,
    val image: Int
)

/**
 * A fake repo
 */
/*object NewsRepo {
    fun getNews(movieId: Long): News = news.find { it.id == newsId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") movieId: Long): List<News> = news
}*/

val news = listOf(
    News(
        id = 0,
        steps = 5,
        step = 1,
        image = R.drawable.ne1
    ),
    News(
        id = 1,
        steps = 5,
        step = 2,
        image = R.drawable.ne6
    ),
    News(
        id = 2,
        steps = 5,
        step = 3,
        image = R.drawable.sp1
    ),
    News(
        id = 3,
        steps = 5,
        step = 4,
        image = R.drawable.ne4
    ),
    News(
        id = 4,
        steps = 5,
        step = 5,
        image = R.drawable.ne1
    )
)