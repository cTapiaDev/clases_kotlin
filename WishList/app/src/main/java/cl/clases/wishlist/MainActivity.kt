package cl.clases.wishlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import cl.clases.wishlist.navigation.NavManager
import cl.clases.wishlist.ui.theme.WishListTheme
import cl.clases.wishlist.viewModel.WishViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel: WishViewModel by viewModels()
        setContent {
            WishListTheme {
                NavManager(viewModel)
            }
        }
    }
}