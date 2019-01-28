package com.cerner.hdxts.correspondence.transformation.dto;

import lombok.Data;

/**
 * The Data Object for an input or output to a map.
 * 
 */
@Data
public class MapData {

    /**
     * The id number of the input or output
     */
    private int id;

    /**
     * The data encoded in base64
     */
    private String base64Data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBase64Data() {
		return base64Data;
	}

	public void setBase64Data(String base64Data) {
		this.base64Data = base64Data;
	}
}
