package me.tadebois.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tadebois.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTogetherApp()
                }
            }
        }
    }
}

@Composable
fun LearnTogetherApp(modifier: Modifier = Modifier) {
    val headerPainter = painterResource(id = R.drawable.bg_compose_background)
    val title = stringResource(id = R.string.article_title)
    val description = stringResource(id = R.string.article_description)
    val body = stringResource(id = R.string.article_body)

    Column(modifier = modifier) {
        HeaderImage(headerPainter)
        Article(
            title = title,
            description = description,
            body = body
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LearnTogetherAppPreview() {
    LearnTogetherTheme {
        LearnTogetherApp()
    }
}

@Composable
fun HeaderImage(headerPainter: Painter, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = headerPainter,
        contentDescription = null
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderImagePreview() {
    LearnTogetherTheme {
        HeaderImage(painterResource(id = R.drawable.bg_compose_background))
    }
}

@Composable
fun Article(title: String, description: String, body: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = description,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
    Text(
        text = body,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}
