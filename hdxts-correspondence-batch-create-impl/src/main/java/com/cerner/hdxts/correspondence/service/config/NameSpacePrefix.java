package com.cerner.hdxts.correspondence.service.config;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

/**
 * Used to provide the prefix for the provided Namespace URI
 * @author DS042009
 *
 */
public class NameSpacePrefix extends NamespacePrefixMapper
{

	private static final String ST_URI = "http://www.cerner.com/edi/correspondence/statements";
	private static final String ST_PREFIX = "st";
	private static final String MODEL_URI = "http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model";
	private static final String MODEL_PREFIX = "model";
	
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix)
	{
		if (ST_URI.equals(namespaceUri)) {
			return ST_PREFIX;
		}
		if (MODEL_URI.equals(namespaceUri)) {
			return MODEL_PREFIX;
		}
		return suggestion;
	}
}
