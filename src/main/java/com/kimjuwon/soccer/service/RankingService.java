package com.kimjuwon.soccer.service;

import java.util.Map;

public interface RankingService {
    Map<String, Object> getTableOfLeague(Integer leagueId) throws Exception;
}
