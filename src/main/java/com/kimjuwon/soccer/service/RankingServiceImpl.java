package com.kimjuwon.soccer.service;

import com.kimjuwon.soccer.domain.Club;
import com.kimjuwon.soccer.domain.Player;
import com.kimjuwon.soccer.exception.NotFoundException;
import com.kimjuwon.soccer.util.LeagueUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RankingServiceImpl implements RankingService {
    @Value("${premierleague.table.url}")
    private String PREMIERLEAGUE_TABLE_URL;
    @Value("${laliga.table.url}")
    private String LALIGA_TABLE_URL;
    @Value("${bundesliga.table.url}")
    private String BUNDESLIGA_TABLE_URL;
    @Value("${seriea.table.url}")
    private String SERIEA_TABLE_URL;
    @Value("${ligue1.table.url}")
    private String LIGUE1_TABLE_URL;

    public Map<String, Object> getTableOfLeague(Integer leagueId) throws Exception {
        Document document;
        Elements elements;
        List<Club> clubs = new ArrayList<>();

        // 프리미어리그
        if (leagueId == LeagueUtil.PREMIERLEAGUE) {
            document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        }
        // 라리가
        else if (leagueId == LeagueUtil.LALIGA) {
            document = Jsoup.connect(LALIGA_TABLE_URL).get();
        }
        // 분데스리가
        else if (leagueId == LeagueUtil.BUNDESLIGA) {
            document = Jsoup.connect(BUNDESLIGA_TABLE_URL).get();
        }
        // 세리에 A
        else if (leagueId == LeagueUtil.SERIEA) {
            document = Jsoup.connect(SERIEA_TABLE_URL).get();
        }
        // 리그앙
        else if (leagueId == LeagueUtil.LEGUE1) {
            document = Jsoup.connect(LIGUE1_TABLE_URL).get();
        }
        else {
            throw new NotFoundException("요청하신 리그가 없습니다.");
        }

        elements = document.getElementsByAttributeValue("id", "teamRankTabPanel_0");
        elements = elements.select("div.tmp_wrap div.scroll tbody tr");
        for (Element element : elements) {
            Elements contents = element.select("td");
            // 순위, 클럽 이름, 게임수, 이긴 횟수, 비긴 횟수, 진 횟수, 득점, 실점, 득실자, 승점을 각각 추출하여 Club 객체에 저장
            Club club = Club.builder()
                    .ranking(Integer.parseInt(element.select("th").text())) // 순위
                    .name(contents.get(0).select("p span a").text()) // 클럽 이름
                    .played(Integer.parseInt(contents.get(1).text())) // 경기 수
                    .points(Integer.parseInt(contents.get(2).text())) // 승점
                    .won(Integer.parseInt(contents.get(3).text())) // 승
                    .drawn(Integer.parseInt(contents.get(4).text())) // 무
                    .lost(Integer.parseInt(contents.get(5).text())) // 패
                    .goalsFor(Integer.parseInt(contents.get(6).text())) // 득점
                    .goalsAgainst(Integer.parseInt(contents.get(7).text())) // 실점
                    .goalsDifference(contents.get(8).text()) // 득실차
                    .build();

            clubs.add(club);
        }

        return new HashMap<String, Object>() {{
            put("table", clubs);
        }};
    }

    public Map<String, Object> getClubRankingOfLeague(Integer leagueId, String clubName) throws Exception {
        Document document;
        Elements elements;

        // 프리미어리그
        if (leagueId == LeagueUtil.PREMIERLEAGUE) {
            document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        }
        // 라리가
        else if (leagueId == LeagueUtil.LALIGA) {
            document = Jsoup.connect(LALIGA_TABLE_URL).get();
        }
        // 분데스리가
        else if (leagueId == LeagueUtil.BUNDESLIGA) {
            document = Jsoup.connect(BUNDESLIGA_TABLE_URL).get();
        }
        // 세리에 A
        else if (leagueId == LeagueUtil.SERIEA) {
            document = Jsoup.connect(SERIEA_TABLE_URL).get();
        }
        // 리그앙
        else if (leagueId == LeagueUtil.LEGUE1) {
            document = Jsoup.connect(LIGUE1_TABLE_URL).get();
        }
        else {
            throw new NotFoundException("요청하신 리그가 없습니다.");
        }

        elements = document.getElementsByAttributeValue("id", "teamRankTabPanel_0");
        elements = elements.select("div.tmp_wrap div.scroll tbody tr");
        for (Element element : elements) {
            Elements contents = element.select("td");
            String tempClubName = contents.get(0).select("p span a").text();
            // 선택한 리그에 clubName이 있으면
            if (tempClubName.equals(clubName)) {
                Club club = Club.builder()
                        .ranking(Integer.parseInt(element.select("th").text())) // 순위
                        .name(tempClubName) // 클럽 이름
                        .played(Integer.parseInt(contents.get(1).text())) // 경기 수
                        .points(Integer.parseInt(contents.get(2).text())) // 승점
                        .won(Integer.parseInt(contents.get(3).text())) // 승
                        .drawn(Integer.parseInt(contents.get(4).text())) // 무
                        .lost(Integer.parseInt(contents.get(5).text())) // 패
                        .goalsFor(Integer.parseInt(contents.get(6).text())) // 득점
                        .goalsAgainst(Integer.parseInt(contents.get(7).text())) // 실점
                        .goalsDifference(contents.get(8).text()) // 득실차
                        .build();

                return new HashMap<String, Object>() {{
                    put("ranking", club);
                }};
            }
        }

        throw new NotFoundException("요청하신 리그에 해당 팀이 없습니다.");
    }

    public Map<String, Object> getPlayersGoalRankingOfLeague(Integer leagueId, Integer categoryId) throws Exception {
        Document document;
        Elements elements;
        List<Player> players = new ArrayList<>();

        // 프리미어리그
        if (leagueId == LeagueUtil.PREMIERLEAGUE) {
            document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        }
        // 라리가
        else if (leagueId == LeagueUtil.LALIGA) {
            document = Jsoup.connect(LALIGA_TABLE_URL).get();
        }
        // 분데스리가
        else if (leagueId == LeagueUtil.BUNDESLIGA) {
            document = Jsoup.connect(BUNDESLIGA_TABLE_URL).get();
        }
        // 세리에 A
        else if (leagueId == LeagueUtil.SERIEA) {
            document = Jsoup.connect(SERIEA_TABLE_URL).get();
        }
        // 리그앙
        else if (leagueId == LeagueUtil.LEGUE1) {
            document = Jsoup.connect(LIGUE1_TABLE_URL).get();
        }
        else {
            throw new NotFoundException("요청하신 리그가 없습니다.");
        }

        // 1: 골, 2: 도움
        if (categoryId != 1 && categoryId != 2) {
            throw new NotFoundException("요청하신 카테고리가 없습니다.");
        }

        // 요청한 카테코리가 골이라면
        if (categoryId == 1) {
            elements = document.getElementsByAttributeValue("id", "playerRankTabPanel_0");
        }
        // 도움이라면
        else {
            elements = document.getElementsByAttributeValue("id", "playerRankTabPanel_1");
        }

        elements = elements.select("div.tmp_wrap div.scroll table.tb_type2 tbody tr");
        for (Element element : elements) {
            Elements contents = element.select("td");
            // 순위, 선수명, 팀명, 경기, 득점을 각각 추출하여 저장
            Player player = Player.builder()
                    .ranking(Integer.parseInt(element.select("th").text()))
                    .name(contents.get(0).select("a").text())
                    .clubName(contents.get(1).select("p span a").text())
                    .played(Integer.parseInt(contents.get(2).text()))
                    .build();

            if (categoryId == 1) {
                player.setGoals(Integer.parseInt(contents.get(3).text()));
            } else {
                player.setAssists(Integer.parseInt(contents.get(3).text()));
            }

            players.add(player);
        }

        return new HashMap<String, Object>() {{
            put("table", players);
        }};
    }
}
