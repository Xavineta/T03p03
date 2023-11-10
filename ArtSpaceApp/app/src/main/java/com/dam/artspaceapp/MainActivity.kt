package com.dam.artspaceapp

import android.graphics.drawable.shapes.Shape
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var step by remember { mutableIntStateOf(1) }

    var image: Painter = when (step) {
        1 -> painterResource(R.drawable.muerte_viriato)
        2 -> painterResource(R.drawable.romacaida)
        3 -> painterResource(R.drawable.tercios)
        4 -> painterResource(R.drawable.cruzadas)
        else -> {
            painterResource(R.drawable.muerte_viriato)
        }
    }

    var imageDescription: String = when (step) {
        1 -> stringResource(R.string.imagen_viriato)
        2 -> stringResource(R.string.imagen_caida_roma)
        3 -> stringResource(R.string.imagen_tercios)
        4 -> stringResource(R.string.imagen_cruzadas)
        else -> {
            stringResource(R.string.imagen_viriato)
        }
    }

    var artworkTitle: String = when (step) {
        1 -> stringResource(R.string.title_viriato)
        2 -> stringResource(R.string.title_roma_caida)
        3 -> stringResource(R.string.title_tercios)
        4 -> stringResource(R.string.title_cruzados)
        else -> {
            stringResource(R.string.title_viriato)
        }
    }

    var artworkArtist: String = when (step) {
        1 -> stringResource(R.string.artist_viriato)
        2 -> stringResource(R.string.artist_roma_caida)
        3 -> stringResource(R.string.artist_tercios)
        4 -> stringResource(R.string.artist_cruzados)
        else -> {
            stringResource(R.string.artist_viriato)
        }
    }

    var artworkYear: String = when (step) {
        1 -> stringResource(R.string.year_viriato)
        2 -> stringResource(R.string.year_roma_caida)
        3 -> stringResource(R.string.year_tercios)
        4 -> stringResource(R.string.year_cruzados)
        else -> {
            stringResource(R.string.year_viriato)
        }
    }
    ArtSpace(
        modifier = Modifier,
        image = image,
        imageDescription = imageDescription,
        artworkTitle = artworkTitle,
        artworkArtist = artworkArtist,
        artworkYear = artworkYear,
        previous = {
            step--
            if (step < 1) {
                step = 4
            }
        },
        next = {
            step++
            if (step>4) {
                step=1
            }

        })
}


@Composable
private fun ArtSpace(
    modifier: Modifier,
    image: Painter,
    imageDescription: String,
    artworkTitle: String,
    artworkArtist: String,
    artworkYear: String,
    previous: () -> Unit,
    next: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .shadow(10.dp, shape = RectangleShape)
                .padding(16.dp)
                .border(4.dp, Color.White, shape = RectangleShape)
        ) {
            Image(
                modifier = Modifier
                    .size(350.dp)
                    .padding(20.dp),
                painter = image,
                contentDescription = imageDescription,
            )
        }
        Spacer(modifier = modifier.size(20.dp))
        Row {
            Text(
                modifier = Modifier, text = artworkTitle, fontSize = 25.sp
            )
        }
        Spacer(modifier = modifier.size(35.dp))
        Row {
            Text(
                modifier = Modifier, text = artworkArtist, fontSize = 20.sp
            )
            Spacer(modifier = modifier.size(35.dp))
            Text(
                modifier = Modifier, text = String.format("($artworkYear)"), fontSize = 20.sp
            )
        }
        Row {

            Button(onClick = previous) {
                Text("Anterior", fontSize = 15.sp)
            }
            Spacer(modifier = modifier.size(50.dp))
            Button(onClick = next) {
                Text("Siguiente", fontSize = 15.sp)
            }
        }
    }
}

@Composable
private fun ArtSpaceImage(
    modifier: Modifier = Modifier,
    image: Painter,
    imageDescription: String,
) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .border(4.dp, Color.White, shape = RectangleShape)
    ) {
        Image(
            modifier = Modifier
                .size(350.dp)
                .background(Color.Red)
                .padding(20.dp),
            painter = image,
            contentDescription = imageDescription,
        )
    }
}

@Composable
private fun ArtSpaceButtons(
    modifier: Modifier,
    previous: () -> Unit,
    next: () -> Unit
) {
    Row {

        Button(onClick = previous) {
            Text("Anterior", fontSize = 15.sp)
        }
        Spacer(modifier = modifier.size(50.dp))
        Button(onClick = next) {
            Text("Siguiente", fontSize = 15.sp)
        }
    }
}


@Composable
private fun ArtSpaceInfo(
    modifier: Modifier = Modifier,
    artworkTitle: String,
    artworkArtist: String,
    artworkYear: String
) {
    Row {
        Text(
            modifier = Modifier, text = artworkTitle, fontSize = 25.sp
        )
    }
    Row {
        Text(
            modifier = Modifier, text = artworkArtist, fontSize = 20.sp
        )
        Spacer(modifier = modifier.size(20.dp))
        Text(
            modifier = Modifier, text = String.format("( $artworkYear) "), fontSize = 20.sp
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}