# Soccer  
축구와 관련된 정보들을 얻기 위한 REST API 사이드 프로젝트

## 개발 환경
***IntelliJ IDEA, Spring Boot, Maven***

## 개발 기록
2020.09.25
- 유럽 5대 리그별 팀 순위를 얻을 수 있는 API 개발 
  - `GET: /league/{leagueId}/table`
    - leagueId(path) -> 1: 프리미어리그, 2: 라리가, 3: 분데스리가, 4: 세리에 A, 5: 리그앙(프랑스 리그 1)  

2020.09.26
- 유럽 5대 리그별 특정 팀의 순위(리그 순위, 승점, 승, 무, 패 등)를 얻을 수 있는 API 개발
  - `GET: /league/{leagueId}/club/ranking`
    - leagueId(path) -> 1: 프리미어리그, 2: 라리가, 3: 분데스리가, 4: 세리에 A, 5: 리그앙(프랑스 리그 1)
    - clubName(query): 팀 이름

2020.10.03
- 유럽 5대 리그별 선수들의 골, 어시스트 순위를 얻을 수 있는 API 개발
  - `GET: /league/{leagueId}/players/table/{categoryId}`
    - leagueId(path) -> 1: 프리미어리그, 2: 라리가, 3: 분데스리가, 4: 세리에 A, 5: 리그앙(프랑스 리그 1)  
    - categoryId(path) -> 1: 골, 2: 어시스트