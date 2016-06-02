package com.cobra.thread;

import com.cobra.crawler.SimpleCrawler;
import com.cobra.entity.BookInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by cobra on 2016/6/1.
 */
public class CrawlerBookInfoThread extends Thread {
    private List<?> part;

    public CrawlerBookInfoThread() {
    }

    public CrawlerBookInfoThread(List<?> part) {
        this.part = part;
    }

    @Override
    public void run() {
        if (part != null && part.size() > 0) {
            for (Object object : part) {
                String pageUrl = (String) object;


                Document doc = null;
                try {
                    doc = Jsoup.connect(pageUrl).timeout(15000).get();
                    Elements bookInfoElements = doc.select(".download-links a");

                    String downloadUrl = bookInfoElements.first().attr("href");
                    String bookName = doc.select(".entry-header h1").text();
                    String bookSimpleDesc = doc.select(".entry-header h4").text();
                    String imgUrl = doc.select(".entry-header a").first().select("img").attr("src");
                    String authorUrl = doc.select(".entry-header dd a").first().attr("href");
                    String authorName = doc.select(".entry-header dd a").first().text();

                    String cUrl = doc.select(".entry-header dd a").last().attr("href");
                    String cName = doc.select(".entry-header dd a").last().text();

                    String isbn = doc.select(".entry-header .book-detail dl dd").get(1).text();
                    String year = doc.select(".entry-header .book-detail dl dd").get(2).text();
                    String pages = doc.select(".entry-header .book-detail dl dd").get(3).text();
                    String language = doc.select(".entry-header .book-detail dl dd").get(4).text();
                    String fileSize = doc.select(".entry-header .book-detail dl dd").get(5).text();
                    String fileFormat = doc.select(".entry-header .book-detail dl dd").get(6).text();

                    BookInfo bookInfo = new BookInfo(downloadUrl, bookName, bookSimpleDesc, imgUrl, authorUrl, authorName, cUrl, cName, isbn, year, pages, language, fileSize, fileFormat);
                    SimpleCrawler.saveBookInfo(bookInfo);

                } catch (IOException e) {
                    System.out.println(pageUrl);
                    continue;
                }


            }
        }
    }


}
