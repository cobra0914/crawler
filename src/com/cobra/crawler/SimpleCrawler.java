package com.cobra.crawler;

import com.cobra.entity.Book;
import com.cobra.entity.BookInfo;
import com.cobra.entity.Category;
import com.cobra.thread.CrawlerBookInfoThread;
import com.cobra.thread.CrawlerBookUrlThread;
import com.cobra.util.DBUtil;
import com.cobra.util.ListCutter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by cobra on 2016/6/1.
 */
public class SimpleCrawler {
    public static void main(String[] args) throws Exception {
//        getCategories();
//        List<String> pageUrls = getPageUrls();
//        List<List<?>> list = ListCutter.cut(pageUrls, 60);
//        crawlerBookUrls(list);

        crawlerBookInfo();
//        List<String> bookUrls = getBookUrls();
//        Document doc = Jsoup.connect(bookUrls.get(0)).timeout(15000).get();
//        Elements bookInfoElements = doc.select(".download-links a");
//
//        String downloadUrl = bookInfoElements.first().attr("href");
//        String bookName = doc.select(".entry-header h1").text();
//        String bookSimpleDesc = doc.select(".entry-header h4").text();
//        String imgUrl = doc.select(".entry-header a").first().select("img").attr("src");
//        String authorUrl = doc.select(".entry-header dd a").first().attr("href");
//        String authorName = doc.select(".entry-header dd a").first().text();
//
//        String cUrl = doc.select(".entry-header dd a").last().attr("href");
//        String cName = doc.select(".entry-header dd a").last().text();
//
//
//        String isbn = doc.select(".entry-header .book-detail dl dd").get(1).text();
//        String year = doc.select(".entry-header .book-detail dl dd").get(2).text();
//        String pages = doc.select(".entry-header .book-detail dl dd").get(3).text();
//        String language = doc.select(".entry-header .book-detail dl dd").get(4).text();
//        String fileSize = doc.select(".entry-header .book-detail dl dd").get(5).text();
//        String fileFormat = doc.select(".entry-header .book-detail dl dd").get(6).text();


//        System.out.println(isbn + "\t" + year + "\t" + pages + "\t" + language + "\t" + fileSize + "\t" + fileFormat);


    }


    private static void crawlerBookInfo() {

        List<String> bookUrls = getBookUrls();
//        bookUrls.clear();
//        bookUrls.add("http://www.allitebooks.com/mdx-with-microsoft-sql-server-2008-r2-analysis-services-cookbook/");
//        bookUrls.add("http://www.allitebooks.com/introduction-to-design-patterns-in-c-with-qt-2nd-edition/");
//        bookUrls.add("http://www.allitebooks.com/javascript-unit-testing/");
//        bookUrls.add("http://www.allitebooks.com/ada-2012-rationale/");
//        bookUrls.add("http://www.allitebooks.com/python-web-development-with-django/");
//        bookUrls.add("http://www.allitebooks.com/cross-cultural-computing/");
//        bookUrls.add("http://www.allitebooks.com/windows-7-plain-simple/");
//        bookUrls.add("http://www.allitebooks.com/microsoft-system-center-configuration-manager-field-experience/");
//        bookUrls.add("http://www.allitebooks.com/beginning-t-sql-3rd-edition/");
//        bookUrls.add("http://www.allitebooks.com/cognitive-radio-technology/");
//        bookUrls.add("http://www.allitebooks.com/spring-mvc-beginners-guide/");
//        bookUrls.add("http://www.allitebooks.com/microsoft-dynamics-crm-2011-scripting-cookbook/");
//        bookUrls.add("http://www.allitebooks.com/getting-started-with-net-gadgeteer/");
//        bookUrls.add("http://www.allitebooks.com/scratch-for-kids-for-dummies/");
//        bookUrls.add("http://www.allitebooks.com/implementing-ssl-tls-using-cryptography-and-pki/");
//        bookUrls.add("http://www.allitebooks.com/windows-7-enterprise-desktop-support-technician/");
//        bookUrls.add("http://www.allitebooks.com/sams-teach-yourself-google-analytics-in-10-minutes/");
//        bookUrls.add("http://www.allitebooks.com/beginning-android-adk-with-arduino/");
//        bookUrls.add("http://www.allitebooks.com/voice-application-development-for-android/");
//        bookUrls.add("http://www.allitebooks.com/intel-galileo-essentials/");
//        bookUrls.add("http://www.allitebooks.com/swift-2-design-patterns/");
//        bookUrls.add("http://www.allitebooks.com/practical-php-and-mysql-website-databases/");
//        bookUrls.add("http://www.allitebooks.com/microsoft-dynamics-ax-2012-r2-services/");
//        bookUrls.add("http://www.allitebooks.com/just-spring-data-access/");
//        bookUrls.add("http://www.allitebooks.com/teaching-learning-based-optimization-algorithm/");
//        bookUrls.add("http://www.allitebooks.com/getting-started-with-laravel-4/");
//        bookUrls.add("http://www.allitebooks.com/windows-2000-commands-pocket-reference/");
//        bookUrls.add("http://www.allitebooks.com/moodle-e-learning-course-development-third-edition/");
//        bookUrls.add("http://www.allitebooks.com/android-sqlite-essentials/");
//        bookUrls.add("http://www.allitebooks.com/objective-c-fundamentals/");
//        bookUrls.add("http://www.allitebooks.com/hornetq-messaging-developers-guide/");

        List<List<?>> list = ListCutter.cut(bookUrls, 60);

        if (list != null && list.size() > 0) {
            for (List part : list) {
                Thread crawlerBookInfoThread = new CrawlerBookInfoThread(part);
                crawlerBookInfoThread.start();
            }
        }


//        System.out.println(bookUrls.size());


    }

    private static List<String> getBookUrls() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> bookUrls = new ArrayList<String>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select book_url from book";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bookUrls.add(rs.getString("book_url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, ps, rs);
        }
        return bookUrls;
    }

    private static void crawlerBookUrls(List<List<?>> list) {
        if (list != null && list.size() > 0) {
            for (List part : list) {
                Thread crawlerBookUrlThread = new CrawlerBookUrlThread(part);
                crawlerBookUrlThread.start();
            }
        }
    }

    private static List<String> getPageUrls() throws IOException {
        String homeUrl = "http://www.allitebooks.com/";
        Document doc = Jsoup.connect(homeUrl).get();
        String pageInfo = doc.select(".pages").text();
        int startPage = Integer.parseInt(pageInfo.split(" ")[0]);
        int endPage = Integer.parseInt(pageInfo.split(" ")[2]);
        List<String> pageUrls = new ArrayList<String>();
        for (int i = startPage + 1; i <= endPage; i++) {
            pageUrls.add(homeUrl + "page/" + i + "/");
        }
        pageUrls.add(0, homeUrl);
        return pageUrls;
    }

    private static void getCategories() throws IOException {
        Document doc = Jsoup.connect("http://www.allitebooks.com/").get();
        Element categoriesElement = doc.getElementById("menu-item-65");
        doc = Jsoup.parse(categoriesElement.html());
        categoriesElement = doc.getElementsByAttributeValue("title", "All Categories").first().nextElementSibling();
        doc = Jsoup.parse(categoriesElement.html());
        Elements elements = doc.select(".menu-item-has-children");
        if (elements != null && elements.size() > 0) {
            for (Element element : elements) {
                Element parentElement = element.children().first();
                String cUrl = parentElement.attr("href");
                String cName = parentElement.text();
                Category category = new Category(0, cName, cUrl);
                int cId = saveCategory(category);
                Elements subElements = element.children().last().select("a");
                if (subElements != null && subElements.size() > 0) {
                    for (Element sub : subElements) {
                        cUrl = sub.attr("href");
                        cName = sub.text();
                        Category subCategory = new Category(cId, cName, cUrl);
                        saveCategory(subCategory);
                    }
                }

            }
        }
    }

    private static Integer saveCategory(Category category) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer cId = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "insert into category (cpid,cname,curl) values(" + category.getcPid() + ",'" + category.getcName() + "','" + category.getcUrl() + "')";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int row = ps.executeUpdate();
            conn.commit();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cId = rs.getInt(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, ps, rs);
        }
        return cId;
    }

    public static void saveBook(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into book (book_name, book_url, author_name, author_url, book_desc) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookName());
            ps.setString(2, book.getBookUrl());
            ps.setString(3, book.getAuthorName());
            ps.setString(4, book.getAuthorUrl());
            ps.setString(5, book.getBookDesc());
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, ps, null);
        }
    }

    public static void saveBookInfo(BookInfo bookInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into book_info (download_url, book_name, book_simple_desc, img_url, author_url, author_name, curl, cname, isbn, year, pages, language, file_size, file_format) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, bookInfo.getDownloadUrl());
            ps.setString(2, bookInfo.getBookName());
            ps.setString(3, bookInfo.getBookSimpleDesc());
            ps.setString(4, bookInfo.getImgUrl());
            ps.setString(5, bookInfo.getAuthorUrl());


            ps.setString(6, bookInfo.getAuthorName());
            ps.setString(7, bookInfo.getcUrl());
            ps.setString(8, bookInfo.getcName());
            ps.setString(9, bookInfo.getIsbn());
            ps.setString(10, bookInfo.getYear());


            ps.setString(11, bookInfo.getPages());
            ps.setString(12, bookInfo.getLanguage());
            ps.setString(13, bookInfo.getFileSize());
            ps.setString(14, bookInfo.getFileFormat());

            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, ps, null);
        }
    }


}
