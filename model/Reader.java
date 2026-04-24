package model;

public class Reader implements Validation {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String cpf;
    private String pickedBooks;
    private String booksQtd;

    //Reader contructor 
    public Reader
    (
        String name, String email, 
        String phone, String address, 
        String cpf
    ){
        
        this.name = name;

        //Valdating if email is valid, if not, it will be set as "Invalid Email"
        if(validateEmail(email)){
            this.email = email;
        }
        else{
            this.email = "Invalid Email";
        }

        this.phone = phone;
        this.address = address;

        //Validating if cpf is valid, if not, it will be set as "Invalid CPF"
        if(validateCpf(cpf)){
            this.cpf = cpf;
        }
        else{
            this.cpf = "Invalid CPF";
        }
    }

    //Set Methods
    public void setPickedBooks(String pickedBooks) {
        this.pickedBooks = pickedBooks;
    }

    public void setBooksQtd(String booksQtd) {
        this.booksQtd = booksQtd;
    }

    //Get Methods
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPickedBooks() {
        return pickedBooks;
    }

    public String getBooksQtd() {
        return booksQtd;
    }

    @Override
    public boolean validateCpf(String cpf) {
        // Remove all points and dashes from the CPF string
        String cleanCpf = cpf.replace(".", "")
                             .replace("-", "")
                             .replace("\\D", "");
        
        // Verify if the cleaned CPF has exactly 11 digits
        if(cleanCpf.length() == 11){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean validateEmail(String email) {
        if(
            email.contains("@") && email.contains(".com") && 
            (email.contains("gmail") || email.contains("yahoo") || 
            email.contains("outlook") || email.contains("hotmail"))
        ){
            return true;
        }
        else{
            return false;
        }
    }

}