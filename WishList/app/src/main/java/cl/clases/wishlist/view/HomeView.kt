package cl.clases.wishlist.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.clases.wishlist.R
import cl.clases.wishlist.components.AppBarView
import cl.clases.wishlist.components.WishItem
import cl.clases.wishlist.navigation.Screen
import cl.clases.wishlist.viewModel.WishViewModel

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    Scaffold(
        topBar = { AppBarView("WishList") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddScreen.route + "/0L")
                },
                modifier = Modifier
                    .padding(20.dp),
                contentColor = Color.White,
                containerColor = colorResource(R.color.teal_700)
            ) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) {

        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishList.value) { wish ->
                WishItem(wish) {
                    val id = wish.id
                    navController.navigate(Screen.AddScreen.route + "/$id")
                }
            }
        }
    }
}
