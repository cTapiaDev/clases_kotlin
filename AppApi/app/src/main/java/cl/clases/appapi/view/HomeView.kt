package cl.clases.appapi.view



import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import cl.clases.appapi.components.CardGame
import cl.clases.appapi.components.Loader
import cl.clases.appapi.components.MainTopBar
import cl.clases.appapi.ui.theme.customBlack
import cl.clases.appapi.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton = {}) {
                navController.navigate("SearchGameView")
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
    var search by remember { mutableStateOf("") }
    val gamesPage = viewModel.gamesPage.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = search,
            onValueChange = { search = it },
            label = { Text(text = "Buscar") },
            keyboardOptions = KeyboardOptions.Default.copy (
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    val zero = 0
                    navController.navigate("Detail/${zero}/?${search}")
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )


        LazyColumn(
            modifier = Modifier
                .background(customBlack)
        ) {
            items(gamesPage.itemCount) { index ->
                val item = gamesPage[index]

                if (item != null) {
                    CardGame(item) {
                        navController.navigate("Detail/${item.id}/?${search}")
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
            when (gamesPage.loadState.append) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Loader()
                        }
                    }
                }
                is LoadState.Error -> {
                    item {
                        Text(text = "Error al cargar los datos")
                    }
                }
            }
        }
    }
}


