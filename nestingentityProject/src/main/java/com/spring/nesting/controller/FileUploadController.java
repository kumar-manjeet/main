package com.spring.nesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.nesting.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		
		try {
			
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must contain file");
		}
		if(file.getContentType().equals("image/jpeg")) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg content type is allowed");
		}
		
		// file upload code
		
		boolean uploadFile = fileUploadHelper.uploadFile(file);
		if(uploadFile) {
			return ResponseEntity.ok("file is successfully uploaded");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some went wrong: try after some time");
	}

}

