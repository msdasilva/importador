package com.somoadd.importador.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EntityDatasource")
public class EntityDatasource extends AbstractBaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
    private EntityDs entity;

    @OneToOne
    private Datasource datasource;

    private String value;

    public EntityDs getEntity() {
        return entity;
    }

    public void setEntity(EntityDs entity) {
        this.entity = entity;
    }

    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
