package klev.santa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import klev.santa.Modifiers.HatBaseModifier
import klev.santa.Modifiers.HatDotModifier
import klev.santa.Modifiers.HatPaddingModifier
import klev.santa.Modifiers.HatTailModifier
import klev.santa.Modifiers.MuttonModifier
import klev.santa.Modifiers.SantaBeardModifier
import klev.santa.Modifiers.SantaFaceModifier
import klev.santa.Modifiers.SantaMustacheModifier
import klev.santa.Modifiers.SantaNose
import klev.santa.Paths.antiMustachePath
import klev.santa.Paths.hatTailPath
import klev.santa.Paths.mustachePath
import klev.santa.Styles.SantaColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ConstraintLayout {
            val (hat, face) = createRefs()
            Hat(Modifier.constrainAs(hat) {
                centerHorizontallyTo(parent)
            })
            Head(Modifier.constrainAs(face) {
                top.linkTo(hat.bottom, (-5).dp)
                centerHorizontallyTo(parent)
            })
        }
    }
}


@Composable
fun Hat(modifier: Modifier) {
    ConstraintLayout(modifier) {
        val (padding, hatBase, hatPath, dot) = createRefs()

        Box(HatBaseModifier.constrainAs(hatBase) {
            centerHorizontallyTo(parent)
        })

        Canvas(HatTailModifier.constrainAs(hatPath) {
            absoluteLeft.linkTo(hatBase.absoluteRight, -(50).dp)
        }) {
            drawPath(path = hatTailPath(), color = SantaColor)
        }

        Box(HatDotModifier.constrainAs(dot) {
            centerVerticallyTo(hatBase, 0.67f)
            absoluteLeft.linkTo(hatBase.absoluteRight, 10.dp)
        })

        Box(HatPaddingModifier.constrainAs(padding) {
            centerHorizontallyTo(parent)
            top.linkTo(hatBase.bottom, (-35).dp)
        })
    }
}

@Composable
fun Head(modifier: Modifier) {
    ConstraintLayout(modifier) {
        val (beard, faceBeard, face, nose, leftEye, rightEye, leftEar, rightEar, moustache) = createRefs()
        Box(MuttonModifier.constrainAs(faceBeard) {
            centerHorizontallyTo(parent)
        })

        Ear(Modifier.constrainAs(leftEar) {
            absoluteRight.linkTo(faceBeard.absoluteLeft, (-8).dp)
            centerVerticallyTo(faceBeard, 0.55f)
        })

        Ear(Modifier.constrainAs(rightEar) {
            absoluteLeft.linkTo(faceBeard.absoluteRight, (-8).dp)
            centerVerticallyTo(faceBeard, 0.55f)
        })

        Box(modifier = SantaFaceModifier
            .constrainAs(face) {
                centerHorizontallyTo(parent)
                top.linkTo(faceBeard.top, 3.dp)
            }
        )

        Box(modifier = SantaNose
            .constrainAs(nose) {
                centerHorizontallyTo(parent)
                top.linkTo(face.top, 20.dp)
            }
        )

        Eye(Modifier.constrainAs(leftEye) {
            centerHorizontallyTo(parent, 0.4f)
            top.linkTo(face.top, 6.dp)
        })

        Eye(Modifier.constrainAs(rightEye) {
            centerHorizontallyTo(parent, 0.6f)
            top.linkTo(face.top, 6.dp)
        })

        Canvas(
            SantaMustacheModifier
                .constrainAs(moustache) {
                    top.linkTo(nose.top, 15.dp)
                    centerHorizontallyTo(nose)
                }) {

            drawPath(path = mustachePath(), color = Color(223, 223, 223))
            drawPath(path = antiMustachePath(), color = White)
        }

        Box(SantaBeardModifier
            .constrainAs(beard) {
                top.linkTo(faceBeard.bottom, margin = (-30).dp)
            })
    }

}

@Composable
fun Ear(modifier: Modifier) {
    Box(
        modifier
            .size(15.dp)
            .clip(CircleShape)
            .background(Styles.SantaFaceColor)
            .zIndex(-1f)
    )
}

@Composable
fun Eye(modifier: Modifier) {
    Box(
        modifier
            .size(10.dp)
            .clip(CircleShape)
            .background(Color(4, 4, 4))

            .padding(start = 4.dp, top = 3.dp)
            .zIndex(2f)
    ) {
        Box(
            Modifier
                .size(3.dp)
                .clip(CircleShape)
                .background(White)
        )
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}