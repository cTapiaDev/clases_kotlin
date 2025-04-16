package cl.clases.appapi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.clases.appapi.components.MainImage
import cl.clases.appapi.components.MainTopBar
import cl.clases.appapi.components.MetaWebsite
import cl.clases.appapi.components.ReviewCard
import cl.clases.appapi.ui.theme.customBlack
import cl.clases.appapi.viewModel.GamesViewModel

@Composable
fun DetailView(
    viewModel: GamesViewModel,
    navController: NavController,
    id: Int
) {

    LaunchedEffect(Unit) {
        viewModel.getGameById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clean()
        }
    }


    Scaffold(
        topBar = {
            MainTopBar(title = viewModel.state.name, showBackButton = true, onClickBackButton = {
                navController.popBackStack()
            }) { }
        }
    ) {
        ContentDetailView(it, viewModel)
    }
}

@Composable
fun ContentDetailView(
    paddingValues: PaddingValues,
    viewModel: GamesViewModel
) {
    val state = viewModel.state
    val scroll = rememberScrollState(0)

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(customBlack)
    ) {
        MainImage(image = state.background_image_additional)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 5.dp)
        ) {
            MetaWebsite(state.website)
            ReviewCard(state.metacritic)
        }
        Text(
            text = state.description_raw,
            color = Color.White,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(15.dp, 0.dp, 15.dp, 10.dp)
                .verticalScroll(scroll)
        )
    }
}