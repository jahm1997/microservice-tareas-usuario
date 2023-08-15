package com.product.tareasmicroservice.Entity;

import org.springframework.data.annotation.Id;

public class TareaEntity {
	
	@Id
	private String id;
	private String title;
	private Boolean completed;
	private String usuarioId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public TareaEntity() {
		super();
	}

}
