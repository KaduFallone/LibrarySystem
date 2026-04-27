package model;

import java.time.LocalDate;

public abstract class Publication {
    private int id;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String publisher;
    private int pageCount;
    private boolean isAvailable = true;//livro por padrão estará disponível
    

    //Getters - para leitura 
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public LocalDate getPublicationDate(){
        return this.publicationDate;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public int getPageCout(){
        return this.pageCount;
    }
    public boolean getIsAvaible(){
        return this.isAvailable;
    }

    //Setters - alterar valores
    public void setIsAvaible(boolean newIsAvaible){
        this.isAvailable = newIsAvaible;
    }

     //Exibir dados
    protected void displayInformation() {
        System.out.println("===== INFORMAÇÕES DO LIVRO =====");
        System.out.println("ID: " + id);
        System.out.println("Título: " + title);
        System.out.println("Autor(es): " + author);
        System.out.println("Publicação: " + publicationDate);
        System.out.println("Editora: " + publisher);
        System.out.println("Páginas: " + pageCount);
        System.out.println("Disponibilidade: " + (isAvailable ? "Disponível" : "Indisponível"));
        System.out.println("================================");
    }

    //VALIDAÇÕES
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.title = title;
    }
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor não pode ser vazio.");
        }
        this.author = author;
    }
    
    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
        }
        this.pageCount = pageCount;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        if (publicationDate == null) {
            throw new IllegalArgumentException("A data de publicação não pode ser nula.");
        }
        this.publicationDate = publicationDate;
    }
}