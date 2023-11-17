package com.dam.t03p03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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

    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        columns = GridCells.Fixed(1),
        content = {
            items(DataSource.days) {
         //       SevenDaysCard(modifier = Modifier, day = it)
            }
        })
}

@Composable
private fun SevenDaysCard(
    modifier: Modifier,
    day: Day,
    expand:()->Unit
) {

    Card(
        modifier = Modifier
            .size(width = 70.dp, height = 250.dp)
            .padding(10.dp)
            .clickable {
                       Modifier.size(100.dp,300.dp)
            },
    ) {
        Row(modifier = Modifier
            .padding(start = 15.dp, top = 10.dp)
        ) {
            Text(text = stringResource(id = day.day))
        }
        Row(modifier = Modifier
            .padding(start = 15.dp, top = 5.dp)) {
            Text(text = stringResource(id = day.text))
        }

        Column(
            modifier=Modifier
                .padding(start = 50.dp,top=5.dp)
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(350.dp)
                ,
                painter = painterResource(id = day.foto),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    }
}
    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun SevenDaysCardPreview() {
        T03p03Theme {
            SevenDaysApp()
        }
    }