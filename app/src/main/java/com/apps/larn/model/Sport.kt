package com.apps.larn.model

import androidx.compose.runtime.Immutable
import com.apps.larn.R

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class Sport(
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

val sports = listOf(
    Sport(
        id = 0,
        steps = 6,
        step = 1,
        image = R.drawable.sp1
    ),
    Sport(
        id = 1,
        steps = 6,
        step = 2,
        image = R.drawable.sp2
    ),
    Sport(
        id = 2,
        steps = 6,
        step = 3,
        image = R.drawable.sp3
    ),
    Sport(
        id = 3,
        steps = 6,
        step = 4,
        image = R.drawable.sp4
    ),
    Sport(
        id = 4,
        steps = 6,
        step = 5,
        image = R.drawable.sp5
    ),
    Sport(
        id = 4,
        steps = 6,
        step = 6,
        image = R.drawable.sp6
    )
)