package com.dh.webtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageTestApplication implements CommandLineRunner{

	@Autowired
	ItemImageRepository imageRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ImageTestApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println((ItemImage) imageRepository.findOne(1));
		
	}
}
