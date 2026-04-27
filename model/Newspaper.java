package model;

import java.time.LocalDate;

public class Newspaper extends Publication {
    private LocalDate editionDate;
    private String editorInChief;
    private boolean archived = false;

    public Newspaper(int id, String title, String author,
                     LocalDate publicationDate, String publisher, int pageCount,
                     LocalDate editionDate, String editorInChief) {

        super(id, title, author, publicationDate, publisher, pageCount);

        setEditionDate(editionDate);
        setEditorInChief(editorInChief);
    }

    // Display data
    @Override
    protected void displayInformation() {
        super.displayInformation();

        System.out.println("Edition Date: " + editionDate);
        System.out.println("Editor in Chief: " + editorInChief);
        System.out.println("Archived: " + (archived ? "Yes" : "No"));
        System.out.println("================================");
    }

    // Specific behaviors
    public void consultNews() {
        System.out.println("Listing main headlines...");
    }

    public void archiveEdition() {
        if (!archived) {
            archived = true;
            System.out.println("Edition archived.");
        } else {
            System.out.println("Edition is already archived.");
        }
    }

    // VALIDATIONS
    public void setEditionDate(LocalDate editionDate) {
        if (editionDate == null) {
            throw new IllegalArgumentException("Edition date cannot be null.");
        }
        this.editionDate = editionDate;
    }

    public void setEditorInChief(String editorInChief) {
        if (editorInChief == null || editorInChief.trim().isEmpty()) {
            throw new IllegalArgumentException("Editor in chief cannot be empty.");
        }
        this.editorInChief = editorInChief;
    }
}