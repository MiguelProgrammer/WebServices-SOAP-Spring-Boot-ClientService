package model;

import miguelprogrammer.CustomerDetail;

public class Custumer {

    private Integer id;
    private String nome;
    private String phone;
    private String email;

    public Custumer() {
    }

    public Custumer(Integer id, String nome, String phone, String email) {
        this.id = id;
        this.nome = nome;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Custumer toCustomer(CustomerDetail cd){
        return new Custumer(cd.getId(), cd.getName(), cd.getPhone(), cd.getEmail());
    }

    @Override
    public String toString() {
        return "Custumer{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
