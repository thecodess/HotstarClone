package com.apps.larn.ui.courses

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.apps.larn.R
import com.apps.larn.model.*
import com.apps.larn.ui.MainDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun NavGraphBuilder.courses(
    onCourseSelected: (Long, NavBackStackEntry) -> Unit,

    onboardingComplete: State<Boolean>, // https://issuetracker.google.com/174783110
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable(CourseTabs.HOME.route) { from ->
        // Show onboarding instead if not shown yet.
        LaunchedEffect(onboardingComplete) {
            if (!onboardingComplete.value) {
                navController.navigate(MainDestinations.ONBOARDING_ROUTE)
            }
        }
        if (onboardingComplete.value) { // Avoid glitch when showing onboarding
            FeaturedCourses(
                courses = courses,
                selectCourse = { id -> onCourseSelected(id, from) },
                modifier = modifier
            )

        }
    }
    composable(CourseTabs.HOME.route) { from ->
        MyCourses(
            courses = courses,
            { id -> onCourseSelected(id, from) },
            modifier

        )

    }
    composable(CourseTabs.MOVIES.route) { from ->
        FindMovies(
            movies = movies,
          //  { id -> onCourseSelected(id, from) },
            modifier

        )

    }
    composable(CourseTabs.SHOWS.route) { from ->
        FindShows(
           shows = shows,
            //  { id -> onCourseSelected(id, from) },
            modifier

        )

    }
    composable(CourseTabs.SPORTS.route) { from ->
        FindSports(
            sports = sports,
            //  { id -> onCourseSelected(id, from) },
            modifier

        )

    }
    composable(CourseTabs.NEWS.route) { from ->
        FindNews(
            news = news,
            //  { id -> onCourseSelected(id, from) },
            modifier

        )

    }
 /*   composable(CourseTabs.SEARCH.route) {
        SearchCourses(topics, modifier)
    }*/
}

@Composable
fun CoursesAppBar(scaffoldState: ScaffoldState,scope: CoroutineScope) {
    /*TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(80.dp).background(Color.Black)

    ) {
      /*  Image(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.ic_lockup_white),
            contentDescription = null
        )*/
        Text(text="Hotstar", fontSize=20.sp, modifier = Modifier
           // .padding(16.dp)
            .align(Alignment.CenterVertically), style= TextStyle(color= Color.White, fontSize=16.sp)
        )
      /*  IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = stringResource(
                    R.string.label_profile)
            )
        }*/
    }*/
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(80.dp).background(Color.Black),
                title = { Text(text = "Hotstar") },

        navigationIcon = {
            val scaffoldState =
                rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
            val scope = rememberCoroutineScope()
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "Menu", modifier = Modifier.clickable {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },

        actions = {
            val context = LocalContext.current

                Icon(
                    painter = painterResource(R.drawable.ic_cast),
                    contentDescription = "", modifier = Modifier.clickable {
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                    }
                )

            Icon(
                painter = painterResource(R.drawable.ic_baseline_search_24),
                contentDescription = "Search", modifier = Modifier.clickable {
                    Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                }
            )
        }
    )
}
@Composable
fun DrawerContentSample() {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    DrawerContent(scaffoldState,scope)
}

@Composable
fun DrawerContent(scaffoldState: ScaffoldState, scope: CoroutineScope) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.arrow),
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally), contentDescription = "Face"
        )

        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Login for a better experience",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.align(
                Alignment.Start
            )
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Close",
            Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(8.dp, 4.dp)
                .clickable {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                })
        Spacer(modifier = Modifier.padding(4.dp))
    }
}
enum class CourseTabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    HOME(R.string.home, R.drawable.ic_home, CoursesDestinations.HOME_ROUTE),
    SHOWS(R.string.shows, R.drawable.ic_tv, CoursesDestinations.SHOWS_ROUTE),
    MOVIES(R.string.movies, R.drawable.ic_movies, CoursesDestinations.MOVIES_ROUTE),
    SPORTS(R.string.sports, R.drawable.ic_sport, CoursesDestinations.SPORTS_ROUTE),
    NEWS(R.string.news, R.drawable.ic_news, CoursesDestinations.NEWS_ROUTE),
}

/**
 * Destinations used in the ([OwlApp]).
 */
private object CoursesDestinations {
    const val HOME_ROUTE = "courses/course"
    const val SHOWS_ROUTE = "courses/shows"
    const val MOVIES_ROUTE = "courses/movies"
    const val SPORTS_ROUTE = "courses/sports"
    const val NEWS_ROUTE = "courses/search"
}