package cl.clases.appapi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.clases.appapi.ui.theme.customBlack
import cl.clases.appapi.viewModel.GamesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchGameView(
    viewModel: GamesViewModel,
    navController: NavController
) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val games by viewModel.games.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(customBlack)
    ) {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text(text = "Buscar...") },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    ""
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    "",
                    modifier = Modifier
                        .clickable{ navController.popBackStack() }
                )
            }
        ) {
            if (query.isNotEmpty()) {
                val filterGames = games.filter { it.name.contains(query, ignoreCase = true) }
                filterGames.forEach {
                    Text(
                        text = it.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 10.dp, start = 10.dp)
                            .clickable { navController.navigate("Detail/${it.id}/?${it.name}") }
                    )
                }
            }
        }
    }
}