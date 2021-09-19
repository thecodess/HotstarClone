package com.apps.larn.model

import androidx.compose.runtime.Immutable
import com.apps.larn.R

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class Course(
    val id: Long,
    val steps: Int,
    val step: Int,
    val image: Int
)

/**
 * A fake repo
 */
object CourseRepo {
    fun getCourse(courseId: Long): Course = courses.find { it.id == courseId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") courseId: Long): List<Course> = courses
}

val courses = listOf(
    Course(
        id = 0,
        steps = 5,
        step = 1,
    image = R.drawable.pic1
    ),
    Course(
        id = 1,
        steps = 5,
        step = 2,
        image = R.drawable.pic2
    ),
    Course(
        id = 2,
        steps = 5,
        step = 3,
        image = R.drawable.pic3
    ),
    Course(
        id = 3,
        steps = 5,
        step = 4,
        image = R.drawable.pic4
    ),
    Course(
        id = 4,
        steps = 5,
        step = 5,
        image = R.drawable.pic5
    )
)