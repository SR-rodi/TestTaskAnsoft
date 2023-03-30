package com.example.testtaskansoft.feature.presentation.complete

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testtaskansoft.feature.domain.model.Delivery

@ExperimentalMaterial3Api
@Composable
fun ItemDeliveryCard(item:Delivery) {
    Card(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp)
    ) {
        Box {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    TextFromCard(title = "Adres", subtitle = item.address)
                    TextFromCard(title = "Phone Number", subtitle = item.phone)
                }
                Column(
                    Modifier.align(Alignment.CenterVertically).weight(1f)
                ) {
                    TextFromCard(title = "Date delivery", subtitle = item.planTime)
                }
            }
            Button(
                modifier = Modifier.align(Alignment.BottomEnd),
                shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Доставить")
            }
        }
    }
}

@Composable
fun TextFromCard(title: String, subtitle: String) {
    Text(text = title,color = Color(0xFF3E0E8A))
    Text(
        text = subtitle,color = Color(0xFF000000),
        modifier = Modifier.padding(bottom = 9.dp))
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewMessageCard() {
    ItemDeliveryCard(Delivery("Ивановского 6",6,"","","+7-999-999-99-99","Завтоа",false))
}
