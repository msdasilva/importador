package com.somoadd.importador.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "importador")
public class Importador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "facebook", nullable = false)
	private String facebook;
	
	@Column(name = "twitter", nullable = false)
	private String twitter;	
	
	@Column(name = "youtube", nullable = false)
	private String youtube;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	

	public Importador() {
		super();
	}

	public Importador(Long id, String facebook, String twitter, String youtube) {
		super();
		this.id = id;
		this.facebook = facebook;
		this.twitter = twitter;
		this.youtube = youtube;
	}
	
	public Importador(String facebook, String twitter, String youtube) {
		this.facebook = facebook;
		this.twitter = twitter;
		this.youtube = youtube;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Importador other = (Importador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
