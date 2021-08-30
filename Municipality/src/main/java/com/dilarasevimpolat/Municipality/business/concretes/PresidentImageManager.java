package com.dilarasevimpolat.Municipality.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dilarasevimpolat.Municipality.business.abstracts.PresidentImageService;
import com.dilarasevimpolat.Municipality.core.utilities.ImageService.ImageService;
import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.Result;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessDataResult;
import com.dilarasevimpolat.Municipality.core.utilities.results.SuccessResult;
import com.dilarasevimpolat.Municipality.dataAccess.abstracts.PresidentImageDao;
import com.dilarasevimpolat.Municipality.entities.concretes.PresidentImage;


@Service
public class PresidentImageManager implements PresidentImageService{
	
	
	private PresidentImageDao presidentImageDao;
	private ImageService imageService;
	
	@Autowired
	public PresidentImageManager(PresidentImageDao presidentImageDao,ImageService imageService) {
		super();
		this.presidentImageDao = presidentImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(PresidentImage presidentImage) {
		this.presidentImageDao.save(presidentImage);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<PresidentImage> presidentImages) {
		presidentImageDao.saveAll(presidentImages);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public Result add(PresidentImage PresidentImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        PresidentImage.setUrl(url);
        PresidentImage.setUploadedDate(LocalDateTime.now());
        return add(PresidentImage);
	}

	@Override
	public DataResult<List<PresidentImage>> getAll() {
		return new SuccessDataResult<>(this.presidentImageDao.findAll());
	}

	@Override
	public DataResult<List<PresidentImage>> getAllByPresidentId(int presidentId) {
		return new SuccessDataResult<>(this.presidentImageDao.getAllById(presidentId));
	}

}
