# my-honey-chat-design

My Honey Chat UI/UX Visual Spec 전용 저장소.

## Visual Spec 규칙

- 앱 이슈 번호를 파일명으로 사용한다: `issues/57.html`
- 한 이슈는 가능한 한 self-contained HTML 하나로 관리한다.
- `_template.html`처럼 숫자가 아닌 HTML은 배포 인덱스에서 제외된다.

## 시안 등록과 작업 종료

절차의 원본은 앱 저장소의 [Visual Spec 링크 규칙과 디자인 PR 병합·배포·정리](https://github.com/seok-jun/my-honey-chat/blob/main/docs/issue-writing-guide.md#디자인-pr-병합배포정리)다.

이슈 생성 또는 시안 수정 시 HTML 검증·고정 commit 링크 연결 → 디자인 PR 병합 → Pages 배포·미리보기 확인 → 병합된 branch/worktree 정리까지 같은 작업에서 마친다. 앱 구현 완료까지 디자인 branch를 남겨두지 않는다. 다음 수정은 최신 디자인 main에서 새 branch로 시작한다.

main은 초안/설계 시안도 보관하며 해당 상태를 HTML 또는 앱 Issue에 표시한다. 디자인 PR 병합은 앱 승인이나 구현 완료를 뜻하지 않는다. 구현 기준은 앱 Issue의 immutable commit 링크이며 Pages URL은 편의 링크다. 병합은 이 고정 commit을 main 이력에 보존하고, 디자인 PR로 앱 Issue를 닫지 않는다.

현재 branch tip의 병합·고정 링크 접근·미커밋/미게시 변경과 다른 active 작업 부재를 확인한 branch만 정리한다. 검증·병합·배포·정리 실패는 마지막 성공 단계와 남은 작업을 기록하고, 미병합 branch나 다른 작업 공간을 강제 삭제하지 않는다. 기존 공개·승인 제한을 우회하지 않는다.

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
