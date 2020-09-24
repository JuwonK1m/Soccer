package com.kimjuwon.soccer.controller;

import com.kimjuwon.soccer.service.RankingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class RankingController {
    @Resource(name = "rankingServiceImpl")
    private RankingService rankingService;

    @ApiOperation(value = "축구 리그의 팀 전체 순위 불러오기", notes = "축구 리그의 팀 전체 순위를 불러옵니다.\n<leagueId>\n1: 프리미어리그\n2: 라리가\n3: 분데스리가\n4: 세리에 A\n5: 프랑스 리그 1")
    @GetMapping(value = "league/{leagueId}/table")
    public ResponseEntity getTableOfLeague(@PathVariable Integer leagueId) throws Exception {
        return new ResponseEntity<Map<String, Object>>(rankingService.getTableOfLeague(leagueId), HttpStatus.OK);
    }
}
