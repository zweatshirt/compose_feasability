package home.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import calendar.domain.model.Meeting
import home.presentation.ui.discipler_home.meetingsList
import ui.theme.primaryContainerLight
import ui.theme.primaryLight
import ui.theme.secondaryLight

/*
* Author: Zachery Linscott
* meetings.Meeting(s) section code
TODO: Fix padding at the end of the lazy rows
    (can be done by adding a unique pad value to the last item)
*/

@Composable
fun MeetingSection() {
    val containerPad = 16.dp
    SectionTitle("Upcoming meetings")
    LazyRow() {
        items(meetingsList.size) {
            MeetingCard(meetingsList[it])
        }
    }
}

// the time, data, and disciple parameters will need to be redefined to the specific object
// e.g. a disciple.Disciple object
@Composable
fun MeetingCard(meeting: Meeting) {
    val meetDisc = meeting.disciple
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
        .padding(start = 16.dp, end = 8.dp, bottom = 16.dp)
        .clickable {},
        elevation = 12.dp
    ) {
        Column(modifier = Modifier.background(primaryContainerLight).padding(16.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${meeting.time} ${meeting.date}",
                    fontSize = 16.sp,
                    color = secondaryLight,
                    fontWeight = FontWeight.Bold
                )
//                Icon(
//                    modifier = Modifier.clickable {},
//                    imageVector = Icons.Outlined.Info,
//                    contentDescription = "Show more"
//                )
//                if (meetDisc.image != null) {
//                    Image(
//                        painterResource(meetDisc.image),
//                        contentDescription = "Icon for ${meetDisc.firstName}"
//                    )
//                }
            }
            Divider(
                modifier = Modifier
                    .padding(bottom = 4.dp, top = 4.dp),
                thickness = 2.dp
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Text(
                        text = "meetings.Meeting with ${meetDisc.firstName} ${meetDisc.lastName}",
                        fontSize = 16.sp,
                        color = primaryLight,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
//            if (meeting.note != null) {
//                Text(
//                    text = "${meeting.note}",
//                    fontSize = 16.sp,
//                    color = primaryLight,
//                    fontWeight = FontWeight.Bold
//                )
//            }



        }
    }
}
