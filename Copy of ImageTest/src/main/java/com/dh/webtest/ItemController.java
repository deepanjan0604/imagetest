package com.dh.webtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




@RestController
public class ItemController {
	
	
	@Autowired
	ItemImageRepository itemImagerepository;

	
	
/*	@RequestMapping(value = "/upload")
	public HashMap<String, Object> handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException{
		
		File convertedFile=convert(file);
		System.out.println(convertedFile);
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		 
	        try {            
	            // Reading a Image file from file system
	            FileInputStream imageInFile = new FileInputStream(convertedFile);
	            byte imageData[] = new byte[(int) convertedFile.length()];
	            imageInFile.read(imageData);
	 
	            // Converting Image byte array into Base64 String
	            String imageDataString = encodeImage(imageData);
	            System.out.println(imageDataString);
	            String value = (imageDataString);
	            byte[] buff = value.getBytes();
	            Blob image = null;
				try {
					image = new SerialBlob(buff);
				} catch (SerialException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println(image);
	             byte[] imageByteArray = decodeImage(imageDataString);
	             System.out.println(imageByteArray);
	             ItemImage uploadFile = new ItemImage();
	             uploadFile.setImageId(1);
	           uploadFile.setUrl(image);
	           //uploadFile.setImageId(2);
	           uploadFile.setExtn("jpg");
	           itemImagerepository.save(uploadFile);
	            System.out.println("Image Successfully Manipulated!");
	        } catch (FileNotFoundException e) {
	            System.out.println("Image not found" + e);
	        } catch (IOException ioe) {
	            System.out.println("Exception while reading the Image " + ioe);
	        }
			return returnParams;
}
*/	
	

	@RequestMapping(value = "/upload")
	public HashMap<String, Object> handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException{
		File convertedFile=convert(file);
		System.out.println(convertedFile);
		
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		byte[] b = file.getBytes();
		String imageFile = StringUtils.newStringUtf8(Base64.encodeBase64(b));
		
		//String imageFile = base.toString();
		System.out.println(imageFile);
		/*
		String encodedBytes = Base64.encodeBase64String("file".getBytes());*/
	/*	//System.out.println("encodedBytes " + new String(encodedBytes));
	        // Reading a Image file from file system
          FileInputStream imageInFile = new FileInputStream(convertedFile);
		//BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			byte imageData[] = new byte[(int) convertedFile.length()];
			//imageInFile.read(imageData);
			// Converting Image byte array into Base64 String
			String imageDataString = encodeImage(imageData);
			System.out.println(imageDataString);
			String value = (imageDataString);
			byte[] buff = value.getBytes();
			Blob image = null;
			try {
				image = new SerialBlob(buff);
			} catch (SerialException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//System.out.println(image);
			System.out.println(value);
			 byte[] imageByteArray = decodeImage(imageDataString);
			 System.out.println(imageByteArray);*/
			 ItemImage uploadFile = new ItemImage();
			//uploadFile.setImageId(1);
		
		//String encodeBytes = (imageDataString);
		//byte[] buff = encodedBytes.getBytes();
        uploadFile.setUrl(imageFile);
         uploadFile.setImageId(2);
         uploadFile.setExtn("jpg");
         itemImagerepository.save(uploadFile);
			System.out.println("Image Successfully Manipulated!");
			return returnParams;
}
	
	@RequestMapping(value = "/display")
	public ItemImage getImage() {
		//System.out.println(itemImagerepository.findOne(1));
		return (ItemImage) itemImagerepository.findOne(1);
	}
	
	public static String encodeImage(byte[] imageData) {
        return Base64.encodeBase64String(imageData);
    }
 
  
    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }
    
    public File convert(MultipartFile file)
    {    
        File convFile = new File(file.getOriginalFilename());
        try {
			convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        fos.close();
        } catch (IOException e) {
			e.printStackTrace();
		}  
        return convFile;
    }
}
