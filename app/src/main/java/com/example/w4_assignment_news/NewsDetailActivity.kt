package com.example.w4_assignment_news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlin.math.max

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("title") ?: ""
        val date = intent.getStringExtra("date") ?: ""
        val likeCount = intent.getStringExtra("like_count") ?: "0" // Default to "0" if null
        val description = intent.getStringExtra("description") ?: ""
        val imageUrl = intent.getStringExtra("imageUrl") ?: ""

        setContent {
            NewsDetailsScreen(
                title = title,
                date = date,
                likeCount = likeCount,
                description = description,
                imageUrl = imageUrl,
                onBackClick = { finish() } // Closes this activity and goes back
            )
        }
    }
}

@Composable
fun NewsDetailsScreen(title: String, date:String, likeCount:String ,description: String, imageUrl: String, onBackClick: () -> Unit) {
    var isFavorite by remember { mutableStateOf(false) }

    val firstTwoWords = title.split(" ").take(3).joinToString(" ")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Enables scrolling
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

                ){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { onBackClick() }, // Handle back navigation
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = firstTwoWords, fontSize = 22.sp, fontWeight = FontWeight.Bold)

            }
          Row(){
              Icon(
                  imageVector = Icons.Default.Create,
                  contentDescription = "Create",
                  modifier = Modifier.size(30.dp)
              )

                Spacer(modifier = Modifier.width(10.dp))
              Icon(
                  imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder, //I did not find BookMark! so I used Favorite
                  contentDescription = "Favorite",
                  modifier = Modifier
                      .size(30.dp)
                      .clickable { isFavorite = !isFavorite },
                  tint = if (isFavorite) Color.Red else Color.Gray
              )
          }

        }

        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold

            )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Date Section
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date",
                    modifier = Modifier.size(14.dp) // Slightly larger for visibility
                )
                Spacer(modifier = Modifier.width(4.dp)) // Adds spacing between icon and text
                Text(
                    text = date,
                    fontSize = 12.sp
                )
            }

            // Likes Section
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Like",
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp)) // Adds spacing between icon and text
                Text(
                    text = likeCount,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Like",
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp)) // Adds spacing between icon and text
                Text(
                    text = max(0, (likeCount.toInt() - 19)).toString() ,//Share count from me (: //I did not find comments icon so I make it share icon
                    fontSize = 12.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(12.dp))
        Column {
            Text(
                text = description,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify

            )
        }

    }
}
