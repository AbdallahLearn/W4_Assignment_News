package com.example.w4_assignment_news

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp()
        }
    }
}




@Composable
fun NewsHeader(){
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.LightGray , RoundedCornerShape(50.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            modifier = Modifier.size(32.dp)
        )
        Text(
            text="News App",
            fontSize = 22.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun NavbarBottom(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier.size(30.dp)
            )
            Text("Home")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Category,
                contentDescription = "Category",
                modifier = Modifier.size(30.dp)
            )
            Text("Category")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Videocam,
                contentDescription = "Video",
                modifier = Modifier.size(30.dp)
            )
            Text("Video")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                modifier = Modifier.size(30.dp)
            )
            Text("Favorite")
        }
    }

}

@Composable
fun MainNewsCard(){
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(300.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White) // Set background to white

    ){
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = "https://www.aljazeera.com/wp-content/uploads/2023/06/This-week-in-the-middle-east42_outisde-image-1500-x1000-1686838868.jpg?resize=770%2C513&quality=80",
                contentDescription = "News Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),


                )
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "Breaking News: Major Event Happening Now!", fontSize = 18.sp,)

            }

        }

    }
}






@Composable
fun NewsApp() {



    val newsItems = listOf(
        NewsItem(
            title = "Sports Update",
            date = "April 09, 2012",
            fullDescription = """
            Latest football match results and analysis.Team A secured a thrilling victory over Team B with a last-minute goal.
            The match was intense, with both teams displaying exceptional skills. Player X was the standout performer, scoring two incredible goals.
            The referee made some controversial decisions, sparking heated debates. Fans were on the edge of their seats throughout the game. The defensive strategies of both teams were put to the test.
            Midfielders played a crucial role in maintaining possession. The coach of Team A praised his players for their resilience.
            Team B’s coach acknowledged the mistakes that led to the loss. The stadium was packed with enthusiastic supporters.
            Post-match interviews revealed the emotions of the players.Analysts discussed key moments that changed the game.  The victory boosts Team A’s position in the league standings.
            The defeat was a setback for Team B’s championship hopes.A controversial penalty decision added to the drama.
            Goalkeeper Y made some spectacular saves throughout the match. The rivalry between these two teams made the match even more exciting.
            Social media exploded with reactions and highlights. Fans are already looking forward to the next encounter between these teams.
            Experts predict that these teams will meet again in the finals.
        """.trimIndent(),

            imageUrl = "https://www.arabnews.com/sites/default/files/styles/n_670_395/public/2024/08/31/4519452-1455184273.jpg?itok=hwkGyP80"
        ),
        NewsItem(
            title = "Space Exploration",
            date = "June 09, 2022",
            fullDescription = """
            NASA discovers a new exoplanet in the Milky Way. Scientists are excited about the potential for life on this newly found celestial body.
            Astronomers used advanced telescopes to identify the planet's atmosphere and chemical composition.
            The exoplanet orbits within the habitable zone, raising hopes for future exploration.
            NASA researchers believe this discovery could provide insight into planetary formation and space evolution.
            The discovery was made using the James Webb Space Telescope, which provided detailed imaging.
            Experts highlight the significance of this exoplanet in the search for extraterrestrial life.
            Scientists are now planning further studies to determine if the planet has water sources.
            The international space community is eager to collaborate on deeper investigations.
            Space enthusiasts worldwide have celebrated the breakthrough discovery.
            More data will be gathered in upcoming missions to confirm the exoplanet's key characteristics.
        """.trimIndent(),

                    imageUrl = "https://blog.gale.com/wp-content/uploads/2024/07/iStock-1693812103.jpg"
        ),
        NewsItem(
            title = "Global Markets",
            date = "June 09, 2022",
            fullDescription = """
            NASA discovers a new exoplanet in the Milky Way. Scientists are excited about the potential for life on this newly found celestial body.
            Astronomers used advanced telescopes to identify the planet's atmosphere and chemical composition.
            The exoplanet orbits within the habitable zone, raising hopes for future exploration.
            NASA researchers believe this discovery could provide insight into planetary formation and space evolution.
            The discovery was made using the James Webb Space Telescope, which provided detailed imaging.
            Experts highlight the significance of this exoplanet in the search for extraterrestrial life.
            Scientists are now planning further studies to determine if the planet has water sources.
            The international space community is eager to collaborate on deeper investigations.
            Space enthusiasts worldwide have celebrated the breakthrough discovery.
            More data will be gathered in upcoming missions to confirm the exoplanet's key characteristics.
        """.trimIndent(),
            imageUrl = "https://cdn-res.keymedia.com/investmentnews/uploads/2024/07/digital-data-financial-investment-and-trading-graph-chart.jpg_s1024x1024wisk20cSMSYHuqZPIUe-1__Cr686IXWB_zkxEXYuH0irhLpYmE-1.jpg"
        ),
        NewsItem(
            title = "Health Breakthrough",
            date = "June 09, 2022",
            fullDescription = """
            Scientists develop a new vaccine for rare diseases. Medical researchers achieve a breakthrough in combating previously untreatable conditions.
            The vaccine has shown promising results in clinical trials, offering hope to patients worldwide.
            Leading pharmaceutical companies collaborated to develop this cutting-edge treatment.
            The breakthrough is expected to pave the way for further medical advancements.
            Healthcare professionals emphasize the importance of early distribution.
            Governments are working to expedite approval processes for faster availability.
            Experts believe this innovation will revolutionize how rare diseases are treated.
            The vaccine is designed to boost the immune system without severe side effects.
            Global health organizations have praised the research team for their dedication.
            Scientists are optimistic about adapting this technology to other medical challenges.
        """.trimIndent(),
            imageUrl = "https://bepartofresearch.nihr.ac.uk/dA/732d5bab53/Health%20breakthroughs.jpg"
        ),
        NewsItem(
            title = "Climate Change",
            date = "June 09, 2022",
            fullDescription = """
            Rising sea levels threaten coastal cities. Scientists warn that climate change is accelerating oceanic expansion.
            Major coastal areas face increased risks of flooding and property damage.
            Experts call for urgent action to implement sustainable solutions.
            Environmental groups advocate for stricter carbon emission regulations.
            Urban planners are designing infrastructure to mitigate future risks.
            Some cities have already experienced significant changes due to rising waters.
            Governments are investing in flood barriers and improved drainage systems.
            Research indicates that sea levels could rise faster than previously expected.
            Marine ecosystems are also being affected, impacting fisheries and biodiversity.
            Scientists stress the need for global cooperation to address climate change.
        """.trimIndent(),
            imageUrl = "https://myanmarwaterportal.com/storage/2021/11/Climate-Change-Impacts-on-Water_Related-Sectors.png"
        ),
        NewsItem(
            title = "AI in Healthcare",
            date = "June 09, 2022",
            fullDescription = """
            Scientists develop a new vaccine for rare diseases. Medical researchers achieve a breakthrough in combating previously untreatable conditions.
            The vaccine has shown promising results in clinical trials, offering hope to patients worldwide.
            Leading pharmaceutical companies collaborated to develop this cutting-edge treatment.
            The breakthrough is expected to pave the way for further medical advancements.
            Healthcare professionals emphasize the importance of early distribution.
            Governments are working to expedite approval processes for faster availability.
            Experts believe this innovation will revolutionize how rare diseases are treated.
            The vaccine is designed to boost the immune system without severe side effects.
            Global health organizations have praised the research team for their dedication.
            Scientists are optimistic about adapting this technology to other medical challenges.
        """.trimIndent(),
            imageUrl = "https://tateeda.com/wp-content/uploads/2024/01/How_to_Integrate_AI_in_Healthcare_Solutions_Examples__Services-3.jpg"
        ),
        NewsItem(
            title = "Electric Cars",
            date = "June 09, 2022",
            fullDescription = """
            Scientists develop a new vaccine for rare diseases. Medical researchers achieve a breakthrough in combating previously untreatable conditions.
            The vaccine has shown promising results in clinical trials, offering hope to patients worldwide.
            Leading pharmaceutical companies collaborated to develop this cutting-edge treatment.
            The breakthrough is expected to pave the way for further medical advancements.
            Healthcare professionals emphasize the importance of early distribution.
            Governments are working to expedite approval processes for faster availability.
            Experts believe this innovation will revolutionize how rare diseases are treated.
            The vaccine is designed to boost the immune system without severe side effects.
            Global health organizations have praised the research team for their dedication.
            Scientists are optimistic about adapting this technology to other medical challenges.
        """.trimIndent(),
            imageUrl = "https://themedialine.org/wp-content/uploads/2023/11/GettyImages-1719491203-scaled-e1698839235478.jpg"
        ),
        NewsItem(
            title = "Education Reform",
            date = "June 09, 2022",
            fullDescription = """
            Scientists develop a new vaccine for rare diseases. Medical researchers achieve a breakthrough in combating previously untreatable conditions.
            The vaccine has shown promising results in clinical trials, offering hope to patients worldwide.
            Leading pharmaceutical companies collaborated to develop this cutting-edge treatment.
            The breakthrough is expected to pave the way for further medical advancements.
            Healthcare professionals emphasize the importance of early distribution.
            Governments are working to expedite approval processes for faster availability.
            Experts believe this innovation will revolutionize how rare diseases are treated.
            The vaccine is designed to boost the immune system without severe side effects.
            Global health organizations have praised the research team for their dedication.
            Scientists are optimistic about adapting this technology to other medical challenges.
        """.trimIndent(),
            imageUrl = "https://images.unsplash.com/photo-1571260899304-425eee4c7efc"
        )
    )


    val context = LocalContext.current  // Get context for Intent

    Scaffold(
        bottomBar = { NavbarBottom() } // Fixed bottom navigation bar
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Respect system padding
        ) {
            NewsHeader()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { MainNewsCard() }
                item { Spacer(modifier = Modifier.height(16.dp)) }
                items(newsItems) { news ->
                    NewsRow(news) { selectedNews ->
                        val intent = Intent(context, DetailsActivity::class.java).apply {
                            putExtra("title", selectedNews.title)
                            putExtra("date", selectedNews.date)
                            putExtra("like_count", selectedNews.like)
                            putExtra("description", selectedNews.fullDescription)
                            putExtra("imageUrl", selectedNews.imageUrl)
                        }
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}


@Composable
fun NewsRow(news: NewsItem, onClick: (NewsItem) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(news) },
        colors = CardDefaults.cardColors(containerColor = Color.White) // Set background to white

    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Ensures spacing
            verticalAlignment = Alignment.CenterVertically // Aligns items properly
        ) {
            // Text Column
            Column(
                modifier = Modifier.weight(1f) // Takes remaining space
            ) {
                Text(text = news.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = news.shortDescription, // Show only 2 lines
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date",
                        modifier = Modifier.size(12.dp)


                    )
                    Text(
                        text = news.date,
                        fontSize = 12.sp,
                        )

                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Like",
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text= news.like,
                        fontSize = 12.sp
                    )
                }

            }

            Spacer(modifier = Modifier.width(12.dp))

            // Load Image (Now on the Right)
            AsyncImage(
                model = news.imageUrl,
                contentDescription = "News Image",
                modifier = Modifier
                    .size(100.dp) // Adjust image size
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray), // Placeholder background
                contentScale = ContentScale.Crop
            )
        }
    }
}




data class NewsItem(
    val title: String,
    val date: String,
    val like: String = Random.nextInt(1, 100).toString(),
    val fullDescription: String,
    val imageUrl: String
) {
    val shortDescription: String
        get() = fullDescription.split("\n").take(2).joinToString("\n") // Show only 2 lines
}
