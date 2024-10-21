package com.example.my30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.ui.tooling.preview.Preview
import com.example.my30daysapp.ui.theme.My30DaysAppTheme
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.Image

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My30DaysAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    My30DaysApp()
                }
            }
        }
    }
}

@Composable
fun My30DaysApp() {
    Scaffold(
        topBar = {
            My30DaysAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(daysList) {
                DayItem(
                    day = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun My30DaysAppBar() {
    SmallTopAppBar(
        title = {
            Text(text = "30 Days of Android Kotlin Compose")
        }
    )
}

@Composable
fun DayItem(day: Day, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Day ${day.dayNumber}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "${day.topic}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(2f)
                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = null
                    )
                }
            }

            Image(
                painter = rememberAsyncImagePainter(model = day.imageRes),
                contentDescription = "Image for ${day.topic}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = day.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                day.additionalImageRes?.let { imageRes ->
                    Image(
                        painter = rememberAsyncImagePainter(model = imageRes),
                        contentDescription = "Additional image for ${day.topic}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                }
            }
        }
    }
}

data class Day(
    val dayNumber: Int,
    val topic: String,
    val description: String,
    val imageRes: Int,
    val additionalImageRes: Int? = null
)

val daysList = listOf(
        Day(1,"Welcome to Android Basics with Compose", "Meet the team and learn what you’ll need to begin developing Android apps with Jetpack Compose.",
            R.drawable.image1, null),
        Day(2,"Create your first Android app", "Learn how to create your first Android app.",
            R.drawable.image2, R.drawable.day2image),
        Day(3,"Design a birthday card app", "Learn about the tools you’ll use to start developing apps.",
            R.drawable.image3, R.drawable.day3image),
        Day(4,"Build a simple app with text composables", "Learn how to build a simple app with composable functions.",
            R.drawable.image4, R.drawable.day4image),
        Day(5,"Add images to your Android app", "Learn how to add images to your app using a composable function.",
            R.drawable.image5, R.drawable.day5image),
        Day(6,"Practice: Compose Basics", "Apply the concepts of basic UI composables to implement screens for the given problems.",
            R.drawable.image6, R.drawable.day6image),
        Day(7,"Project: Create a business card app", "Learn how to create an Android app that showcases your business card.",
            R.drawable.image7, R.drawable.day7image),
        Day(8,"Write conditionals in Kotlin", "Learn how to write conditionals in Kotlin.",
            R.drawable.image8, R.drawable.day8image),
        Day(9,"Use nullability in Kotlin", "Learn how to use nullability in Kotlin.",
            R.drawable.image9, R.drawable.day9image),
        Day(10,"Use classes and objects in Kotlin", "ALearn how to use classes and objects in Kotlin.",
            R.drawable.image10, R.drawable.day10image),
        Day(11,"Use function types and lambda expressions in Kotlin", "Learn how to use lambda expressions and higher order functions in Kotlin.",
            R.drawable.image11, R.drawable.day11image),
        Day(12,"Practice: Kotlin Fundamentals", "Apply the basic concepts of the Kotlin programming language to solve the given problems.",
            R.drawable.image12, null),
        Day(13,"Create an interactive Dice Roller app", "Learn how to build an interactive Dice Roller app that lets users roll a dice and then shows them the result.",
            R.drawable.image13, R.drawable.day13image),
        Day(14,"Practice: Click behavior", "Apply what you learned about button click behavior to build an app.",
            R.drawable.image14, R.drawable.day14image),
        Day(15,"Intro to state in Compose", "Learn about state, and how it can be used and manipulated by Jetpack Compose.",
            R.drawable.image15, R.drawable.day15image),
        Day(16,"Calculate a custom tip", "Learn how to add an action button, set up keyboard actions, and use a Switch composable.",
            R.drawable.image16, R.drawable.day16image),
        Day(17,"Write automated tests", "In this codelab, you’ll learn what automated tests are, why they are important, and how to write them.",
            R.drawable.image17, R.drawable.day17image),
        Day(18,"Project: Create an Art Space app", "Learn how to create an Android app that showcases your own art space.",
            R.drawable.image18, R.drawable.day18image),
        Day(19,"Generics, objects, and extensions", "Gain a high-level introduction to Kotlin concepts such as generics, enum classes, data classes, objects, and scope functions which you’ll be using in your Compose code.",
            R.drawable.image19, R.drawable.day19image),
        Day(20,"Use collections in Kotlin", "Store a collection of data using arrays, lists, sets, and maps in Kotlin.",
            R.drawable.image20, R.drawable.day20image),
        Day(21,"Higher-order functions with collections", "Become more comfortable with using higher-order functions in Kotlin as a convenient way to manipulate collections.",
            R.drawable.image21, R.drawable.day21image),
        Day(22,"Add a scrollable list", "Build the Affirmations app, which displays a scrollable list of text and images.",
            R.drawable.image22, R.drawable.day22image),
        Day(23,"Change the app icon", "Learn about adaptive launcher icons and how to change the app icon for the Affirmations app.",
            R.drawable.image23, R.drawable.day23image),
        Day(24,"Practice: Build a grid", "Apply what you learned while building the Affirmations app to build an app that displays a grid of topics.",
            R.drawable.image24, R.drawable.day24image),
        Day(25,"Intro to Material Design with Compose", "Welcome to Pathway 3! This video introduces Material Design and how you can use it to improve the user experience of your app.",
            R.drawable.image25, null),
        Day(26,"Material Theming with Jetpack Compose", "Learn how to add Material theming to a Compose app, by customizing color, shape, and typography.",
            R.drawable.image26, R.drawable.day26image),
        Day(27,"Simple animation with Jetpack Compose", "Add a simple animation to your app in Compose, and experiment with other types of animations.",
            R.drawable.image27, R.drawable.day27image),
        Day(28,"Testing for Accessibility", "Test an app for accessibility and how to make your app accessible to more users.",
            R.drawable.image28, R.drawable.day28image),
        Day(29,"Practice: Build Superheroes app", "Practice what you learned about Material Design and simple animations in order to build an app that displays a list of superheroes.",
            R.drawable.image29, R.drawable.day29image),
        Day(30,"Project: Create a 30 Days App", "Using everything that you learned in this unit, create your own Android app that displays 30 tips (one for each day of the month) on a topic of your choice.",
            R.drawable.image30, R.drawable.day30image)
)

@Preview(showBackground = true)
@Composable
fun My30DaysAppPreview() {
    My30DaysAppTheme {
        My30DaysApp()
    }
}