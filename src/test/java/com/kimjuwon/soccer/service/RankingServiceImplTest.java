package com.kimjuwon.soccer.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

class RankingServiceImplTest {
    private static String PREMIERLEAGUE_TABLE_URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8+%EC%88%9C%EC%9C%84&oquery=%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8+%EC%88%9C%EC%9C%84&tqi=U2y%2BVsprvTossFfa2twsssssst4-509654";

    @Test
    void getClubRankingOfLeague() throws Exception {
        Document document = Jsoup.connect(PREMIERLEAGUE_TABLE_URL).get();
        Elements elements = document.getElementsByAttributeValue("id", "teamRankTabPanel_0");
        elements = elements.select("div.tmp_wrap div.scroll tbody tr");
        for (Element element : elements) {
            Elements contents = element.select("td");
            String clubName = contents.get(0).select("p span a").text();
            System.out.println(clubName);
        }
    }
}