package com.example.edutrack.app.contact.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.edutrack.app.about.presentation.TeamMember
import com.example.edutrack.app.components.AppHeader

@Composable
fun ContactScreen(openDrawer: () -> Unit, modifier: Modifier = Modifier) {
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
                }, title = "Contact Us")
            }
            item {
                ContactsCard()
            }
            item {
                SocialCards()
            }
        }
    }
}

@Composable
fun Contact(img: String, desc: String, info: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = info,
            contentDescription = desc,
            modifier = Modifier.size(60.dp).clip(RoundedCornerShape(10.dp))
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                img,
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
        }
    }
}

@Composable
fun ContactsCard(modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxWidth().padding(10.dp).heightIn(min = 200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                "Contact Channels",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.size(10.dp))
            Contact("Email", "support@rickmwas.com", "https://img.icons8.com/clouds/100/new-post.png")
            Contact("Phone", "+254115676847", "https://img.icons8.com/clouds/100/apple-phone.png")
        }
    }
}

@Composable
fun SocialCards(modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxWidth().padding(10.dp).heightIn(min = 200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                "Contact Channels",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.size(10.dp))
            Contact("TikTok", "@dummytik", "https://img.icons8.com/bubbles/50/tiktok.png")
            Contact("Instagram", "@dummyIG", "https://img.icons8.com/bubbles/50/instagram-new--v2.png")
            Contact("Whatsapp", "+254115676847", "https://img.icons8.com/bubbles/50/whatsapp.png")
            Contact("Facebook", "@dummyFB", "https://img.icons8.com/bubbles/50/facebook.png")
        }
    }
}