package model;

import java.sql.Date;

public abstract class Publication {
    private int id;
    private String title;
    private String author;
    private Date publicationDate;
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
    public Date getPublicationDate(){
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

}