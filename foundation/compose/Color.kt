// some:You — 컬러 토큰 (원본: foundation/tokens.json)
// 초안: 앱 저장소의 패키지명에 맞게 package 선언을 바꿔서 쓴다.
package com.someyou.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// ── Dark (기본) ─────────────────────────────────────────────
private val DarkBackground = Color(0xFF0E0B1F)
private val DarkSurface = Color(0xFF1E1838)
private val DarkSurfaceVariant = Color(0xFF262046)
private val DarkOutline = Color(0xFF3A3260)
private val DarkOnSurface = Color(0xFFECE8FF)
private val DarkOnSurfaceVariant = Color(0xFFA9A2C9)
private val DarkPrimary = Color(0xFF9C8FFF)
private val DarkOnPrimary = Color(0xFF120E2A)
private val DarkUserBubble = Color(0xFF5B4BD0)
private val DarkStar = Color(0xFFFFD27A)

// ── Light ──────────────────────────────────────────────────
private val LightBackground = Color(0xFFF5F3FC)
private val LightSurface = Color(0xFFFFFFFF)
private val LightSurfaceVariant = Color(0xFFECE8F8)
private val LightOutline = Color(0xFFDCD5F2)
private val LightOnSurface = Color(0xFF1C1733)
private val LightOnSurfaceVariant = Color(0xFF5F5880)
private val LightPrimary = Color(0xFF4F3FC4)
private val LightOnPrimary = Color(0xFFFFFFFF)
private val LightUserBubble = Color(0xFF4F3FC4)
private val LightStar = Color(0xFFF2B544)

private val OnUserBubble = Color(0xFFFFFFFF)
private val OnStar = Color(0xFF2B1A0E)

// 참고: Material의 surface는 화면 배경(토큰 background)으로 맞추고,
// 토큰 surface(캐릭터 말풍선·카드)는 surfaceContainer와 SomeYouColors.characterBubble로 쓴다.
// Material 컴포넌트가 기본 보라/회색을 끌어오지 않도록 쓰는 역할은 모두 토큰으로 채운다.
// surfaceContainer* 파라미터는 material3 1.2.0 이상에서 지원한다.
internal val SomeYouDarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkUserBubble,
    onPrimaryContainer = OnUserBubble,
    secondary = DarkPrimary,
    onSecondary = DarkOnPrimary,
    tertiary = DarkStar,
    onTertiary = OnStar,
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkBackground,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    surfaceContainerLowest = DarkBackground,
    surfaceContainerLow = DarkBackground,
    surfaceContainer = DarkSurface,
    surfaceContainerHigh = DarkSurfaceVariant,
    surfaceContainerHighest = DarkSurfaceVariant,
    outline = DarkOutline,
    outlineVariant = DarkOutline,
)

internal val SomeYouLightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightUserBubble,
    onPrimaryContainer = OnUserBubble,
    secondary = LightPrimary,
    onSecondary = LightOnPrimary,
    tertiary = LightStar,
    onTertiary = OnStar,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightBackground,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    surfaceContainerLowest = LightSurface,
    surfaceContainerLow = LightBackground,
    surfaceContainer = LightSurface,
    surfaceContainerHigh = LightSurfaceVariant,
    surfaceContainerHighest = LightSurfaceVariant,
    outline = LightOutline,
    outlineVariant = LightOutline,
)

/** Material ColorScheme에 없는 채팅 전용 색. */
@Immutable
data class SomeYouColors(
    /** 캐릭터 말풍선 배경 (토큰 surface). 항상 bubbleOutline 1dp 테두리와 함께 쓴다. */
    val characterBubble: Color,
    val bubbleOutline: Color,
    val userBubble: Color,
    val onUserBubble: Color,
    /** 별빛 포인트: 온라인 점, 안 읽은 배지, 선톡 칩에만 쓴다. */
    val star: Color,
    val onStar: Color,
)

internal val DarkSomeYouColors = SomeYouColors(
    characterBubble = DarkSurface,
    bubbleOutline = DarkOutline,
    userBubble = DarkUserBubble,
    onUserBubble = OnUserBubble,
    star = DarkStar,
    onStar = OnStar,
)

internal val LightSomeYouColors = SomeYouColors(
    characterBubble = LightSurface,
    bubbleOutline = LightOutline,
    userBubble = LightUserBubble,
    onUserBubble = OnUserBubble,
    star = LightStar,
    onStar = OnStar,
)

internal val LocalSomeYouColors = staticCompositionLocalOf { DarkSomeYouColors }
