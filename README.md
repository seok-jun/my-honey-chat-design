# my-honey-chat-design

My Honey Chat UI/UX Visual Spec 전용 저장소.

## Visual Spec 규칙

- 앱 이슈 번호를 파일명으로 사용한다: `issues/57.html`
- 한 이슈는 가능한 한 self-contained HTML 하나로 관리한다.
- `_template.html`처럼 숫자가 아닌 HTML은 배포 인덱스에서 제외된다.

## HTML 미리보기

`main`에 `issues/*.html` 변경이 반영되면 GitHub Actions가 미리보기 사이트를 자동 생성하고 GitHub Pages로 배포한다.

- 인덱스 생성: `scripts/build_site.py`
- 배포 워크플로우: `.github/workflows/pages.yml`
- 예상 Pages URL: `https://seok-jun.github.io/my-honey-chat-design/`
- 개별 Visual Spec: `https://seok-jun.github.io/my-honey-chat-design/issues/{issue-number}.html`

예를 들어 `issues/160.html`을 추가하면 별도 인덱스 수정 없이 다음 배포에서 `Issue #160`이 자동으로 노출된다.

> [!WARNING]
> GitHub Pages는 이 저장소가 private이어도 개인 계정에서는 공개 인터넷에 게시된다. Visual Spec에 비공개 정보나 민감한 데이터를 포함하지 않는다.

## 최초 1회 설정

GitHub 저장소의 `Settings > Pages`에서 Build and deployment Source를 **GitHub Actions**로 설정해야 한다. 이후에는 `main` 변경 시 자동 배포된다.
