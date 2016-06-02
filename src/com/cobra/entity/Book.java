package com.cobra.entity;

/**
 * Created by cobra on 2016/6/1.
 */
public class Book {
    private int bookId;
    private String bookName;
    private String bookUrl;
    private String authorName;
    private String authorUrl;
    private String bookDesc;

    public Book() {
    }

    public Book(String bookName, String bookUrl, String authorName, String authorUrl, String bookDesc) {
        this.bookName = bookName;
        this.bookUrl = bookUrl;
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.bookDesc = bookDesc;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
}
