package com.example.edutrack.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.edutrack.R

// App Header
@Composable
fun AppHeader(openDrawer: () -> Unit, title: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { openDrawer() },
            modifier = Modifier.size(38.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.menu),
                contentDescription = "Open Navigation Drawer",
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(title, style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        ))
        AsyncImage(
            model = "https://i.pravatar.cc/300",
            contentDescription = null,
            modifier = Modifier.size(38.dp).clip(CircleShape)
        )
    }
}