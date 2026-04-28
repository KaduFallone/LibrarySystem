package app;

import model.Book;
import model.Magazine;
import model.Newspaper;
import model.Reader;
import controller.LibController;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LibController controller = new LibController();


        Book book = new Book(
            1, "Clean Code", "Robert C. Martin",
            LocalDate.of(2008, 8, 1), "Prentice Hall", 431,
            "Technology", 1, "9780132350884", "A guide to writing clean code."
        );

        Magazine magazine = new Magazine(
            2, "National Geographic", "Various Authors",
            LocalDate.of(2024, 1, 1), "National Geographic Society", 120,
            "12345678", 312, "January"
        );

        Newspaper newspaper = new Newspaper(
            3, "Folha de Sao Paulo", "Editorial Team",
            LocalDate.of(2024, 4, 27), "Grupo Folha", 24,
            LocalDate.of(2024, 4, 27), "Joao Silva"
        );


        Reader reader = new Reader(
            "Carlos Fallone",
            "carlos@gmail.com",
            "11999999999",
            "Rua das Flores, 123",
            "123.456.789-09"
        );


        System.out.println("\n======= REGISTERING PUBLICATIONS AND READER =======");
        controller.registerPublication(book);
        controller.registerPublication(magazine);
        controller.registerPublication(newspaper);
        controller.createReader(reader);


        System.out.println("\n======= AVAILABLE PUBLICATIONS =======");
        controller.listPublications();


        System.out.println("\n======= BORROWING PUBLICATIONS =======");
        controller.borrowPublication(book, reader);
        controller.borrowPublication(magazine, reader);
        controller.borrowPublication(newspaper, reader);


        System.out.println("\n======= READER'S BORROWED PUBLICATIONS =======");
        controller.displayReaderInfo(reader);


        System.out.println("\n======= ALL PUBLICATIONS - CURRENT STATUS =======");
        controller.listPublications();


        System.out.println("\n======= RETURNING ONE PUBLICATION =======");
        controller.returnPublication(book, reader);


        System.out.println("\n======= READER'S PUBLICATIONS AFTER RETURN =======");
        controller.displayReaderInfo(reader);


        System.out.println("\n======= ALL PUBLICATIONS - AFTER RETURN =======");
        controller.listPublications();
    }
}
