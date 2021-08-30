package com.dilarasevimpolat.Municipality.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dilarasevimpolat.Municipality.entities.concretes.Communication;

public interface CommunicationDao extends JpaRepository<Communication, Integer> {

}
