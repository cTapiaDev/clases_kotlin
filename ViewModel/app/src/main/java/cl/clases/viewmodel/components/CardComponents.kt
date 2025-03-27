package cl.clases.viewmodel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainCard(
    title: String,
    number: Double,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = title, color = Color.Black, fontSize = 20.sp)
            Text(text = "$number", color = Color.Black, fontSize = 20.sp)
        }
    }
}

@Composable
fun ContentCards(
    title1: String,
    number1: Double,
    title2: String,
    number2: Double
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        MainCard(
            title = title1,
            number = number1,
            modifier = Modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(5.dp))
        MainCard(
            title = title2,
            number = number2,
            modifier = Modifier
                .weight(1f)
        )
    }
}