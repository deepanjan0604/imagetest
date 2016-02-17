package com.dh.webtest;

import java.sql.Blob;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "itemimages")
public class ItemImage {

	@Id
	@Column(name="ImageId")
	@GeneratedValue
	private Integer imageId;//id   
	
	
	  @Column(name="url")
	    @Lob
	    private String url;
	  
	  @Column(name="extn")
	    private String extn;

	public Integer getImageId() {
		return imageId;
	}


	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String imageFile) {
		this.url = imageFile;
	}


	public String getExtn() {
		return extn;
	}


	public void setExtn(String extn) {
		this.extn = extn;
	}





	
}
