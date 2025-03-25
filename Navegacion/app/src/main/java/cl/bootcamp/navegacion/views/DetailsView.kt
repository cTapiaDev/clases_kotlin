package cl.bootcamp.navegacion.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.navegacion.components.MainButton
import cl.bootcamp.navegacion.components.Space
import cl.bootcamp.navegacion.components.TitleBar
import cl.bootcamp.navegacion.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView(
    navController: NavController,
    id: Int,
    nombre: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Details View") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red
                )
            )
        }
    ) {
        ContentDetailsView(it, navController, id, nombre)
    }
}

@Composable
fun ContentDetailsView(
    paddingValues: PaddingValues,
    navController: NavController,
    id: Int,
    nombre: String
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("Details")
        Space()
        TitleView(name = id.toString())
        Space()
        if (nombre != "") {
            TitleView(nombre)
            Space()
        } else {
            Spacer(modifier = Modifier.height(0.dp))
        }
        MainButton("Home View", color = Color.White) {
            navController.popBackStack()
        }
    }
}