package com.dilarasevimpolat.Municipality.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dilarasevimpolat.Municipality.entities.concretes.Projects;

public interface ProjectDao extends JpaRepository<Projects, Integer>{

}
