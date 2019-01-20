package com.bookstore.listview;

class Book {
    // Book instance variables
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private double price;
    private String coverUrl;

    // Book Constructor method
    public Book(int id, String title, String author, String isbn, int year, double price, String coverUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
        this.coverUrl = coverUrl;
    }

    // Get and set methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getCoverUrl() { return coverUrl; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

//    public String getImageURL() { return "https://islandpress.org/sites/default/files/400px%20x%20600px-r01BookNotPictured.jpg"; }
}
