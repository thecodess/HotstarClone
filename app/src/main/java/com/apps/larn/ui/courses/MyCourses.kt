package com.apps.larn.ui.courses
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apps.larn.ui.theme.BlueTheme
import com.google.accompanist.insets.statusBarsHeight
import com.apps.larn.R
import com.apps.larn.model.*
import com.apps.larn.ui.common.*

@Composable
fun MyCourses(
    courses: List<Course>,
    selectCourse: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    LazyColumn() {

      item{  CoursesAppBar(scaffoldState=scaffoldState, scope=scope)}
       item { Spacer(Modifier.statusBarsHeight()) }
      item {

           LazyRow(
               modifier = Modifier.fillMaxWidth(),
               contentPadding = PaddingValues(
                   all = 6.dp
               ), horizontalArrangement = Arrangement.spacedBy(16.dp)
           ) {

               item {
                   Spacer(Modifier.width(20.dp))
               }
               /*   item {
                   CoursesAppBar()
               }*/
               itemsIndexed(courses) { index, course ->
                   MyCourse(course, index, selectCourse)
               }
           }
          Spacer(Modifier.statusBarsHeight())
          Row(modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(16.dp)) {
              Text(
                  text = "Top Picks For You",
                  style = TextStyle(color = Color.White, fontSize = 20.sp)
              )
              Spacer(modifier = Modifier.width(270.dp))
              Image(
                  painter = painterResource(R.drawable.arrow),
                  contentDescription = "contentDescription",
                  modifier = Modifier
                      .width(20.dp)
                      .height(20.dp)
              )
          }
          LazyRow(modifier = Modifier.fillMaxWidth(),
              contentPadding = PaddingValues(
                  all = 6.dp
              ), horizontalArrangement = Arrangement.spacedBy(16.dp)) {

              item {
                  Spacer(Modifier.padding(20.dp))
              }
              /*   item {
                  CoursesAppBar()
              }*/
              itemsIndexed(movies) { index, movie ->
                  MyMovie(movie, index)
              }
          }

           Spacer(modifier = Modifier.width(20.dp))
           Row() {
               Text(
                   text = "Popular Movies",
                   style = TextStyle(color = Color.White, fontSize = 20.sp)
               )
               Spacer(modifier = Modifier.width(270.dp))
               Image(
                   painter = painterResource(R.drawable.arrow),
                   contentDescription = "contentDescription",
                   modifier = Modifier
                       .width(20.dp)
                       .height(20.dp)
               )
           }

           Spacer(Modifier.statusBarsHeight())
           LazyRow(modifier = Modifier.fillMaxWidth(),
               contentPadding = PaddingValues(
                   all = 6.dp
               ), horizontalArrangement = Arrangement.spacedBy(16.dp)) {

               item {
                   Spacer(Modifier.padding(20.dp))
               }
               /*   item {
                   CoursesAppBar()
               }*/
               itemsIndexed(movies) { index, movie ->
                   MyMovie(movie, index)
               }
           }
           Row() {
               Text(
                   text = "Popular TV Shows",
                   style = TextStyle(color = Color.White, fontSize = 20.sp)
               )
               Spacer(modifier = Modifier.width(270.dp))
               Image(
                   painter = painterResource(R.drawable.arrow),
                   contentDescription = "contentDescription",
                   modifier = Modifier
                       .width(20.dp)
                       .height(20.dp)
               )
           }
           Spacer(Modifier.statusBarsHeight())
           LazyRow(modifier = Modifier.fillMaxWidth(),
               contentPadding = PaddingValues(
                   all = 6.dp
               ), horizontalArrangement = Arrangement.spacedBy(16.dp)) {

               item {
                   Spacer(Modifier.padding(20.dp))
               }
               /*   item {
                   CoursesAppBar()
               }*/
               itemsIndexed(shows) { index, show ->
                   MyShows(show, index)
               }
           }
           Row() {
               Text(
                   text = "Popular Sports",
                   style = TextStyle(color = Color.White, fontSize = 20.sp)
               )
               Spacer(modifier = Modifier.width(270.dp))
               Image(
                   painter = painterResource(R.drawable.arrow),
                   contentDescription = "contentDescription",
                   modifier = Modifier
                       .width(20.dp)
                       .height(20.dp)
               )
           }
           Spacer(Modifier.statusBarsHeight())
           LazyRow(modifier = Modifier.fillMaxWidth(),
               contentPadding = PaddingValues(
                   all = 6.dp
               ), horizontalArrangement = Arrangement.spacedBy(16.dp)) {

               item {
                   Spacer(Modifier.padding(20.dp))
               }
               /*   item {
                   CoursesAppBar()
               }*/
               itemsIndexed(sports) { index, sport ->
                   MySport(sport, index)
               }
           }
          Spacer(Modifier.statusBarsHeight())
          Row() {
              Text(
                  text = "Popular News",
                  style = TextStyle(color = Color.White, fontSize = 20.sp)
              )
              Spacer(modifier = Modifier.width(270.dp))
              Image(
                  painter = painterResource(R.drawable.arrow),
                  contentDescription = "contentDescription",
                  modifier = Modifier
                      .width(20.dp)
                      .height(20.dp)
              )
          }
          Spacer(Modifier.statusBarsHeight())
          LazyRow(modifier = Modifier.fillMaxWidth(),
              contentPadding = PaddingValues(
                  all = 6.dp
              ), horizontalArrangement = Arrangement.spacedBy(16.dp)) {

              item {
                  Spacer(Modifier.padding(20.dp))
              }
              /*   item {
                  CoursesAppBar()
              }*/
              itemsIndexed(news) { index, sport ->
                  MyNews(sport, index)
              }
          }
       }
    }
}

@Composable
fun MyCourse(
    course: Course,
    index: Int,
    selectCourse: (Long) -> Unit
) {

        Column(modifier = Modifier.padding(bottom = 8.dp)) {

            val stagger = if (index % 2 == 0) 72.dp else 16.dp
            Spacer(modifier = Modifier.width(stagger))
            Row(modifier = Modifier.padding(bottom = 2.dp)) {
            CourseListItem(
                course = course,
                onClick = { selectCourse(course.id) },
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }
    }

}
@Composable
fun MyMovie(
    movie: Movie,
    index: Int,
 //   selectMovie: (Long) -> Unit
) {

    Column(modifier = Modifier.padding(bottom = 8.dp)) {

        val stagger = if (index % 2 == 0) 72.dp else 16.dp
        Spacer(modifier = Modifier.width(stagger))
        Row(modifier = Modifier.padding(bottom = 2.dp)) {
            MovieListItem(
                movie = movie,
                onClick = {/* selectMovie(movie.id)*/ },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
        }
    }

}
@Composable
fun MyShows(
    shows: Shows,
    index: Int,
    //   selectMovie: (Long) -> Unit
) {

    Column(modifier = Modifier.padding(bottom = 8.dp)) {

        val stagger = if (index % 2 == 0) 72.dp else 16.dp
        Spacer(modifier = Modifier.width(stagger))
        Row(modifier = Modifier.padding(bottom = 2.dp)) {
            ShowListItem(
                shows = shows,
                onClick = {/* selectMovie(movie.id)*/ },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
        }
    }

}
@Composable
fun MySport(
    sport: Sport,
    index: Int,
    //   selectMovie: (Long) -> Unit
) {

    Column(modifier = Modifier.padding(bottom = 8.dp)) {

        val stagger = if (index % 2 == 0) 72.dp else 16.dp
        Spacer(modifier = Modifier.width(stagger))
        Row(modifier = Modifier.padding(bottom = 2.dp)) {
            SportListItem(
                sport = sport,
                onClick = {/* selectMovie(movie.id)*/ },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
        }
    }

}

@Composable
fun MyNews(
    news: News,
    index: Int,
    //   selectMovie: (Long) -> Unit
) {

    Column(modifier = Modifier.padding(bottom = 8.dp)) {

        val stagger = if (index % 2 == 0) 72.dp else 16.dp
        Spacer(modifier = Modifier.width(stagger))
        Row(modifier = Modifier.padding(bottom = 2.dp)) {
            NewsListItem(
                news = news,
                onClick = {/* selectMovie(movie.id)*/ },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
        }
    }

}

@Preview(name = "My Courses")
@Composable
private fun MyCoursesPreview() {
    BlueTheme {
        MyCourses(
            courses = courses,
            selectCourse = { }
        )
    }
}
/*@Preview(name = "My Movies")
@Composable
private fun MyMoviesPreview() {
    BlueTheme {
        MyMovie(
           movies = movies,
            selectMovie = { }
        )
    }
}*/