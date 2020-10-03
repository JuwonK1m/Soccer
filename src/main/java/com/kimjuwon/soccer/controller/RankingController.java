package com.kimjuwon.soccer.controller;

import com.kimjuwon.soccer.service.RankingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class RankingController {
    @Resource(name = "rankingServiceImpl")
    private RankingService rankingService;

    @ApiOperation(value = "유럽 축구 5대 리그별 팀 전체 순위 읽어오기", notes = "유럽 축구 5대 리그별 팀 전체 순위를 읽어옵니다.\n(leagueId)\n1: 프리미어리그\n2: 라리가\n3: 분데스리가\n4: 세리에 A\n5: 프랑스 리그 1")
    @GetMapping(value = "/league/{leagueId}/table")
    public ResponseEntity getTableOfLeague(@PathVariable Integer leagueId) throws Exception {
        return new ResponseEntity<Map<String, Object>>(rankingService.getTableOfLeague(leagueId), HttpStatus.OK);
    }

    @ApiOperation(value = "유럽 축구 5대 리그별 특정 팀 순위 읽어오기", notes = "유럽 축구 5대 리그별 팀 전체 순위를 읽어옵니다.\n(leagueId)\n1: 프리미어리그\n2: 라리가\n3: 분데스리가\n4: 세리에 A\n5: 프랑스 리그 1\n(clubName)\n예시: 도르트문트")
    @GetMapping(value = "/league/{leagueId}/clubs/ranking")
    public ResponseEntity getClubRankingOfLeague(@PathVariable Integer leagueId, @RequestParam("clubName") String clubName) throws Exception {
        return new ResponseEntity<Map<String, Object>>(rankingService.getClubRankingOfLeague(leagueId, clubName), HttpStatus.OK);
    }

    @ApiOperation(value = "유럽 축구 5대 리그별 선수들의 골, 어시스트 순위 읽어오기", notes = "유럽 축구 5대 리그별 선수들의 골, 어시스트 순위를 읽어옵니다.\n(leagueId)\n1: 프리미어리그\n2: 라리가\n3: 분데스리가\n4: 세리에 A\n5: 프랑스 리그 1\n(categoryId)\n1: 골\n2: 어시스트")
    @GetMapping(value = "league/{leagueId}/players/table/{categoryId}")
    public ResponseEntity getPlayersRankingOfLeague(@PathVariable Integer leagueId, @PathVariable Integer categoryId) throws Exception {
        return new ResponseEntity<Map<String, Object>>(rankingService.getPlayersGoalRankingOfLeague(leagueId, categoryId), HttpStatus.OK);
    }
}
