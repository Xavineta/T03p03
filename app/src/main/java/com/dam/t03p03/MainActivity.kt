package com.dam.t03p03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.t03p03.ui.theme.DataSource
import com.dam.t03p03.ui.theme.Day
import com.dam.t03p03.ui.theme.T03p03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            T03p03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun SevenDaysApp() {

    LazyVerticalGrid(verticalArrangement = Arrangement.spacedBy(15.dp)
        ,columns = GridCells.Fixed(1), content = {
        items(DataSource.days) {
            SevenDaysCard(modifier = Modifier, day =it )
        }
    })
}

@Composable
private fun SevenDaysCard(
    modifier: Modifier,
    day: Day
) {

    Card(shape = ) {
        Row {
            Text(text = stringResource(id = day.day))
        }
        Spacer(
            modifier =
            Modifier.size(10.dp)
        )
        Row {
            Text(text = stringResource(id = day.text))

        }
        Image(painter = painterResource(id = day.foto), contentDescription =null)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SevenDaysCardPreview() {
    T03p03Theme {
        SevenDaysApp()
    }
}