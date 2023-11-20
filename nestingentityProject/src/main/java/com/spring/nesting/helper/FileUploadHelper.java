package com.spring.nesting.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UPLOAD_DIR = "/Users/manjeetyadav/Desktop/BoootProject/nestingentityProject/src/main/resources/static/image";

//	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean file = true;
		try {
//			InputStream is = multipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
//			file = true;

			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			file = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return file;
	}
}  
