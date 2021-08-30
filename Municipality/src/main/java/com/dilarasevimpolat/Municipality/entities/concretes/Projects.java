package com.dilarasevimpolat.Municipality.entities.concretes;

import java.util.Date;

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
@Table(name = "Project")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (value = { "hibernateLazyInitializer", "handler"})
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	@PrimaryKeyJoinColumn
	private int projectId;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "topic")
	private String topic;

	@Column(name="insert_date",columnDefinition = "Date default CURRENT_DATE")
	private Date insertDate;


}
