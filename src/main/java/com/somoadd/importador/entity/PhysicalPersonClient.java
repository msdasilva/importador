package com.somoadd.importador.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Physical")
public class PhysicalPersonClient extends Client{

    public PhysicalPersonClient(Long clientId){
        super();
        super.setId(clientId);
        super.setType("Physical");
    }
    public PhysicalPersonClient(Long clientId,String name){
        super();
        super.setType("Physical");
        super.setId(clientId);
        this.name=name;
    }

    public PhysicalPersonClient(String name) {
        super();
        super.setType("Physical");
        this.name = name;
    }

    public PhysicalPersonClient() {
        super();
        super.setType("Physical");
    }

    private String name;
    private String cpf;
    private String email;



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
