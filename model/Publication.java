package model;

import java.time.LocalDate;

public abstract class Publication {
    private int id;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String publisher;
    private int pageCount;
    private boolean isAvailable = true;//book will be available by default

    public Publication(int id, String title, String author,
                       LocalDate publicationDate, String publisher, int pageCount) {

        setTitle(title);
        setAuthor(author);
        setPublicationDate(publicationDate);
        setPageCount(pageCount);

        this.id = id;
        this.publisher = publisher;
    }
    
    //Getters - for reading 
    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public String getAuthor(){return this.author;}
    public LocalDate getPublicationDate(){return this.publicationDate;}
    public String getPublisher(){return this.publisher;}
    public int getPageCout(){return this.pageCount;}
    public boolean getIsAvailable(){return this.isAvailable;}

    //Setters - change values
    public void setIsAvailable(boolean newIsAvailable){this.isAvailable = newIsAvailable;}

     //Display data
    protected void displayInformation() {
        System.out.println("===== BOOK INFORMATION =====");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author(s): " + author);
        System.out.println("Publication Date: " + publicationDate);
        System.out.println("Publisher: " + publisher);
        System.out.println("Pages: " + pageCount);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Unavailable"));
        System.out.println("================================");
    }

    //VALIDATIONS
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author;
    }

    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be greater than zero.");
        }
        this.pageCount = pageCount;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        if (publicationDate == null) {
            throw new IllegalArgumentException("Publication date cannot be null.");
        }
        this.publicationDate = publicationDate;
    }
}