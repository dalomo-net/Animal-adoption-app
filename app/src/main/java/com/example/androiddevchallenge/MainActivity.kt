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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.foundation.Image as Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                LazyColumn() {
                    item {
                        Image(painter = painterResource(id = R.drawable.header), contentDescription = "")
                    }
                    item {
                        Card(R.drawable._00, "Taro")
                    }
                    item {
                        Card(R.drawable._01, "Hanako")
                    }
                    item {
                        Card(R.drawable._02, "Goro")
                    }
                    item {
                        Card(R.drawable._03, "Yasu")
                    }
                    item {
                        Card(R.drawable._04, "Gonzo")
                    }
                    item {
                        Card(R.drawable._05, "Hina")
                    }
                    item {
                        Card(R.drawable._06, "Ken")
                    }
                    item {
                        Card(R.drawable._07, "Kan")
                    }
                    item {
                        Card(R.drawable._08, "Ichi")
                    }
                    item {
                        Card(R.drawable._09, "JF")
                    }
                    item {
                        Card(R.drawable._10, "Dolly")
                    }
                }
            }
        }
    }
}

@Composable
fun Card(rid: Int, name: String){
    val image = painterResource(id = rid)

    Column (
        Modifier
//            .clickable(onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center

    ) {
        val imageModifier = Modifier
            .wrapContentSize()
        Image(image, "", modifier = imageModifier, contentScale = ContentScale.Crop)
        Text(text = name, style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.End))

    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        LazyColumn() {
            item {
                Image(painter = painterResource(id = R.drawable.header), contentDescription = "")
            }
            item {
                Card(R.drawable._00, "Taro")
            }
            item {
                Card(R.drawable._01, "Hanako")
            }
            item {
                Card(R.drawable._02, "Goro")
            }
            item {
                Card(R.drawable._03, "Yasu")
            }
            item {
                Card(R.drawable._04, "Gonzo")
            }
            item {
                Card(R.drawable._05, "Hina")
            }
            item {
                Card(R.drawable._06, "Ken")
            }
            item {
                Card(R.drawable._07, "Tomo")
            }
            item {
                Card(R.drawable._08, "Ichi")
            }
            item {
                Card(R.drawable._09, "JF")
            }
            item {
                Card(R.drawable._10, "Dolly")
            }
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme {
        LazyColumn() {
            item {
                Image(painter = painterResource(id = R.drawable.header), contentDescription = "")
            }
            item {
                Card(R.drawable._00, "Taro")
            }
            item {
                Card(R.drawable._01, "Hanako")
            }
            item {
                Card(R.drawable._02, "Goro")
            }
            item {
                Card(R.drawable._03, "Yasu")
            }
            item {
                Card(R.drawable._04, "Gonzo")
            }
            item {
                Card(R.drawable._05, "Hina")
            }
            item {
                Card(R.drawable._06, "Ken")
            }
            item {
                Card(R.drawable._07, "Tomo")
            }
            item {
                Card(R.drawable._08, "Ichi")
            }
            item {
                Card(R.drawable._09, "JF")
            }
            item {
                Card(R.drawable._10, "Dolly")
            }
        }
    }
}
