package com.app.jpa.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JoinLibroAutorId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "libro_id")
	private long libroId;
	
	@Column(name = "autor_id")
	private long autorId;
	
	public JoinLibroAutorId() {}

	public JoinLibroAutorId(long libroId, long autorId) {
		this.libroId = libroId;
		this.autorId = autorId;
	}

	public long getLibroId() {
		return libroId;
	}

	public void setLibroId(long libroId) {
		this.libroId = libroId;
	}

	public long getAutorId() {
		return autorId;
	}

	public void setAutorId(long autorId) {
		this.autorId = autorId;
	}
	
}
