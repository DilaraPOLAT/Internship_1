package com.dilarasevimpolat.Municipality.core.utilities.ImageService;


import org.springframework.web.multipart.MultipartFile;

import com.dilarasevimpolat.Municipality.core.utilities.results.DataResult;

public interface ImageService {
	 DataResult<?> save(MultipartFile file);
}
