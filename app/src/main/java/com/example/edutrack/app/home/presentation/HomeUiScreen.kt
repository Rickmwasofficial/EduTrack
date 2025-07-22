package com.example.edutrack.app.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.edutrack.app.components.AppHeader
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(openDrawer: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                AppHeader(openDrawer = {
                    openDrawer()
                }, title = "Home")
            }
            item {
                Text(
                    "Hi Rickmwasofficial!",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Spacer(Modifier.height(5.dp))
            }
            item {
                TopDetails(
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
            item {
                Updates()
            }
            item {
                Text(
                    "Assignments (5)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
            item {
                Assignments()
            }
        }
    }
}

@Composable
fun DetailsCard(title: String, percentage: Float, action: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(210.dp)
            .width(180.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Box(
                modifier = Modifier.size(80.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    { percentage },
                    modifier = Modifier.fillMaxSize().align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
                Text(
                    "${(percentage * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Button(
                onClick = {  }
            ) {
                Text(
                    action,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Composable
fun TopDetails(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(10) {
            item {
                DetailsCard(
                    "Attendance",
                    0.8F,
                    "View Attendance"
                )
            }
        }
    }
}

@Composable
fun UpdateCard(title: String, img: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.size(110.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = img,
                contentDescription = title,
                modifier = Modifier.size(60.dp).clip(RoundedCornerShape(10.dp))
            )
            Text(
                title,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun Updates(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            "School Updates",
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(10) {
                item {
                    UpdateCard(
                        "News",
                        "https://img.icons8.com/bubbles/100/news.png"
                    )
                }
            }
        }
    }
}

@Composable
fun AssignmentCard(
    title: String, img: String, desc: String, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth().height(75.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = img,
                contentDescription = title,
                modifier = Modifier.size(60.dp).clip(RoundedCornerShape(10.dp))
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Text(
                    title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    desc,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Download pdf",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Blue
                    )
                )
            }
        }
    }
}

@Composable
fun Assignments(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth().height(420.dp).wrapContentHeight().padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(5) {
            item {
                AssignmentCard(
                    "Theoretical Physics",
                    "https://img.icons8.com/3d-fluency/94/physics.png",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                )
            }
        }
    }

}