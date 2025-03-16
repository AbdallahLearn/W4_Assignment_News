package com.example.w4_assignment_news

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.util.Locale
import kotlin.random.Random


// Define Dark Color Scheme
val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

// Define Light Color Scheme
val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

// Define Custom Typography
val AppTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentLanguage = remember { mutableStateOf("en") } // Default to English

            MaterialTheme(
                colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme,
                typography = AppTypography
            ) {
                NewsApp(currentLanguage)
            }
        }
    }
}



@Composable
fun NewsHeader(currentLanguage: MutableState<String>) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(50.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = stringResource(R.string.app_name), // Use localized string
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
fun MainNewsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Use surface color from the theme
        )
    ) {
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https://www.aljazeera.com/wp-content/uploads/2023/06/This-week-in-the-middle-east42_outisde-image-1500-x1000-1686838868.jpg?resize=770%2C513&quality=80",
                contentDescription = "News Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Breaking News: Major Event Happening Now!",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface // Use onSurface color for text
                )
            }
        }
    }
}





@Composable
fun NewsApp(currentLanguage: MutableState<String>) {

    val isDarkTheme = remember { mutableStateOf(false) }

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


    // Get context for Intent
    val context = LocalContext.current

    // Apply MaterialTheme with custom color scheme and typography
    MaterialTheme(
        colorScheme = if (isDarkTheme.value) DarkColorScheme else LightColorScheme,
        typography = AppTypography
    ) {
        Scaffold(
            topBar = {
                Column {
                    // Add the theme toggle switch in the header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.app_name), // Use localized string
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Switch(
                            checked = isDarkTheme.value,
                            onCheckedChange = { isDarkTheme.value = it },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                    NewsHeader(currentLanguage) // Pass currentLanguage to NewsHeader
                }
            },
            bottomBar = { NavbarBottom() } // Fixed bottom navigation bar
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Respect system padding
            ) {
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
                                putExtra("isDarkTheme", isDarkTheme.value) // Pass the theme state
                            }
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun NewsRow(news: NewsItem, onClick: (NewsItem) -> Unit) {
    val layoutDirection = LocalLayoutDirection.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(news) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = if (layoutDirection == LayoutDirection.Rtl) Arrangement.End else Arrangement.Start, // Adjust arrangement for RTL
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Text Column
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = news.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = news.shortDescription,
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = stringResource(R.string.date), // Use localized string
                        modifier = Modifier.size(12.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = news.date,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = stringResource(R.string.likes), // Use localized string
                        modifier = Modifier.size(12.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = news.like,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Load Image (Now on the Right)
            AsyncImage(
                model = news.imageUrl,
                contentDescription = "News Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun LanguageToggle(currentLanguage: MutableState<String>) {
    val context = LocalContext.current
    val resources = context.resources
    val configuration = Configuration(resources.configuration)

    Button(onClick = {
        currentLanguage.value = if (currentLanguage.value == "en") "ar" else "en"
        configuration.setLocale(Locale(currentLanguage.value))
        context.createConfigurationContext(configuration)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }) {
        Text(text = if (currentLanguage.value == "en") "عربي" else "English")
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
