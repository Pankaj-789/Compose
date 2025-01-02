package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BlogCategory(imgId: Int, heading: String, subHeading: String) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(imgId),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
//            ItemDescription("Developer", "Software developer", Modifier.weight(.8f))
            Column(modifier = Modifier.weight(.8f)) {
                Text(
                    text = heading,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = subHeading,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin
                )
            }

        }

    }
}

@Composable
fun ItemDescription(title: String, description: String, modifier: Modifier) {
    Column(modifier = Modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Thin
        )
    }
}

@Preview(showBackground = true, heightDp = 500)
@Composable
fun PreviewFunction() {
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        getCategoryList().map { item ->
//            BlogCategory(
//                imgId = item.img, heading = item.heading, subHeading = item.subHeading
//            )
//        }
//    }

    LazyColumn(content = {
        items(getCategoryList()){item ->
            BlogCategory(imgId = item.img, heading = item.heading, subHeading = item.subHeading)
        }
    })
//    BlogCategory(R.drawable.ic_person, "Programming", "Learn different language")

}

data class Category(val img: Int, val heading: String, val subHeading: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ic_person, "Programming", "Learn Different Language"))
    list.add(Category(R.drawable.ic_person, "Technology", "News about new tech"))
    list.add(Category(R.drawable.ic_person, "Full stack Development", "From backend to frontend"))
    list.add(Category(R.drawable.ic_person, "Devops", "Deployment, CI, CD etc"))
    list.add(Category(R.drawable.ic_person, "AI and ML", "Basic artificial intelligence"))
    list.add(Category(R.drawable.ic_person, "DOT NET", "Devloping API's"))
    list.add(Category(R.drawable.ic_person, "Programming", "Learn Different Language"))
    list.add(Category(R.drawable.ic_person, "Technology", "News about new tech"))
    list.add(Category(R.drawable.ic_person, "Full stack Development", "From backend to frontend"))
    list.add(Category(R.drawable.ic_person, "Devops", "Deployment, CI, CD etc"))
    list.add(Category(R.drawable.ic_person, "AI and ML", "Basic artificial intelligence"))
    list.add(Category(R.drawable.ic_person, "DOT NET", "Devloping API's"))

    return list
}