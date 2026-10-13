// some:You — 모서리·간격·크기 (원본: foundation/tokens.json)
package com.someyou.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object SomeYouShapes {
    /** 캐릭터(왼쪽) 묶음의 첫 말풍선: 왼쪽 위가 꼬리 */
    val CharacterBubbleFirst = RoundedCornerShape(topStart = 6.dp, topEnd = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp)

    /** 내(오른쪽) 묶음의 첫 말풍선: 오른쪽 위가 꼬리 */
    val UserBubbleFirst = RoundedCornerShape(topStart = 20.dp, topEnd = 6.dp, bottomEnd = 20.dp, bottomStart = 20.dp)

    /** 묶음 안의 연속 말풍선: 꼬리 없음 */
    val BubbleContinued = RoundedCornerShape(20.dp)

    val Image = RoundedCornerShape(16.dp)
    val Input = RoundedCornerShape(24.dp)
    val Chip = RoundedCornerShape(percent = 50)
}

object SomeYouSpacing {
    val ScreenHorizontal = 16.dp
    val BubblePaddingHorizontal = 14.dp
    val BubblePaddingVertical = 10.dp
    val SameSenderGap = 4.dp
    val SenderChangeGap = 12.dp
}

object SomeYouSize {
    val AvatarTopBar = 40.dp
    val AvatarBubble = 32.dp
    val AvatarList = 52.dp
    val AvatarProfile = 96.dp
    val OnlineDot = 10.dp
    val MinTouchTarget = 48.dp
    val InputMinHeight = 48.dp
    val SendButton = 48.dp
    val ImageMaxWidth = 240.dp
    const val BubbleMaxWidthRatio = 0.78f
}

internal val SomeYouMaterialShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(20.dp),
    extraLarge = RoundedCornerShape(24.dp),
)
