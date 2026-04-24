package model;

public class Book extends Publication {
    protected String genre;
    protected int edition;
    protected String isbn;
    protected String summary;

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
    public void emprestar() {
        if (getIsAvaible()) {
            setIsAvaible(false);
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro já está emprestado.");
        }
    }

    // Devolver livro
    public void devolver() {
        if (!getIsAvaible()) {
            setIsAvaible(true);
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("O livro já está disponível.");
        }
    }

    // Renovar empréstimo
    public void renovarEmprestimo() {
        if (!getIsAvaible()) {
            System.out.println("Empréstimo renovado com sucesso.");
        } else {
            System.out.println("Não é possível renovar um livro disponível.");
        }
    }

    // Consultar resumo
    public String consultarResumo() {
        return summary;
    }
}
