// some:You — 타이포그래피 (원본: foundation/tokens.json)
// Pretendard(SIL OFL 1.1)를 res/font/에 넣은 뒤 아래 Font 리소스 이름을 맞춘다.
// 폰트를 아직 넣지 않았다면 PretendardFamily를 FontFamily.Default로 바꿔도 동작한다.
package com.someyou.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
// import com.someyou.R

val PretendardFamily: FontFamily = FontFamily.Default
// val PretendardFamily = FontFamily(
//     Font(R.font.pretendard_regular, FontWeight.Normal),
//     Font(R.font.pretendard_medium, FontWeight.Medium),
//     Font(R.font.pretendard_semibold, FontWeight.SemiBold),
// )

/** 채팅 화면 전용 글자 스타일. */
object SomeYouTextStyles {
    /** 상단바 캐릭터 이름 18sp SemiBold */
    val CharacterName = TextStyle(fontFamily = PretendardFamily, fontWeight = FontWeight.SemiBold, fontSize = 18.sp, lineHeight = 24.sp)

    /** 상단바 상태 문구 13sp */
    val Status = TextStyle(fontFamily = PretendardFamily, fontWeight = FontWeight.Normal, fontSize = 13.sp, lineHeight = 18.sp)

    /** 메시지 본문 16sp / 23sp (설정에서 14~20sp 조절) */
    val MessageBody = TextStyle(fontFamily = PretendardFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 23.sp)

    /** 시간·읽음 11sp (색은 onSurfaceVariant) */
    val Meta = TextStyle(fontFamily = PretendardFamily, fontWeight = FontWeight.Normal, fontSize = 11.sp, lineHeight = 14.sp)

    /** 날짜 구분선 12sp Medium */
    val DateDivider = TextStyle(fontFamily = PretendardFamily, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp)

    /** 사용자 설정 본문 크기 적용 (14~20sp, 줄간격 1.45배) */
    fun messageBody(sizeSp: Int): TextStyle {
        val size = sizeSp.coerceIn(14, 20)
        return MessageBody.copy(fontSize = size.sp, lineHeight = (size * 1.45f).sp)
    }
}

/** Material 컴포넌트 기본 글꼴도 Pretendard로 맞춘다. */
internal val SomeYouTypography: Typography = Typography().let { base ->
    base.copy(
        titleLarge = base.titleLarge.copy(fontFamily = PretendardFamily),
        titleMedium = SomeYouTextStyles.CharacterName,
        bodyLarge = SomeYouTextStyles.MessageBody,
        bodyMedium = base.bodyMedium.copy(fontFamily = PretendardFamily),
        bodySmall = SomeYouTextStyles.Status,
        labelLarge = base.labelLarge.copy(fontFamily = PretendardFamily),
        labelMedium = SomeYouTextStyles.DateDivider,
        labelSmall = SomeYouTextStyles.Meta,
    )
}
