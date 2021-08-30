package com.dilarasevimpolat.Municipality.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "president")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (value = { "hibernateLazyInitializer", "handler"})
public class President {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	@PrimaryKeyJoinColumn
	private int presidentId;
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "resume")
	private String resume;
	
	@Column(name = "vision")
	private String vision;
	
	@Column(name = "mission")
	private String mission;

}
