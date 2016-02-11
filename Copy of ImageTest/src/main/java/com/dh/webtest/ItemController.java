package com.dh.webtest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ItemController {
	
	
	@Autowired
	ItemImageRepository itemImagerepository;
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public HashMap<String, Object> handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException{
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
	try{	
		if (!file.isEmpty()) {
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 File destination = new File("E:/project/springtechnologyprojects/productimages");// something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 ImageIO.write(src, "jpg", destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
	 }
		//itemImagerepository.save(itemImage);
		returnParams.put("status", true);
	}
	catch (Exception e) {
		returnParams.put("status", false);
		returnParams.put("msg", "Image Addition Failed!!!!!!");
	}

return returnParams;
	}
}
