package com.example.runningproject.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.runningproject.model.MovieData
import com.example.runningproject.network.data.MainViewModel
import com.example.runningproject.util.Resource

@Composable
fun EachRow(movieData: MovieData) {
    val checkedState = remember { mutableStateOf(false) }



    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)))
    {
        Row {
            Image(painter = rememberImagePainter(data = movieData.imageUrl),
                contentDescription = "Posters",modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .weight(2f))
            Text(text = movieData.desc, modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically)
                .weight(5f))

            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            )
        }
    }
}
@Composable
fun GETData(mainViewModel: MainViewModel){
    when(val result = mainViewModel.response.value){
        is Resource.Success->{
            LazyColumn{
                items(result.data){ response->
                    EachRow( response)
                }
            }
        }
        is Resource.Failure->{
            Text(text = "${result.msg}")
        }
        Resource.Loading->{
            CircularProgressIndicator()
        }
        Resource.Empty->{

        }
    }
}
