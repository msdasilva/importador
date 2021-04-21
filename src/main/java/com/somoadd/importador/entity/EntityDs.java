package com.somoadd.importador.entity;

import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Entity")

public class EntityDs extends AbstractBaseEntity {

    public EntityDs() {

    }

    public EntityDs(@NotBlank @Size(max = 60) String name) {
        this.name = name;
    }

    public EntityDs(long id, String name) {
        super();
        super.setId(id);
        this.name = name;
    }

    public EntityDs(long id, @NotBlank @Size(max = 60) String name, String uF, Calendar lastCaptureDate, LocalDateTime createdAt, String entityType, String email,String urlFoto,String siglaPartido,String intencaoVoto) {
        super();
        super.setId(id);
        this.name = name;
        this.UF = uF;
        this.lastCaptureDate = lastCaptureDate;
        this.setCreatedAt(createdAt);
        this.entityType = entityType;
        this.email=email;
        this.urlFoto=urlFoto;
        this.siglaPartido = siglaPartido;
        this.intencaoVoto = intencaoVoto;
    }

    public EntityDs(long id, @NotBlank @Size(max = 60) String name, String uF, Calendar lastCaptureDate,long datasetId,String datasetName) {
        super();
        super.setId(id);
        this.name = name;
        this.UF = uF;
        this.lastCaptureDate = lastCaptureDate;
        this.setDatasetList(Arrays.asList(new DataSet(datasetId,datasetName)));
    }

    public EntityDs(long id, @NotBlank @Size(max = 60) String name, String uF, Calendar lastCaptureDate) {
        super();
        super.setId(id);
        this.name = name;
        this.UF = uF;
        this.lastCaptureDate = lastCaptureDate;

    }

    public EntityDs(long id, @NotBlank @Size(max = 60) String name, String uF, Calendar lastCaptureDate, long datasetId, String datasetName, String hierarchyName, long hierarchyId) {
        super();
        super.setId(id);
        this.name = name;
        this.UF = uF;
        this.lastCaptureDate = lastCaptureDate;
        this.setDatasetList(Arrays.asList(new DataSet(datasetId,datasetName)));
        this.setHierarchies(Arrays.asList(new Hierarchy(hierarchyId,hierarchyName)));
    }

    public EntityDs(long id, @NotBlank @Size(max = 60) String name, String facebook, String twitter, String youtube,
                    String instagram, String blog, String uF, Calendar lastCaptureDate,Collection<Hierarchy> hierarchies) {
        super();
        super.setId(id);
        this.name = name;
        this.UF = uF;
        this.lastCaptureDate = lastCaptureDate;
        this.setHierarchies(hierarchies);
    }

    private static final long serialVersionUID = 1L;

    private String intencaoVoto;

    private String siglaPartido;

    @NotBlank
    @Size(max = 60)
    private String name;

    private String entityType;

    private String UF;

    private Calendar lastCaptureDate;

    private String email;

    private String uri;

    private String urlFoto;

    private Boolean verifiedApi;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<DataSet> DatasetList;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Hierarchy> hierarchies;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<EntityDatasource> entityDatasource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataSet> getDatasetList() { return DatasetList; }

    public void setDatasetList(List<DataSet> datasetList) {
        DatasetList = datasetList;
    }

    public Collection<Hierarchy> getHierarchies() { return hierarchies; }

    public void setHierarchies(Collection<Hierarchy> hierarchies) {
        this.hierarchies = hierarchies;
    }

//    public List<Datasource> getDatasource() {
//        return datasource;
//    }
//
//    public void setDatasource(List<Datasource> datasource) {
//        this.datasource = datasource;
//    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Calendar getLastCaptureDate() {
        return lastCaptureDate;
    }

    public void setLastCaptureDate(Calendar lastCaptureDate) {
        this.lastCaptureDate = lastCaptureDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIntencaoVoto() {
        return intencaoVoto;
    }

    public void setIntencaoVoto(String intencaoVoto) {
        this.intencaoVoto = intencaoVoto;
    }

    public Boolean getVerifiedApi() {
        return verifiedApi;
    }

    public void setVerifiedApi(Boolean verifiedApi) {
        this.verifiedApi = verifiedApi;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public List<EntityDatasource> getEntityDatasource() {
        return entityDatasource;
    }

    public void setEntityDatasource(List<EntityDatasource> entityDatasource) {
        this.entityDatasource = entityDatasource;
    }
}