package br.com.rodrigo.naoreveze

import Segmentos
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import br.com.rodrigo.naoreveze.components.ShimmerSegmentos
import br.com.rodrigo.naoreveze.components.shimmerBrush
import br.com.rodrigo.naoreveze.ui.theme.ButtonBlue
import br.com.rodrigo.naoreveze.ui.theme.DarkerButtonBlue
import br.com.rodrigo.naoreveze.ui.theme.DeepBlue
import br.com.rodrigo.naoreveze.ui.theme.LightRed
import br.com.rodrigo.naoreveze.ui.theme.TextWhite
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent


@Composable
fun HomeScreen() {
    Box(
        modifier = androidx.compose.ui.Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 10.dp)
        ) {
            GreetingSection()
            ChipSection(chips = listOf("Durma bem", "Insonia", "Ansiedade"))
            CurrentMeditation()
            FeatureSection(
                segmentos = listOf(
                    Segmentos(
                        segmentoNome = "Peitoral",
                        "https://img.freepik.com/fotos-gratis/homem-treinando-na-academia-local_93675-129483.jpg?w=1380&t=st=1691531590~exp=1691532190~hmac=cb8fb72de00e71ec72ecfad4ae3a2246218ccca5148d4112a99e3b7b4069dc02",
                    ),
                    Segmentos(
                        segmentoNome = "Costas",
                        "https://img.freepik.com/fotos-gratis/academia-homem-bonito-durante-treino_144627-6229.jpg?w=740&t=st=1691531653~exp=1691532253~hmac=c4c911e9bcd335d255cce4577145c13c9d5e38ec2747d7347db2a3b7a5a84eeb"
                    ),
                    Segmentos(
                        segmentoNome = "Pernas",
                        "https://img.freepik.com/fotos-premium/mulher-fazendo-treinamento-fisico-em-uma-maquina-de-empurrar-extensao-perna-com-pesos_136403-887.jpg?w=1380"
                    ),
                    Segmentos(
                        segmentoNome = "Biceps e Triceps",
                        "https://picsm.photos/1920/1080"
                    ),
                    Segmentos(
                        segmentoNome = "Ombros",
                        "https://img.freepik.co1532655~exp=1691533255~hmac=acc6759a4d8cec70a3b7471c7d1cfe24d31cc179187eabf71b664f436ab59779"
                    ),
                    Segmentos(
                        segmentoNome = "Abdomen",
                        url = "https://img.freepik.com/fotos-gratis/vista-lateral-de-uma-jovem-determinada-segurando-uma-bola-de-slam-com-as-pernas-e-fazendo-abdominais-para-ter-abdominais-planos_662251-1367.jpg?w=1380&t=st=1691532748~exp=1691533348~hmac=16e7a7ebfc1ad49cb3617b869fc2ef2f80a153551334464641ea89a156382bff"
                    ),

                )
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
        Box(modifier = Modifier.weight(1f)) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Boa noite, $name",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Desejamos que você tenha uma ótima meditação, $name.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
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
        Column {
            Text(
                text = "Relaxamento Diario",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Meditacao 3-10 min",
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(segmentos: List<Segmentos>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.text_o_que_esta_treinando),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 10.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            items(segmentos.size) {
                FeatureItem(segmentos = segmentos[it])
            }

        }
    }

}


@Composable
fun FeatureItem(
    segmentos: Segmentos
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                // Handle the click
            }
    ) {
        SubcomposeAsyncImage(
            model = segmentos.url,
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