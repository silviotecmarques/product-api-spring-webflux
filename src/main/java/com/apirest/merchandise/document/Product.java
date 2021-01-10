package com.apirest.merchandise.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	
	public Product(String id, String name, String description, String value) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
	}
	
	
	@Id
	private String id;
	
	private String name;
	private String description;
	private String value;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}