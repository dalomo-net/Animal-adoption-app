/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ComposeNavigation()
            }
        }
    }
}

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "list_screen"
    ) {
        composable("list_screen") {
            LazyList(navController = navController)
        }
        composable(
            "detail_screen/{uid}",
            arguments = listOf(navArgument("uid") { type = NavType.IntType })
        ) { backStackEntry ->
            Detail(backStackEntry.arguments?.getInt("uid"))
        }
    }
}

@Composable
fun LazyList(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            item {
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = ""
                )
            }
            item {
                Card(R.drawable._00, "Taro", navController)
            }
            item {
                Card(R.drawable._01, "Hanako", navController)
            }
            item {
                Card(R.drawable._02, "Goro", navController)
            }
            item {
                Card(R.drawable._03, "Yasu", navController)
            }
            item {
                Card(R.drawable._04, "Gonzo", navController)
            }
            item {
                Card(R.drawable._05, "Hina", navController)
            }
            item {
                Card(R.drawable._06, "Ken", navController)
            }
            item {
                Card(R.drawable._07, "Kan", navController)
            }
            item {
                Card(R.drawable._08, "Ichi", navController)
            }
            item {
                Card(R.drawable._09, "JF", navController)
            }
            item {
                Card(R.drawable._10, "Dolly", navController)
            }
        }
    }
}

@Composable
fun Card(rid: Int, name: String, navController: NavController) {
    val image = painterResource(id = rid)

    Column(
        Modifier
            .clickable(onClick = { navController.navigate("detail_screen/$rid") })
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center

    ) {
        val imageModifier = Modifier
            .wrapContentSize()
            .clip(shape = RoundedCornerShape(14.dp))
        Image(image, "", modifier = imageModifier, contentScale = ContentScale.Crop)
        Text(text = name, style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.End))
    }
}

@Composable
fun Detail(rid: Int?) {
    val image = painterResource(id = rid!!)
    val name = getAnimalName(rid)
    val age = getAnimalAge(rid)

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val imageModifier = Modifier
            .wrapContentSize()
            .clip(shape = RoundedCornerShape(14.dp))
        Image(image, "", modifier = imageModifier, contentScale = ContentScale.Crop)
        Text(text = name, style = TextStyle(fontSize = 50.sp))
        Text(text = "Age : $age", style = TextStyle(fontSize = 20.sp))
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    }
}

fun getAnimalName(rid: Int) =
    when (rid) {
        R.drawable._00 -> "Taro"
        R.drawable._01 -> "Hanako"
        R.drawable._02 -> "Goro"
        R.drawable._03 -> "Yasu"
        R.drawable._04 -> "Gonzo"
        R.drawable._05 -> "Hina"
        R.drawable._06 -> "Ken"
        R.drawable._07 -> "Kan"
        R.drawable._08 -> "Ichi"
        R.drawable._09 -> "JF"
        R.drawable._10 -> "Dolly"
        else -> ""
    }

fun getAnimalAge(rid: Int) =
    when (rid) {
        R.drawable._00 -> "33"
        R.drawable._01 -> "27"
        R.drawable._02 -> "56"
        R.drawable._03 -> "10000"
        R.drawable._04 -> "13"
        R.drawable._05 -> "18"
        R.drawable._06 -> "44"
        R.drawable._07 -> "3"
        R.drawable._08 -> "20"
        R.drawable._09 -> "??"
        R.drawable._10 -> "0"
        else -> ""
    }

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        ComposeNavigation()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        ComposeNavigation()
    }
}
