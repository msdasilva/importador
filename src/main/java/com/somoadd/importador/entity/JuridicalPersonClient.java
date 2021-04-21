package com.somoadd.importador.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Juridical")
public class JuridicalPersonClient extends Client {

    public JuridicalPersonClient() {
        super();
        super.setType("Juridical");
    }

    public JuridicalPersonClient(Long clientId,String socialReason) {
        super();
        super.setType("Juridical");
        super.setId(clientId);
        this.socialReason = socialReason;
    }

    public JuridicalPersonClient(Long clientId) {
        super();
        super.setType("Juridical");
        super.setId(clientId);
    }


    private String socialReason;
    private String cnpj;
    private String fantasyName;
    private String responsibleName;
    private String responsibleEmail;

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getResponsibleEmail() {
        return responsibleEmail;
    }

    public void setResponsibleEmail(String responsibleEmail) {
        this.responsibleEmail = responsibleEmail;
    }

}