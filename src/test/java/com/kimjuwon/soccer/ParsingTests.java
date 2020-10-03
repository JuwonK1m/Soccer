package com.kimjuwon.soccer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ParsingTests {
    private static String PREMIERLEAGUE_TABLE_URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8+%EC%88%9C%EC%9C%84&oquery=%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8+%EC%88%9C%EC%9C%84&tqi=U2y%2BVsprvTossFfa2twsssssst4-509654";
    private static String LALIGA_TABLE_URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EB%9D%BC%EB%A6%AC%EA%B0%80+%EC%88%9C%EC%9C%84&oquery=%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8+%EC%88%9C%EC%9C%84&tqi=U2za8wprvmsssjqJc8GssssstQV-127670";

    @Test
    void premierLeagueTableParsingTest() throws Exception {
        Document document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        Elements elements = document.getElementsByAttributeValue("id", "teamRankTabPanel_0");
        elements = elements.select("div.tmp_wrap div.scroll tbody tr");
        for (Element element : elements)
            System.out.println(element);
    }

    @Test
    void laligaTableParsingTest() throws Exception {
        Document document = Jsoup.connect(LALIGA_TABLE_URL).get();
        Elements elements = document.getElementsByAttributeValue("id", "teamRankTabPanel_0");
        elements = elements.select("div.tmp_wrap div.scroll tbody tr");
        for (Element element : elements)
            System.out.println(element);
    }

    @Test
    void playersGoalsTableParsingTest() throws Exception {
        Document document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        Elements elements = document.getElementsByAttributeValue("id", "playerRankTabPanel_0");
        elements = elements.select("div.tmp_wrap div.scroll table.tb_type2 tbody tr");

        for (Element element : elements) {
            Elements contents = element.select("td");
            Integer ranking = Integer.parseInt(element.select("th").text());
            String playerName = contents.get(0).select("a").text();
            String clubName = contents.get(1).select("p span a").text();
            Integer played = Integer.parseInt(contents.get(2).text());
            Integer goals = Integer.parseInt(contents.get(3).text());
            System.out.println("순위: " + ranking);
            System.out.println("선수: " + playerName);
            System.out.println("클럽: " + clubName);
            System.out.println("경기: " + played);
            System.out.println("골: " + goals);
            System.out.println("-------------------------------------");
        }
    }

    @Test
    void playersAssistsTableParsingTest() throws Exception {
        Document document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        Elements elements = document.getElementsByAttributeValue("id", "playerRankTabPanel_1");
        elements = elements = elements.select("div.tmp_wrap div.scroll table.tb_type2 tbody tr");

        for (Element element : elements) {
            Elements contents = element.select("td");
            Integer ranking = Integer.parseInt(element.select("th").text());
            String playerName = contents.get(0).select("a").text();
            String clubName = contents.get(1).select("p span a").text();
            Integer played = Integer.parseInt(contents.get(2).text());
            Integer assists = Integer.parseInt(contents.get(3).text());
            System.out.println("순위: " + ranking);
            System.out.println("선수: " + playerName);
            System.out.println("클럽: " + clubName);
            System.out.println("경기: " + played);
            System.out.println("도움: " + assists);
            System.out.println("-------------------------------------");
        }
    }
}
