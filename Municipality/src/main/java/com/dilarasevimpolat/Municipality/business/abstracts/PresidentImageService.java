package com.dilarasevimpolat.Municipality.business.abstracts;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.entities.concretes.PresidentImage;


public interface PresidentImageService {
	Result add(PresidentImage presidentIImage);
	Result addAll(List<PresidentImage> presidentIImages);
	Result add(PresidentImage presidentIImage, MultipartFile file);

	DataResult<List<PresidentImage>> getAll();
	DataResult<List<PresidentImage>> getAllByPresidentId(int presidentId);

}
