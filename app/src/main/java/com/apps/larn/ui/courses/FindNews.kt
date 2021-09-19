package com.apps.larn.ui.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.DrawerValue
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apps.larn.R
import com.apps.larn.model.Movie
import com.apps.larn.model.News
import com.apps.larn.ui.common.MovieListItem
import com.apps.larn.ui.common.NewsListItem
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun FindNews(
    news: List<News>,
    // selectCourse: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    LazyColumn() {

        item { CoursesAppBar(scaffoldState = scaffoldState, scope = scope) }
        item { Spacer(Modifier.statusBarsHeight()) }
        item {
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
                itemsIndexed(news) { index, news ->

                    Column(modifier = Modifier.padding(bottom = 8.dp)) {

                        val stagger = if (index % 2 == 0) 72.dp else 16.dp
                        Spacer(modifier = Modifier.width(stagger))
                        Row(modifier = Modifier.padding(bottom = 2.dp)) {
                            NewsListItem(
                                news = news,
                                onClick = {  },
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                            )
                        }
                    }
                }
            }

        }
    }
}

