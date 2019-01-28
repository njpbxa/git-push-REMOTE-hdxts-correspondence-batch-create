package com.cerner.hdxts.correspondence.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BatchNameUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchNameUtil.class);

    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>()
    {
        @Override
        public SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyyMMdd_hhmmss");
        }
    };

    // submitterId-service_cdf-type-sourceName.ext
    public static final Pattern FILENAME_PATTERN = Pattern.compile("^([\\w]+)-([\\w]+)-([\\w]+)-([\\w]+)-([\\w]+).([\\w]+)$");

    public static String createNewFilename(String oldFilename, String groupId)
    {
        String newFileName = getSubmitterId(oldFilename) + "_" + groupId + "." + getExtension(oldFilename);
        
        LOGGER.info("createNewFilename - New file name " + newFileName + " has been created based on name " + oldFilename + " and groupId " + groupId);
        
        return newFileName;
    }

    // add .TMP to extension so that creatd file will not be picked up by batch route during the process of copying, untill after the file get renamed back to original extension
    public static String createNewFilenameWithTMPExtension(String oldFilename, String groupId)
    {
        String newFileName = createNewFilename(oldFilename, groupId) + ".TMP";;

        LOGGER.info("createNewFilenameWithTMPExtension - New file name " + newFileName + " has been created based on name " + oldFilename + " and groupId " + groupId);

        return newFileName;
    }    

    // remove the .TMP extension so that file can be picked up by batch route
    public static String removeTMPExtension(String filename)
    {
        LOGGER.info("removeTMPExtension from " + filename);

        int index = filename.indexOf(".TMP");
        if (index != -1)
        {
            filename = filename.substring(0, index);
        }            
        else
        {
            LOGGER.warn(filename + "has no .TMP extension");
        }
        
        return filename;
    }    
    
    public static String getSubmitterId(String filename)
    {
        return getGroup(filename, 1);
    }

    public static String getServiceCdf(String filename)
    {
        return getGroup(filename, 2);
    }

    public static String getType(String filename)
    {
        return getGroup(filename, 3);
    }
    
    public static String getBatchId(String filename)
    {
        return getGroup(filename, 4);
    }  
    
    public static String getSourceName(String filename)
    {
        return getGroup(filename, 5);
    }  

    public static String getExtension(String filename)
    {
        return getGroup(filename, 6);
    }

    public static String createErrorFilename(String detail)
    {
        return DATE_FORMAT.get().format(new Date()).concat("_").concat(detail).concat(".ERROR");
    }

    static String getGroup(String filename, int index)
    {
        Matcher matcher = FILENAME_PATTERN.matcher(filename);
        if (!matcher.matches())
        {
            throw new IllegalStateException("Filename does not match expected pattern: " + filename);
        }
        return matcher.group(index);
    }
}