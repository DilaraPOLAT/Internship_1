package com.dilarasevimpolat.Municipality.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dilarasevimpolat.Municipality.entities.concretes.President;

public interface PresidentDao extends JpaRepository<President, Integer>{

}
