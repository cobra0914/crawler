package com.cobra.thread;

import com.cobra.crawler.SimpleCrawler;
import com.cobra.entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by cobra on 2016/6/1.
 */
public class CrawlerBookUrlThread extends Thread {
    private List<?> part;

    public CrawlerBookUrlThread() {
    }

    public CrawlerBookUrlThread(List<?> part) {
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
                    Elements articleElements = doc.select("article");
                    if (articleElements != null && articleElements.size() > 0) {
                        for (Element articleElement : articleElements) {
                            String bookUrl = articleElement.select("h2 a").attr("href");
                            String bookName = articleElement.select("h2 a").text();
                            String authorUrl = articleElement.select("h5 a").attr("href");
                            String authorName = articleElement.select("h5 a").text();
                            String bookDesc = articleElement.select("p").text();
                            Book book = new Book(bookName, bookUrl, authorName, authorUrl, bookDesc);
                            SimpleCrawler.saveBook(book);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(pageUrl);
                    continue;
                }


            }


        }
    }


}
