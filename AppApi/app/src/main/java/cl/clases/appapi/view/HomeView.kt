package cl.clases.appapi.view



import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.clases.appapi.components.CardGame
import cl.clases.appapi.components.MainTopBar
import cl.clases.appapi.ui.theme.customBlack
import cl.clases.appapi.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton = {}) {

            }
        }
    ) {
        ContentHomeView(it, viewModel, navController)
    }

//    val games by viewModel.games.collectAsState()
//
//    LazyColumn {
//        items(games) { item ->
//            Text(text = item.name)
//
//            Log.d("TAG", item.name)
//
//        }
//    }

}

@Composable
fun ContentHomeView(
    paddingValues: PaddingValues,
    viewModel: GamesViewModel,
    navController: NavController
) {

    val games by viewModel.games.collectAsState()

    Column(
        modifier = Modifier
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .background(customBlack)
        ) {
            items(games) { item ->
                CardGame(item) {
                    navController.navigate("Detail/${item.id}")
                }
                Text(
                    text = item.name,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
        }
    }
}


