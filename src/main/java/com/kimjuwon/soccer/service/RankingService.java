package com.kimjuwon.soccer.service;

import java.util.Map;

public interface RankingService {
    Map<String, Object> getTableOfLeague(Integer leagueId) throws Exception;
    Map<String, Object> getClubRankingOfLeague(Integer leagueId, String clubName) throws Exception;
    Map<String, Object> getPlayersGoalRankingOfLeague(Integer leagueId, Integer categoryId) throws Exception;
}
