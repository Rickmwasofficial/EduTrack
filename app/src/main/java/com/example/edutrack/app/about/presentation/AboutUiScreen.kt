package com.example.edutrack.app.about.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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

@Composable
fun AboutScreen(openDrawer: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                AppHeader(openDrawer = {
                    openDrawer()
                }, title = "About")
            }
            item {
                AboutCards(
                    "Our Mission",
                    "Our mission is to empower students by providing a seamless and intuitive platform to manage their academic journey. We believe in leveraging technology to make education more accessible, organized, and engaging for everyone."
                )
            }
            item {
                AboutCards(
                    "Our Vision",
                    "We envision a world where every student has the tools and resources they need to succeed. Our goal is to be the leading companion app for students, constantly innovating to meet the evolving needs of the modern learner."
                )
            }
            item {
                TeamCard()
            }
        }
    }
}

@Composable
fun AboutCards(title: String, desc: String, modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxWidth().padding(10.dp).height(200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                desc,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun TeamMember(name: String, role: String, img: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = img,
            contentDescription = name,
            modifier = Modifier.size(60.dp).clip(RoundedCornerShape(10.dp))
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                role,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun TeamCard(modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxWidth().padding(10.dp).heightIn(min = 200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                "Meet the team",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.size(10.dp))
            TeamMember("Erick Mwangi", "Android Developer", "https://i.pravatar.cc/300")
            TeamMember("Erick Mwangi", "Android Developer", "https://i.pravatar.cc/300")
            TeamMember("Erick Mwangi", "Android Developer", "https://i.pravatar.cc/300")
            TeamMember("Erick Mwangi", "Android Developer", "https://i.pravatar.cc/300")
            TeamMember("Erick Mwangi", "Android Developer", "https://i.pravatar.cc/300")
        }
    }
}