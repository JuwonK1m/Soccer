package com.kimjuwon.soccer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

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
}
