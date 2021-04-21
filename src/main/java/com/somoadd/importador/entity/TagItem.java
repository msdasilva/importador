package com.somoadd.importador.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TagItem {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Tag tag;

	public TagItem() {
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
