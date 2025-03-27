package cl.clases.viewmodel.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.clases.viewmodel.components.Alert
import cl.clases.viewmodel.components.ContentCards
import cl.clases.viewmodel.components.MainButton
import cl.clases.viewmodel.components.MainTextField
import cl.clases.viewmodel.components.Space
import cl.clases.viewmodel.viewModels.CalcularViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: CalcularViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "App Descuentos", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView(it, viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalcularViewModel) {

    var precio by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }
    var totalPrecio by remember { mutableStateOf(0.0) }
    var totalDescuento by remember { mutableStateOf(0.0) }
    var showAlert by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContentCards(
            title1 = "Descuento", number1 = totalPrecio,
            title2 = "Total", number2 = totalDescuento
        )
        MainTextField(
            value = precio,
            onValueChange = { precio = it },
            label = "Precio"
        )
        Space()
        MainTextField(
            value = descuento,
            onValueChange = { descuento = it },
            label = "Descuento %"
        )
        MainButton("Generar Descuento") {
            val result = viewModel.calcular(precio, descuento)
            showAlert = result.second.second

            if (!showAlert) {
                totalPrecio = result.first
                totalDescuento = result.second.first
            }
        }

        if (showAlert) {
            Alert(
                title = "Alerta",
                msj = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = { showAlert = false }
            ) { }
        }
    }
}