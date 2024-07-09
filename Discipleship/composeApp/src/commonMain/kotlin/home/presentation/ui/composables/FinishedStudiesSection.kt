package home.presentation.ui.composables

import home.domain.model.Tool
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home.presentation.ui.disciple_home.finishedList
import home.presentation.viewmodel.completedList
import home.presentation.viewmodel.discipleToolsList
import home.presentation.viewmodel.toDoList
import ui.theme.errorLight
import ui.theme.primaryLight

//val iconSize = 30.dp
@Composable
fun FinishedStudiesSection() {
    SectionTitle("Completed tools")
    LazyRow {
        items(completedList.size) { index ->
            FinishedStudyCard(index)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun FinishedStudyCard(index: Int) {
    val cardHeight = 140.dp
    val completedListRemember = remember { completedList }
    val tName = completedListRemember[index].name
    Card(
        modifier = Modifier
            .width(240.dp)
            .height(cardHeight)
            .padding(start = 16.dp, end = 8.dp, bottom = 16.dp),
        elevation = 12.dp,
        backgroundColor = Color.White
    ) {
        Column(
        ) {

            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 36.dp ),
                text = tName, // replace with dynamic loading
                fontSize = 20.sp,
                color = primaryLight,
                fontWeight = FontWeight.SemiBold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
                    .background(Color.LightGray.copy(alpha = .2f))
                    .weight(1f)
            ) {
                // notify user on clicking trash icon with dialog on whether they really want to delete the card
                ButtonBox(Icons.Default.Delete, "Trash Icon", Color.Black, onClick = {
                    discipleToolsList.add(completedListRemember.removeAt(index))
                })
                VerticalDivider(thickness = 2.dp, color = primaryLight, modifier = Modifier.padding(2.dp))
                // change to unfilled on unlike (we also want a list of favorite tools eventually)
                ButtonBox(Icons.Default.Favorite, "Favorite icon", Color.Red.copy(alpha = .5f)) {  }
                VerticalDivider(thickness = 2.dp, color = primaryLight, modifier = Modifier.padding(2.dp))
                // implement onClick functionality to return back to toDoList:
                ButtonBox(Icons.Default.Close, "X icon", errorLight, onClick = {
                    toDoList.add(completedListRemember.removeAt(index))
                })
            }

        }
    }
}

