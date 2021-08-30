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
@Table(name = "communication")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (value = { "hibernateLazyInitializer", "handler"})
public class Communication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	@PrimaryKeyJoinColumn
	private int communicationId;

	@Column(name = "address")
	private String address;
	
	@Column(name ="e_posta")
	private String e_posta;
	
	@Column(name ="phone_number")
	private String phonenumber;


}
