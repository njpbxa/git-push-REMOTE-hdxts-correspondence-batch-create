package com.cerner.hdxts.correspondence.transformation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * General exception with the TX Transformation Extender engine.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TxTransformationServiceException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1053293573589004540L;

    public TxTransformationServiceException(Throwable e) {
        super(e);
    }

    public TxTransformationServiceException(String msg) {
        super(msg);
    }

}
