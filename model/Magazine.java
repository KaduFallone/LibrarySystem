package model;

import java.time.LocalDate;

public class Magazine extends Publication {
    private String issn;
    private int issueNumber;
    private String publicationMonth;

    public Magazine(int id, String title, String author,
                    LocalDate publicationDate, String publisher, int pageCount,
                    String issn, int issueNumber, String publicationMonth) {

        super(id, title, author, publicationDate, publisher, pageCount);

        setIssn(issn);
        setIssueNumber(issueNumber);
        setPublicationMonth(publicationMonth);
    }

    // Display data
    @Override
    protected void displayInformation() {
        super.displayInformation();

        System.out.println("ISSN: " + issn);
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Publication Month: " + publicationMonth);
        System.out.println("================================");
    }

    // Example actions (similar to Book behavior style)
    public void consultArticles() {
        System.out.println("Listing main articles of the magazine...");
    }

    public void displayCover() {
        System.out.println("Displaying the magazine cover...");
    }

    // VALIDATIONS
    public void setIssn(String issn) {
        if (issn == null || !issn.matches("\\d{8}")) {
            throw new IllegalArgumentException("ISSN must contain exactly 8 digits.");
        }
        this.issn = issn;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be greater than zero.");
        }
        this.issueNumber = issueNumber;
    }

    public void setPublicationMonth(String publicationMonth) {
        if (publicationMonth == null || publicationMonth.trim().isEmpty()) {
            throw new IllegalArgumentException("Publication month cannot be empty.");
        }
        this.publicationMonth = publicationMonth;
    }
}