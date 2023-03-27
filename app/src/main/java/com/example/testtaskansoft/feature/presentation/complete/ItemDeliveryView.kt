package com.example.testtaskansoft.feature.presentation.complete

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.testtaskansoft.feature.domain.model.Delivery

@Composable
fun ItemDeliveryCard(delivery: Delivery) {
    Row {
        Column {
            Text(text = "Adress")
            Text(text = delivery.address)
            Text(text = "Phone Number")
            Text(text = delivery.phone)
        }
        Column {
            Text(text = "Date delivery")
            Text(text = delivery.planTime)
        }
        Column {
            Button(onClick = {}) {
                Text(text = "Delivery")
            }
        }
    }
}
/*
@Preview
@Composable
fun PreviewMessageCard() {
    ItemDeliveryCard(Delivery("Ивановского 6",6,"","","+7-999-999-99-99","Завтоа",false))
}*/
