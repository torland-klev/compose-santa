package klev.santa

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

object Styles {
    val SantaColor = Color(187, 58, 51)
    val SantaFaceColor = Color(244, 217, 196)
}

object Paths {
    fun DrawScope.hatTailPath() = Path().apply {
        moveTo(size.width.times(0f), size.height.times(0.01f))
        cubicTo(
            size.width.times(.1f),
            size.height.times(.02f),
            size.width.times(.65f),
            size.height.times(0f),
            size.width.times(.6f),
            size.height.times(.55f)
        )
        moveTo(size.width.times(.6f), size.height.times(.55f))
        cubicTo(
            size.width.times(.6f),
            size.height.times(.55f),
            size.width.times(.3f),
            size.height.times(.55f),
            size.width.times(.1f),
            size.height.times(0.1f)
        )
        close()
    }

    fun DrawScope.mustachePath() = Path().apply {
        moveTo(size.width.times(0), size.height.times(0.25f))
        cubicTo(
            size.width.times(.125f),
            size.height.times(1f),
            size.width.times(.375f),
            size.height.times(1f),
            size.width.times(.52f),
            size.height.times(.4f)
        )
        moveTo(size.width.times(.48f), size.height.times(.4f))
        cubicTo(
            size.width.times(.625f),
            size.height.times(1f),
            size.width.times(.85f),
            size.height.times(1f),
            size.width.times(1f),
            size.height.times(.25f)
        )
    }

    fun DrawScope.antiMustachePath() = Path().apply {
        moveTo(size.width.times(.0f), size.height.times(0.25f))
        cubicTo(
            size.width.times(.125f),
            size.height.times(.5f),
            size.width.times(.375f),
            size.height.times(.5f),
            size.width.times(.5f),
            size.height.times(.39f)
        )
        moveTo(size.width.times(.5f), size.height.times(.39f))
        cubicTo(
            size.width.times(.625f),
            size.height.times(.5f),
            size.width.times(.85f),
            size.height.times(.5f),
            size.width.times(1f),
            size.height.times(.25f)
        )

        close()
    }
}

object Modifiers {
    val HatBaseModifier = Modifier
        .width(160.dp)
        .height(120.dp)
        .clip(CircleShape)
        .background(Styles.SantaColor)

    val HatTailModifier = Modifier
        .height(100.dp)
        .width(125.dp)

    val HatDotModifier = Modifier
        .size(40.dp)
        .clip(CircleShape)
        .background(Color.White)

    val HatPaddingModifier = Modifier
        .width(180.dp)
        .height(30.dp)
        .clip(
            RoundedCornerShape(
                15.dp
            )
        )
        .background(Color.White)

    val MuttonModifier = Modifier
        .width(170.dp)
        .height(50.dp)
        .clip(
            RoundedCornerShape(
                10.dp
            )
        )
        .background(Color.White)

    val SantaFaceModifier = Modifier
        .width(150.dp)
        .height(35.dp)
        .clip(
            RoundedCornerShape(
                10.dp
            )
        )
        .background(Styles.SantaFaceColor)
        .zIndex(2f)

    val SantaNose = Modifier
        .width(30.dp)
        .height(25.dp)
        .clip(
            RoundedCornerShape(
                40.dp
            )
        )
        .background(Color(217, 179, 158))
        .zIndex(2f)

    val SantaMustacheModifier = Modifier
        .zIndex(2f)
        .width(150.dp)
        .height(40.dp)

    val SantaBeardModifier = Modifier
        .width(200.dp)
        .height(135.dp)
        .clip(
            RoundedCornerShape(
                topStart = 50.dp, topEnd = 50.dp, bottomStart = 100.dp, bottomEnd = 100.dp
            )
        )
        .background(Color.White)
}