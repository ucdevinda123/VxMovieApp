
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spore.vxmoviesapp.R
import com.spore.vxmoviesapp.ui.viewmodel.SearchViewModel
import com.spore.vxmoviesapp.util.isNetworkAvailable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchBar(
    autoFocus: Boolean,
    viewModel: SearchViewModel = hiltViewModel(),
    onSearch: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(start = 2.dp, end = 2.dp, bottom = 8.dp)
            .clip(RectangleShape)
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(54.dp),
    ) {
        val context = LocalContext.current
        TextField(
            value = viewModel.searchQueryState.value,
            onValueChange = {
                if (isNetworkAvailable(context)) {
                    viewModel.search(it)
                }
            },
            modifier = Modifier
                .fillMaxSize(),
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint),
                    color = Color.White.copy(alpha = 0.8F),
                )
            },
            colors = textFieldColors(
                textColor = Color.White.copy(alpha = 0.78F),
                backgroundColor = Color.Transparent,
                disabledTextColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    if (isNetworkAvailable(context)) {
                        viewModel.search(viewModel.searchQueryState.value)
                    }
                },
            ),
            trailingIcon = {
                Row {
                    IconButton(onClick = {
                        onSearch()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search",
                            tint = Color.White,
                        )
                    }
                }
            },
        )
    }
}
