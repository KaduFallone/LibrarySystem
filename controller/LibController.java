package controller;

import model.Publication;
import model.Reader;

public class LibController {

    private Publication[] publications = new Publication[10];
    private int publicationCount = 0;

    private Reader[] readers = new Reader[10];
    private int readerCount = 0;


    public void registerPublication(Publication pub) {
        publications[publicationCount] = pub;
        publicationCount++;
        System.out.println("\"" + pub.getTitle() + "\" registered successfully.");
    }


    public void createReader(Reader reader) {
        readers[readerCount] = reader;
        readerCount++;
        System.out.println("Reader \"" + reader.getName() + "\" registered successfully.");

        if (reader.getCpf().equals("Invalid CPF")) {
            System.out.println("  Warning: CPF is invalid and was not saved.");
        }

        if (reader.getEmail().equals("Invalid Email")) {
            System.out.println("  Warning: Email is invalid and was not saved.");
        }
    }
    

    public void borrowPublication(Publication pub, Reader reader) {
        if (!pub.getIsAvailable()) {
            System.out.println("\"" + pub.getTitle() + "\" is currently unavailable.");
            return;
        }

        pub.borrowBook();

        String currentBooks = reader.getPickedBooks();
        if (currentBooks == null || currentBooks.isEmpty()) {
            reader.setPickedBooks(pub.getTitle());
        } else {
            reader.setPickedBooks(currentBooks + ", " + pub.getTitle());
        }

        String currentQtd = reader.getBooksQtd();
        int newQtd;
        try {
            newQtd = Integer.parseInt(currentQtd) + 1;
        } catch (NumberFormatException e) {
            newQtd = 1;
        }
        reader.setBooksQtd(String.valueOf(newQtd));

        System.out.println("\"" + pub.getTitle() + "\" borrowed by " + reader.getName() + ".");
    }

    
    public void returnPublication(Publication pub, Reader reader) {
        if (pub.getIsAvailable()) {
            System.out.println("\"" + pub.getTitle() + "\" was not borrowed.");
            return;
        }

        pub.returnBook();

        String currentQtd = reader.getBooksQtd();
        int newQtd;
        try {
            newQtd = Integer.parseInt(currentQtd) - 1;
            if (newQtd < 0) {
                newQtd = 0;
            }
        } catch (NumberFormatException e) {
            newQtd = 0;
        }
        reader.setBooksQtd(String.valueOf(newQtd));

        String currentBooks = reader.getPickedBooks();
        if (currentBooks != null && !currentBooks.isEmpty()) {
            if (currentBooks.equals(pub.getTitle())) {
                reader.setPickedBooks("");
            } else {
                currentBooks = currentBooks.replace(pub.getTitle() + ", ", "");
                currentBooks = currentBooks.replace(", " + pub.getTitle(), "");
                reader.setPickedBooks(currentBooks);
            }
        }

        System.out.println("\"" + pub.getTitle() + "\" returned by " + reader.getName() + ".");
    }


    public void listPublications() {
        if (publicationCount == 0) {
            System.out.println("No publications registered in the library.");
            return;
        }

        System.out.println("\n========== AVAILABLE PUBLICATIONS ==========");
        boolean hasAvailable = false;
        for (int i = 0; i < publicationCount; i++) {
            if (publications[i].getIsAvailable()) {
                printPublicationInfo(publications[i]);
                hasAvailable = true;
            }
        }
        if (!hasAvailable) {
            System.out.println("No publications currently available.");
        }

        System.out.println("\n========= UNAVAILABLE PUBLICATIONS =========");
        boolean hasUnavailable = false;
        for (int j = 0; j < publicationCount; j++) {
            if (!publications[j].getIsAvailable()) {
                printPublicationInfo(publications[j]);
                hasUnavailable = true;
            }
        }
        if (!hasUnavailable) {
            System.out.println("All publications are currently available.");
        }

        System.out.println();
    }


    public void displayReaderInfo(Reader reader) {
        String qtd = reader.getBooksQtd();
        String picked = reader.getPickedBooks();

        System.out.println("\n========== READER INFORMATION ==========");
        System.out.println("  Name    : " + reader.getName());
        System.out.println("  CPF     : " + reader.getCpf());
        System.out.println("  Email   : " + reader.getEmail());
        System.out.println("  Phone   : " + reader.getPhone());
        System.out.println("  Address : " + reader.getAddress());

        if (qtd == null || qtd.isEmpty()) {
            System.out.println("  Qty     : 0");
        } else {
            System.out.println("  Qty     : " + qtd);
        }

        if (picked == null || picked.isEmpty()) {
            System.out.println("  Titles  : None");
        } else {
            System.out.println("  Titles  : " + picked);
        }

        System.out.println("=========================================\n");
    }


    private void printPublicationInfo(Publication pub) {
        System.out.println("  ID       : " + pub.getId());
        System.out.println("  Title    : " + pub.getTitle());
        System.out.println("  Author   : " + pub.getAuthor());
        System.out.println("  Publisher: " + pub.getPublisher());
        System.out.println("  Pages    : " + pub.getPageCout());

        if (pub.getIsAvailable()) {
            System.out.println("  Status   : Available");
        } else {
            System.out.println("  Status   : Unavailable");
        }

        System.out.println("  -------------------------------------");
    }
}
