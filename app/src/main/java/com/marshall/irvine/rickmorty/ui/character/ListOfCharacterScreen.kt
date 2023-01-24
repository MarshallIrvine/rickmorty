package com.marshall.irvine.rickmorty.ui.character

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.marshall.irvine.rickmorty.R
import com.marshall.irvine.rickmorty.data.model.Character
import com.marshall.irvine.rickmorty.ui.theme.RickMortyTheme

@Composable
fun ListOfCharacterScreen(characters: List<Character>) {

        Surface{
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
               items(characters) {
                   character ->
                   ItemCharacterList(character = character)
               }
            }
        }
}

@Composable
fun ItemCharacterList(character: Character) {
    Surface(
        elevation = 1.dp, modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = character.image,
                contentDescription = stringResource(
                    id = R.string.app_name
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = character.name, maxLines = 4, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "${character.gender} - ${character.status}", style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Last known location:", style = MaterialTheme.typography.subtitle1)
                Text(text = character.location.name, style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "First seen in:", style = MaterialTheme.typography.subtitle1)
                Text(text = character.origin.name)
                Spacer(modifier = Modifier.height(5.dp))


            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListOfCharacterScreenPreview() {
    RickMortyTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            //ItemCharacterList()
        }
    }
}