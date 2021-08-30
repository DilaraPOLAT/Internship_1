package com.dilarasevimpolat.Municipality.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dilarasevimpolat.Municipality.entities.concretes.Agenda;

public interface AgendaDao extends JpaRepository<Agenda, Integer>{

}
