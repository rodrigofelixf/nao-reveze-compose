package br.com.rodrigo.naoreveze.ui.screens

import SegmentoViewModel
import Segmentos


import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.rodrigo.naoreveze.R
import br.com.rodrigo.naoreveze.components.ShimmerSegmentos
import br.com.rodrigo.naoreveze.ui.theme.ButtonBlue
import br.com.rodrigo.naoreveze.ui.theme.DarkerButtonBlue
import br.com.rodrigo.naoreveze.ui.theme.DeepBlue
import br.com.rodrigo.naoreveze.ui.theme.LightRed
import br.com.rodrigo.naoreveze.ui.theme.TextWhite
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent


@Composable
fun HomeScreen(navController: NavController) {
    val segmentViewModel: SegmentoViewModel = viewModel()
    Box(
        modifier = androidx.compose.ui.Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = 10.dp,
                    top = 10.dp
                )
        ) {
            GreetingSection()
            // ChipSection(chips = listOf("Durma bem", "Insonia", "Ansiedade"))
            CurrentMeditation()
            FeatureSection(segmentViewModel.segmentsState.collectAsState().value,
                navController
            )
        }
        //aqui ficara o bottomNavigation
    }

}


@Composable
fun GreetingSection(
    name: String = "Rodrigo"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Olá, $name",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = stringResource(R.string.text_greeting_section),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow() {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)

            }
        }
    }

}

@Composable
fun CurrentMeditation(
    color: Color = LightRed

) {

    val videoUrl = "https://www.youtube.com/watch?v=jfKfPfyJRdk"
    val openUrl =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { _ ->
            // Nada para fazer aqui, a ação foi executada
        }
    Box(
        modifier = Modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                openUrl.launch(intent)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Column(
            ) {
                Text(
                    text = "Relaxamento Diario",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Lo-Fi Relaxante",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextWhite
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Player",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }

        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(segmentos: List<Segmentos>, navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 15.dp)

        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.text_o_que_esta_treinando),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(15.dp)
                )

            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        LazyVerticalGrid(
            GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 10.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            items(segmentos.size) {
                FeatureItem(segmentos = segmentos[it], navController)
            }

        }
    }

}


@Composable
fun FeatureItem(
    segmentos: Segmentos, navController: NavController
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController.navigate("detail/${segmentos.segmentoNome}")
            }
    ) {
        SubcomposeAsyncImage(
            model = segmentos.segmentoImagem,
            contentDescription = "teste",
            contentScale = ContentScale.Crop
        ) {

            val state = painter.state

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                    ShimmerSegmentos()
                } else {
                    this@SubcomposeAsyncImage.SubcomposeAsyncImageContent()
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Text(
                        text = segmentos.segmentoNome,
                        color = TextWhite,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .clip(RoundedCornerShape(10.dp))
                            .background(ButtonBlue)
                            .padding(vertical = 6.dp, horizontal = 15.dp)
                    )

                }
            }
        }

    }

}