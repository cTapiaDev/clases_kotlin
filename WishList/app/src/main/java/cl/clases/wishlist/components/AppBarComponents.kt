package cl.clases.wishlist.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import cl.clases.wishlist.R

@Composable
fun AppBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon: (@Composable () -> Unit) ? =
        if (!title.contains("WishList")) {
            {
                IconButton(
                    onClick = { onBackNavClicked() }
                ) {
                    Icon(
                       imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }
        } else {
            null
        }


    TopAppBar(
        title = { Text(
            text = title,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(start = 4.dp)
                .heightIn(max = 24.dp)
        ) },
        elevation = 3.dp,
        backgroundColor = colorResource(R.color.teal_700),
        navigationIcon = navigationIcon
    )

}