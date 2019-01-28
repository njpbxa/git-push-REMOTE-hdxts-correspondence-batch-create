package com.cerner.hdxts.correspondence.transformation.dto;

import java.util.List;

import lombok.Data;

/**
 * TX Transformation Request with the map path and data for the transformation.
 * 
 */
@Data
public class TxTransformationRequest {

    private String mapPath;

    private List<MapData> mapInputs;

    /**
     * Validates the request for a map path and a non-null List of inputs. An
     * empty list is acceptable.
     * 
     * @return A boolean value indicating true for valid and false for invalid.
     */
    public boolean isValid() {

        if (mapPath == null || mapPath.equals(""))
            return false;
        if (mapInputs == null)
            return false;
        return true;
    }

	public String getMapPath() {
		return mapPath;
	}

	public void setMapPath(String mapPath) {
		this.mapPath = mapPath;
	}

	public List<MapData> getMapInputs() {
		return mapInputs;
	}

	public void setMapInputs(List<MapData> mapInputs) {
		this.mapInputs = mapInputs;
	}
}
