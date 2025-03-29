package cl.clases.wishlist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material.Scaffold
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.clases.wishlist.R
import cl.clases.wishlist.components.AppBarView
import cl.clases.wishlist.components.Space
import cl.clases.wishlist.components.WishTextField
import cl.clases.wishlist.viewModel.WishViewModel

@Composable
fun AddDetailView(
    id: Long,
    navController: NavController,
    viewModel: WishViewModel
) {

    Scaffold(
        topBar = { AppBarView(
            if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)
        ) { navController.navigateUp() } }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Space()
            WishTextField(
                label = "Title",
                value = "",
                onValueChange = {}
            )
            Space()
            WishTextField(
                label = "Description",
                value = "",
                onValueChange = {}
            )
            Space()
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = if (id != 0L) stringResource(R.string.update_wish)
                    else stringResource(R.string.add_wish),
                    fontSize = 18.sp,
                )
            }
        }
    }

}
