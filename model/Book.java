package model;

import java.time.LocalDate;

public class Book extends Publication {
    private String genre;
    protected int edition;
    protected String isbn;
    protected String summary;
    private LocalDate loanDate;
    private LocalDate dueDate;

    public Book(int id, String title, String author,
                LocalDate publicationDate, String publisher, int pageCount,
                String genre, int edition, String isbn, String summary) {

        super(id, title, author, publicationDate, publisher, pageCount);

        this.genre = genre;
        this.edition = edition;
        setIsbn(isbn);
        setSummary(summary);
    }

    //Display data
    @Override
    protected void displayInformation() {
        super.displayInformation(); // reuse parent data

        System.out.println("Genre: " + genre);
        System.out.println("Edition: " + edition);
        System.out.println("ISBN: " + isbn);
        System.out.println("================================");
    }

    // Borrow book
    public void borrowBook() {
         if (getIsAvailable()) {
            setIsAvailable(false);
            loanDate = LocalDate.now();
            dueDate = loanDate.plusDays(7); // example: 7 days
            System.out.println("Book borrowed until: " + dueDate);
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    // Return book
    public void returnBook() {
        if (!getIsAvailable()) {
            setIsAvailable(true);
            loanDate = null;
            dueDate = null;
            System.out.println("Book returned successfully.");
        }
    }

    // Renew loan
    public void renewLoan() {
        if (!getIsAvailable() && dueDate != null) {
            dueDate = dueDate.plusDays(7);
            System.out.println("New due date: " + dueDate);
        }
    }

    // Get summary
    public String getSummary() {return summary;}

    // Check overdue
    public boolean isOverdue() {
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }

    // Calculate fine
    public double calculateFine(double dailyRate) {
        if (isOverdue()) {
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            return daysLate * dailyRate;
        }
        return 0;
    }   

    //VALIDATIONS
    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN must contain exactly 13 digits.");
        }
        this.isbn = isbn;
    }

    public void setSummary(String summary) {
        if (summary == null || summary.trim().isEmpty()) {
            throw new IllegalArgumentException("Summary cannot be empty.");
        }
        this.summary = summary;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }
        this.genre = genre;
    }

    public void setEdition(int edition) {
        if (edition <= 0) {
            throw new IllegalArgumentException("Edition must be greater than zero.");
        }
        this.edition = edition;
    }
}