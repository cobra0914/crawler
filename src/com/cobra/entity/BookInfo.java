package com.cobra.entity;

/**
 * Created by cobra on 2016/6/1.
 */
public class BookInfo {
    private int bookInfoId;
    private String downloadUrl ;
    private String bookName;
    private String bookSimpleDesc ;
    private String imgUrl ;
    private String authorUrl ;
    private String authorName;
    private String cUrl ;
    private String cName;
    private String isbn;
    private String year ;
    private String pages ;
    private String language;
    private String fileSize;
    private String fileFormat ;

    public BookInfo(String downloadUrl, String bookName, String bookSimpleDesc, String imgUrl, String authorUrl, String authorName, String cUrl, String cName, String isbn, String year, String pages, String language, String fileSize, String fileFormat) {
        this.downloadUrl = downloadUrl;
        this.bookName = bookName;
        this.bookSimpleDesc = bookSimpleDesc;
        this.imgUrl = imgUrl;
        this.authorUrl = authorUrl;
        this.authorName = authorName;
        this.cUrl = cUrl;
        this.cName = cName;
        this.isbn = isbn;
        this.year = year;
        this.pages = pages;
        this.language = language;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    public int getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(int bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSimpleDesc() {
        return bookSimpleDesc;
    }

    public void setBookSimpleDesc(String bookSimpleDesc) {
        this.bookSimpleDesc = bookSimpleDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}
