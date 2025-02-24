package com.example.reddit_clone.Composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.reddit_clone.features.homepage.domainLayer.dataModels.Post
import com.example.reddit_clone.features.homepage.presentationLayer.viewModels.HomePageViewModel

@Composable
fun PostCard(post: Post,model: HomePageViewModel,index:Int){
    Card(
        shape = RoundedCornerShape(5),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.Cyan
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)

    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
//           Image(bitmap = , contentDescription = )
                Box{
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            alignment = Alignment.Center,
                            model = post.author.profilePic,
                            contentDescription = "Description of the image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "${post.author.userName}    ${post.uploadTime}")
                    }

                }
                Box{
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Join")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription =null )
                        }
                    }
                }

            }

            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                maxLines = 2,
                text = post.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(3))
                    .background(Color.Black)
                ,
                contentAlignment = Alignment.Center,
            ){
                val img = post.postItems[(0..2).random()]

                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(radiusX = 50.dp, radiusY = 50.dp),
                    contentScale = ContentScale.FillBounds,
                    model = img,
                    contentDescription =null
                )

                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit,
                    model = img,
                    contentDescription =null
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Spacer(modifier = Modifier.width(5.dp))
                Card(
                    shape = RoundedCornerShape(20),
                    border = BorderStroke(1.dp, Color(0xFF7751D0)),
                    colors = CardColors(
                        contentColor = Color(0xFF7751D0),
                        containerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(
                            colors = IconButtonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color(0xFF7751D0),
                                disabledContentColor = Color.Gray,
                                disabledContainerColor = Color.Gray
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(5.dp),
                            onClick = { model.likePost(index)}
                        ) {
                            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null)
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = post.likeCount.toString())
                        Spacer(modifier = Modifier.width(5.dp))

                        IconButton(
                            colors = IconButtonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color(0xFF7751D0),
                                disabledContentColor = Color.Gray,
                                disabledContainerColor = Color.Gray
                            ),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(5.dp),
                            onClick = {model.disLikePost(index) }
                        ) {
                            Icon(
                                modifier = Modifier.rotate(180.0F),
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = null
                            )
                        }
                    }

                }


                Spacer(modifier = Modifier.width(20.dp))

                AssistChip(
                    leadingIcon = { Icon(imageVector = Icons.Rounded.Email, contentDescription =null) },
                    onClick = { /*TODO*/ },
                    label = {
                        Text(text = post.comentsCount.toString())
                    }
                )

                Spacer(modifier = Modifier.width(20.dp))

                AssistChip(
                    leadingIcon = { Icon(imageVector = Icons.Rounded.Share, contentDescription =null) },
                    onClick = { /*TODO*/ },
                    label = {
                        Text(text = "Share")
                    }
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

