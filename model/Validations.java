package model;

public interface Validations {
    default boolean validateCpf(String cpf) {
        return false;
    }

    default boolean validateEmail(String email) {
        return false;
    }

    default boolean validateIsbn(String isbn) {
        return false;
    }

    default boolean validateIssn(String issn) {
        return false;
    }
}
