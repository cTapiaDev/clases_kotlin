package cl.clases.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import cl.clases.viewmodel.ui.theme.ViewModelTheme
import cl.clases.viewmodel.view.HomeView2
import cl.clases.viewmodel.view.HomeView3
import cl.clases.viewmodel.viewModels.CalcularViewModel2
import cl.clases.viewmodel.viewModels.CalcularViewModel3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //val viewModel: CalcularViewModel by viewModels()
        //val viewModel2: CalcularViewModel2 by viewModels()
        val viewModel3: CalcularViewModel3 by viewModels()
        setContent {
            ViewModelTheme {
                //HomeView(viewModel)
                //HomeView2(viewModel2)
                HomeView3(viewModel3)
            }
        }
    }
}