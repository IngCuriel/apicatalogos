package com.curiel.catalogos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class FileUpload implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=1000)
	private Long  id;
	 @Column(length=1000)
    private String nombreReal;
    @Column(length=1000)
    private String nombreCreado;
    @Column(length=10000)
    private String data;
}
