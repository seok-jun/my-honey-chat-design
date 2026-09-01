#!/usr/bin/env python3
from __future__ import annotations

import html
import re
import shutil
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
ISSUES_DIR = ROOT / "issues"
DIST_DIR = ROOT / "dist"
TITLE_PATTERN = re.compile(r"<title[^>]*>(.*?)</title>", re.IGNORECASE | re.DOTALL)
TAG_PATTERN = re.compile(r"<[^>]+>")


def extract_title(path: Path) -> str:
    source = path.read_text(encoding="utf-8")
    match = TITLE_PATTERN.search(source)
    if not match:
        return f"Issue #{path.stem}"

    title = TAG_PATTERN.sub("", match.group(1))
    title = html.unescape(" ".join(title.split()))
    return title or f"Issue #{path.stem}"


def visual_specs() -> list[tuple[int, Path, str]]:
    specs: list[tuple[int, Path, str]] = []
    for path in ISSUES_DIR.glob("*.html"):
        if not path.stem.isdigit():
            continue
        issue_number = int(path.stem)
        specs.append((issue_number, path, extract_title(path)))
    return sorted(specs, key=lambda item: item[0], reverse=True)


def render_index(specs: list[tuple[int, Path, str]]) -> str:
    cards = []
    for issue_number, path, title in specs:
        cards.append(
            f'''\n      <article class="card">\n        <div class="issue">Issue #{issue_number}</div>\n        <h2>{html.escape(title)}</h2>\n        <div class="actions">\n          <a class="primary" href="issues/{path.name}">Visual Spec 열기</a>\n          <a href="https://github.com/seok-jun/my-honey-chat/issues/{issue_number}">앱 이슈 보기</a>\n        </div>\n      </article>'''
        )

    empty = '<p class="empty">아직 등록된 Visual Spec이 없습니다.</p>'
    content = "".join(cards) if cards else empty

    return f'''<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>My Honey Chat — Visual Specs</title>
  <style>
    :root {{
      color-scheme: light dark;
      font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif;
      --panel: color-mix(in srgb, CanvasText 5%, Canvas);
      --border: color-mix(in srgb, CanvasText 16%, Canvas);
      --muted: color-mix(in srgb, CanvasText 62%, Canvas);
      --accent: #6c63ff;
    }}
    * {{ box-sizing: border-box; }}
    body {{ max-width: 960px; margin: 0 auto; padding: 48px 24px 80px; line-height: 1.55; }}
    header {{ margin-bottom: 32px; }}
    h1 {{ margin: 0 0 8px; font-size: clamp(2rem, 5vw, 3rem); }}
    .subtitle {{ margin: 0; color: var(--muted); }}
    .meta {{ display: flex; gap: 12px; flex-wrap: wrap; margin-top: 18px; color: var(--muted); font-size: .92rem; }}
    .grid {{ display: grid; grid-template-columns: repeat(auto-fit, minmax(280px, 1fr)); gap: 16px; }}
    .card {{ border: 1px solid var(--border); background: var(--panel); border-radius: 16px; padding: 20px; }}
    .issue {{ color: var(--muted); font-size: .86rem; font-weight: 700; letter-spacing: .02em; }}
    h2 {{ margin: 8px 0 18px; font-size: 1.08rem; line-height: 1.45; }}
    .actions {{ display: flex; gap: 10px; flex-wrap: wrap; }}
    a {{ color: inherit; text-decoration: none; border: 1px solid var(--border); border-radius: 10px; padding: 9px 12px; font-size: .9rem; }}
    a:hover {{ border-color: var(--accent); }}
    a.primary {{ background: var(--accent); border-color: var(--accent); color: white; }}
    .empty {{ color: var(--muted); }}
    footer {{ margin-top: 32px; color: var(--muted); font-size: .86rem; }}
  </style>
</head>
<body>
  <header>
    <h1>Visual Specs</h1>
    <p class="subtitle">My Honey Chat UI/UX 시각 명세 미리보기</p>
    <div class="meta">
      <span>{len(specs)}개 Visual Spec</span>
      <span>issues/*.html 자동 수집</span>
    </div>
  </header>
  <main class="grid">{content}
  </main>
  <footer>이 페이지는 배포 시 자동 생성됩니다. <code>_template.html</code> 등 숫자가 아닌 파일은 목록에서 제외됩니다.</footer>
</body>
</html>
'''


def build() -> None:
    if DIST_DIR.exists():
        shutil.rmtree(DIST_DIR)

    (DIST_DIR / "issues").mkdir(parents=True)
    specs = visual_specs()

    for _, path, _ in specs:
        shutil.copy2(path, DIST_DIR / "issues" / path.name)

    (DIST_DIR / "index.html").write_text(render_index(specs), encoding="utf-8")
    (DIST_DIR / ".nojekyll").touch()

    print(f"Built {len(specs)} visual specs into {DIST_DIR}")


if __name__ == "__main__":
    build()
