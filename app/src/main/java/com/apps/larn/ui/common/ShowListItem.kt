package com.apps.larn.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apps.larn.R
import com.apps.larn.model.Movie
import com.apps.larn.model.Shows
import com.apps.larn.model.movies
import com.apps.larn.model.shows
import com.apps.larn.ui.theme.BlueTheme

@Composable
fun ShowListItem(
    shows: Shows,
    onClick:()->Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier= modifier.fillMaxSize()
            .clickable(onClick = onClick),
        shape= RoundedCornerShape(15.dp),
        elevation = 5.dp
    ){
        Box(modifier= Modifier.height(200.dp)){
            Image(painter = painterResource(shows.image),
                contentDescription = "contentDescription",
                contentScale = ContentScale.Crop)

            Box(modifier= Modifier
                .fillMaxSize()
                .padding(20.dp),
                contentAlignment = Alignment.TopStart){
                Text(text = stringResource(
                    R.string.course_step_steps,
                    shows.step,
                    shows.steps
                ), style= TextStyle(color= Color.White, fontSize=16.sp)
                )
            }
        }
    }
}
/*@Composable
fun MovieListItem(
    course: Course,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(15.dp),
    elevation: Dp = OwlTheme.elevations.card,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
) {
    Surface(
        elevation = elevation,
        shape = shape,
        modifier = modifier
    ) {
        Row(modifier = Modifier.clickable(onClick = onClick)) {
            NetworkImage(
                url = course.thumbUrl,
                contentDescription = null,
                modifier = Modifier.aspectRatio(1f)
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            ) {
                Text(
                    text = course.name,
                    style = titleStyle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 4.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.OndemandVideo,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null,
                        modifier = Modifier.size(iconSize)
                    )
                    Text(
                        text = stringResource(
                            R.string.course_step_steps,
                            course.step,
                            course.steps
                        ),
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f)
                            .wrapContentWidth(Alignment.Start)
                    )
                    NetworkImage(
                        url = course.instructor,
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }
}*/


/*@Preview(name = "Course list item")
@Composable
private fun ShowListItemPreviewLight() {
    ShowListItemPreview(false)
}

@Preview(name = "Course list item – Dark")
@Composable
private fun ShowListItemPreviewDark() {
    ShowListItemPreview(true)
}

@Composable
private fun ShowListItemPreview(darkTheme: Boolean) {
    BlueTheme(darkTheme) {
        ShowListItem(
            shows = shows.first(),
            onClick = {}
        )
    }
}

 */