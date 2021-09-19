package com.apps.larn.model

import androidx.compose.runtime.Immutable
import com.apps.larn.R

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class Shows(
    val id: Long,
    val steps: Int,
    val step: Int,
    val image: Int
)

/**
 * A fake repo
 */
/*object ShowseRepo {
    fun getCourse(courseId: Long): Course = courses.find { it.id == courseId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") courseId: Long): List<Course> = courses
}*/

val shows = listOf(
    Shows(
        id = 0,
        steps = 5,
        step = 1,
        image = R.drawable.tv1
    ),
    Shows(
        id = 1,
        steps = 5,
        step = 2,
        image = R.drawable.tv2
    ),
    Shows(
        id = 2,
        steps = 5,
        step = 3,
        image = R.drawable.tv3
    ),
    Shows(
        id = 3,
        steps = 5,
        step = 4,
        image = R.drawable.tv4
    )

)