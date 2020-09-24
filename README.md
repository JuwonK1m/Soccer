# Soccer  
축구와 관련된 정보들을 얻기 위한 REST API 사이드 프로젝트

## 개발 환경
***IntelliJ IDEA, Spring Boot, Maven***

## 개발 기록
2020.09.25
- 유럽 5대 리그별 팀 순위를 얻을 수 있는 기능 개발 
  - `GET: /league/{leagueId}/table`
    - leagueId -> 1: 프리미어리그, 2: 라리가, 3: 분데스리가, 4: 세리에 A, 5: 리그앙(프랑스 리그 1)
    - 각 리그별로 순위표가 있는 웹사이트를 파싱하여 데이터 추출
