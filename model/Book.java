package model;

import java.time.LocalDate;

public class Book extends Publication {
    protected String genre;
    protected int edition;
    protected String isbn;
    protected String summary;
    private LocalDate loanDate;
    private LocalDate dueDate;

    //Exibir dados
    @Override
    protected void displayInformation() {
        super.displayInformation(); // reaproveita o que já existe

        System.out.println("Gênero: " + genre);
        System.out.println("Edição: " + edition);
        System.out.println("ISBN: " + isbn);
        System.out.println("================================");
    }
    // Emprestar livro
    public void borrowBook() {
         if (getIsAvaible()) {
            setIsAvaible(false);
            loanDate = LocalDate.now();
            dueDate = loanDate.plusDays(7); // ex: 7 dias
            System.out.println("Livro emprestado até: " + dueDate);
        } else {
            System.out.println("Livro já está emprestado.");
        }
    }

    // Devolver livro
    public void returnBook() {
        if (!getIsAvaible()) {
            setIsAvaible(true);
            loanDate = null;
            dueDate = null;
            System.out.println("Livro devolvido com sucesso.");
        }
    }

    // Renovar empréstimo
    public void renewLoan() {
        if (!getIsAvaible() && dueDate != null) {
            dueDate = dueDate.plusDays(7);
            System.out.println("Novo prazo: " + dueDate);
        }
    }

    // Consultar resumo
    public String getSummary() {
        return summary;
    }

    //Verificar atraso
    public boolean isOverdue() {
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }

    //Calcular multa por atraso
    public double calculateFine(double dailyRate) {
        if (isOverdue()) {
            long daysLate = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
            return daysLate * dailyRate;
        }
        return 0;
    }

    //VALIDAÇÕES
    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN deve conter exatamente 13 dígitos.");
        }
        this.isbn = isbn;
    }
    public void setSummary(String summary) {
        if (summary == null || summary.trim().isEmpty()) {
            throw new IllegalArgumentException("Resumo não pode ser vazio.");
        }
        this.summary = summary;
    }
}
