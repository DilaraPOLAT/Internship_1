package com.dilarasevimpolat.Municipality.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dilarasevimpolat.Municipality.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{

}
