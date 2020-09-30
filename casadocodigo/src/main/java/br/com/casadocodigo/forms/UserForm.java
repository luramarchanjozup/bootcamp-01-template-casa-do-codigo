package br.com.casadocodigo.forms;
import br.com.casadocodigo.models.User;


public class UserForm {

    private String email;

    private String name;

    private String lastName;

    private String identification;

    private String address;

    private String complement;

    private String city;

    private String phone;

    private String cep;

    @Deprecated
    public UserForm(){};

    public User toEntity(){
        return new User(email,name, lastName, identification, address, complement, city, phone, cep);
    }

    public UserForm(String email, String name, String lastName, String identification, String address, String complement, String city, String country, String state, String phone, String cep) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.phone = phone;
        this.cep = cep;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
