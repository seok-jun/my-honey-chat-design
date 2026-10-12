// some:You — 앱 테마 진입점
// 사용: setContent { SomeYouTheme { AppRoot() } }
// 기본은 다크(밤하늘). 시스템 설정을 따르려면 darkTheme = isSystemInDarkTheme() 를 넘긴다.
// Dynamic Color(배경화면 연동)는 의도적으로 지원하지 않는다.
package com.someyou.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun SomeYouTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) SomeYouDarkColorScheme else SomeYouLightColorScheme
    val someYouColors = if (darkTheme) DarkSomeYouColors else LightSomeYouColors

    CompositionLocalProvider(LocalSomeYouColors provides someYouColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = SomeYouTypography,
            shapes = SomeYouMaterialShapes,
            content = content,
        )
        // M3 Expressive를 쓸 때(material3 1.4.0-alpha 이상, 실험 API):
        // MaterialExpressiveTheme(colorScheme = colorScheme, typography = SomeYouTypography,
        //     shapes = SomeYouMaterialShapes, motionScheme = MotionScheme.expressive(), content = content)
    }
}

/** 채팅 전용 색 접근: SomeYouTheme.colors.userBubble */
object SomeYouTheme {
    val colors: SomeYouColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSomeYouColors.current
}
