package com.cerner.hdxts.correspondence.service.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cerner.hdxts.correspondence.entities.common.FlatFile;

@Component
public class FileUtil 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public boolean appendFlatFile(FlatFile flatFile) throws IOException
	{
		Writer writer = null;
		FileOutputStream fileOutputStream = null;
		try 
		{
			LOGGER.debug("Dir path: {}", flatFile.getDirectoryPath());
			LOGGER.debug("File separator: {}",FILE_SEPARATOR);
			File file = new File(flatFile.getDirectoryPath() + FILE_SEPARATOR + flatFile.getFileName());
			// if file doesnt exists, then create it
			if (!file.exists() && flatFile.getCreateFileIfNotExists()) 
			{
				file.createNewFile();
			}

			// true = append file
			fileOutputStream = new FileOutputStream(file, true);
			writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF8"));

			writer.write(flatFile.getContent());
			return true;
		} 
		catch (IOException e) 
		{
			LOGGER.error("Caught IO Exception in FileUtil.appendFlatFile, Reason: {}",e.getMessage());
			throw e;
		} 
		finally 
		{
			try 
			{
				if (writer != null)
					writer.close();

				if (fileOutputStream != null)
					fileOutputStream.close();
			} 
			catch (IOException ex)
			{
				LOGGER.error("Caught IO Exception while closing the connection in FileUtil.appendFlatFile, Reason: {}",ex.getMessage());
			}
		}
	}

	public boolean createFlatFile(FlatFile flatFile) throws IOException
	{
		Writer writer = null;
		FileOutputStream fileOutputStream = null;
		try 
		{
			LOGGER.debug("Dir path: {}", flatFile.getDirectoryPath());
			LOGGER.debug("File separator: {}",FILE_SEPARATOR);
			File file = new File(flatFile.getDirectoryPath() + FILE_SEPARATOR + flatFile.getFileName());
			file.createNewFile();

			// true = append file
			fileOutputStream = new FileOutputStream(file);
			writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF8"));

			writer.write(flatFile.getContent());
			return true;
		} 
		catch (IOException e) 
		{
			LOGGER.error("Caught IO Exception in FileUtil.appendFlatFile, Reason: {}",e.getMessage());
			throw e;
		} 
		finally 
		{
			try 
			{
				if (writer != null)
					writer.close();

				if (fileOutputStream != null)
					fileOutputStream.close();
			} 
			catch (IOException ex)
			{
				LOGGER.error("Caught IO Exception while closing the connection in FileUtil.appendFlatFile, Reason: {}",ex.getMessage());
			}
		}
	}

	public String removeTMPExt(FlatFile flatFile) throws Exception
	{
		String directory = "";
		String filename = "";
		String fullname = "";
		String newname = "";
		try
		{
			filename = flatFile.getFileName();
			directory = flatFile.getDirectoryPath();

			LOGGER.info("directory = " + directory);
			LOGGER.info("filename = " + filename);

			fullname = directory + FILE_SEPARATOR + filename;

			int index = filename.indexOf(".TMP");
			if (index != -1)
			{
				String fileNameWithoutTMP = filename.substring(0, index);
				
				newname = directory + FILE_SEPARATOR + fileNameWithoutTMP;
				File originalFile = new File(fullname);

				LOGGER.info("Renaming file: from " + fullname + " to " + newname );
				originalFile.renameTo(new File(newname));
				return fileNameWithoutTMP;
			}           
			else
			{
				LOGGER.warn(filename + "has no .TMP extension");
				return filename;
			}
		}
		catch (Exception e)
		{
			throw new Exception("Error renaming file: from "+ fullname + " to " + newname+ " - " + e.getMessage(), e);
		}
	}

	public boolean deleteTempFile(FlatFile flatFile) throws Exception
	{
		String directory = "";
		String filename = "";
		String fullname = "";
		String newname = "";
		try
		{
			filename = flatFile.getFileName();
			directory = flatFile.getDirectoryPath();

			LOGGER.info("directory = {}", directory);
			LOGGER.info("filename = {}", filename);

			if(filename == null || filename.trim().length() == 0) 
			{
				LOGGER.error("filename is empty, tempFilenamePath {}",filename);
				throw new Exception("Missing filename: "+ filename);
			}
			if(directory == null || directory.trim().length() == 0) 
			{
				LOGGER.error("directory path is empty, tempFilenameDirectory {}",directory);
				throw new Exception("Missing directory: " + directory);
			}

			String fullFilename = directory.concat(FILE_SEPARATOR.concat(filename));
			LOGGER.info("Deleting file: {}", fullFilename);
			FileUtils.deleteQuietly(new File(fullFilename));
			return true;
		}
		catch (Exception e)
		{
			throw new Exception("Error renaming file: from "+ fullname + " to " + newname+ " - " + e.getMessage(), e);
		}
	}

	public String retrieveFlatFile(FlatFile flatFile)
	{
		String directory = "";
		String filename = "";
		String fileContent = null;
		BufferedReader br = null;
		FileInputStream fileInputStream = null;
		try
		{
			filename = flatFile.getFileName();
			directory = flatFile.getDirectoryPath();

			LOGGER.info("directory = {}", directory);
			LOGGER.info("filename = {}", filename);

			if(filename == null || filename.trim().length() == 0) 
			{
				LOGGER.error("filename is empty, tempFilenamePath {}",filename);
				throw new Exception("Missing filename: "+ filename);
			}
			if(directory == null || directory.trim().length() == 0) 
			{
				LOGGER.error("directory path is empty, tempFilenameDirectory {}",directory);
				throw new Exception("Missing directory: " + directory);
			}
			String fullFilename = directory.concat(FILE_SEPARATOR.concat(filename));
			LOGGER.info("Deleting file: {}", fullFilename);
			File file = new File(fullFilename);
			fileInputStream = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fileInputStream.read(data);
			fileInputStream.close();
			fileContent = new String(data, "UTF-8");
		}
		catch(Exception e)
		{
			LOGGER.error("Error reading the file, Reason: {}", e.getMessage());
		}
		finally
		{
			if(fileInputStream != null)
			{
				try 
				{
					fileInputStream.close();
				} 
				catch (IOException e) 
				{
					LOGGER.error("Closing the file reader connection, Reason: {}", e.getMessage());
				}
			}
			if(br != null)
			{
				try 
				{
					br.close();
				} 
				catch (IOException e) 
				{
					LOGGER.error("Closing the buffer reader connection, Reason: {}", e.getMessage());
				}
			}
		}

		return fileContent;
	}

}
