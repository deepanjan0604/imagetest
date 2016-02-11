package com.dh.webtest;

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
	
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name="image")
    private byte [] image;
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


}
