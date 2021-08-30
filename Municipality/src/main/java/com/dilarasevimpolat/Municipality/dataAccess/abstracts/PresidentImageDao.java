package com.dilarasevimpolat.Municipality.dataAccess.abstracts;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dilarasevimpolat.Municipality.entities.concretes.PresidentImage;

public interface PresidentImageDao extends JpaRepository<PresidentImage, Integer> {
	List<PresidentImage> getAllById(int presidentId);
	List<PresidentImage> getById(int presidentId);

}
