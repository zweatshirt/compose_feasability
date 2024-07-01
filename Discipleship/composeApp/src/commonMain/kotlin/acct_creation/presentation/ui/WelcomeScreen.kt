package acct_creation.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import discipleship.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import discipleship.composeapp.generated.resources.crulogo
import org.jetbrains.compose.resources.DrawableResource
import ui.theme.backgroundLight
import ui.theme.onPrimaryContainerLight
import ui.theme.primaryContainerLight
import ui.theme.primaryLight


val resources = listOf(

    Resources(
        resourceName = "How to disciple",
        resourceType = "Article"
    ),

    Resources(
        resourceName = "Discipleship",
        resourceType = "Article"
    ),

    Resources(
        resourceName = "Leadership",
        resourceType = "Article"
    )
)

class WelcomeScreen: Screen {
    override val key: ScreenKey = "WelcomeScreen"
    @Composable
    override fun Content() {
        val cru: DrawableResource = Res.drawable.crulogo // image of the Cru logo
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()

        Scaffold {
            Column(
                modifier = Modifier
                    .background(
                        backgroundLight
                    )
                    .fillMaxSize()
                    .padding(18.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollState),
            ) {

                Image(
                    painterResource(cru),
                    contentDescription = "Cru logo",
                    modifier = Modifier
                        .size(125.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "Welcome",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = primaryLight
                )

                Spacer(modifier = Modifier.padding(20.dp))

                Text(
                    text = "What is Discipleship?",
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = primaryLight
                )
                Text(
                    text = "Discipleship is a journey of intentional decisions leading to maturity in your relationship with Jesus so that you become more like Him in your attitudes, focus and ultimately behavior. It requires a commitment from the potential disciple and the disciple-makers. It’s not something that happens by accident or overnight, and it can’t be completed in a six-week class. This is a lifelong commitment to follow God with your whole self and to both learn from and eventually teach others about how to follow Him.",
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.padding(12.dp))

                Text(
                    text = "Resources",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = primaryLight
                )

                Spacer(modifier = Modifier.padding(8.dp))

                LazyRow {
                    items(resources.size) { index ->
                        ResourceItem(index)
                    }
                }

                Spacer(modifier = Modifier.padding(8.dp))

                Button(
                    onClick = {navigator.push(LoginScreen())},
                    modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = primaryLight,
                        contentColor = backgroundLight
                    )
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
fun ResourceItem(
    index: Int
) {
    val resource = resources[index]
    var lastItemPaddingEnd = 0.dp
    if (index == resources.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    Box(
        modifier = Modifier.padding(start = 12.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(primaryContainerLight)
                .width(200.dp)
                .height(150.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = resource.resourceName,
                color = onPrimaryContainerLight,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = resource.resourceType,
                color = onPrimaryContainerLight,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}