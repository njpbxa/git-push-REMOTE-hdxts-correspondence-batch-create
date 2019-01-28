package com.cerner.hdxts.correspondence.service.util.test;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.hdxts.correspondence.entities.common.FlatFile;
import com.cerner.hdxts.correspondence.service.util.FileUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestFileUtil {

	FlatFile flatFile = new FlatFile();
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	
	@InjectMocks
	FileUtil fileUtil;
	@Before
	public void SetUp()
	{
		flatFile.setDirectoryPath("src\\main\\resources");
		flatFile.setFileName("fileName.TMP");
		flatFile.setContent("content");
		flatFile.setCreateFileIfNotExists(true);
	}
	
	@Test(expected=IOException.class)
	public void TestAppendFlatFile() throws IOException
	{
		Boolean returnValue = fileUtil.appendFlatFile(flatFile);
		assertEquals(returnValue,true);
		File file = new File(flatFile.getDirectoryPath() + "\\" + flatFile.getFileName());
		file.delete();
	}
	
	
	@Test
	public void TestCreateFlatFileWithException()
	{
		flatFile.setDirectoryPath(null);
		flatFile.setFileName(null);
		try {
			Boolean returnValue = fileUtil.createFlatFile(flatFile);
		} catch (IOException e) {
			String expected = "No such file or directory";//"The system cannot find the path specified";
			assertEquals(expected,e.getMessage());
		}
		
	}
	
	@Test(expected=IOException.class)
	public void TestCreateFlatFile() throws IOException
	{
		
		Boolean returnValue = fileUtil.createFlatFile(flatFile);
		System.out.println(returnValue);
		assertEquals(returnValue,true);
	}
	
	@Test
	public void TestRemoveTMPExtThrowingException()
	{
		flatFile.setFileName(null);
		String fileName;
		try {
			fileName = fileUtil.removeTMPExt(flatFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			String expected = "Error renaming file: from src\\main\\resources"+FILE_SEPARATOR+"null to  - null";
			assertEquals(expected,e.getMessage());
			
		}
		
	}
	@Test
	public void TestRemoveTMPExtWithTheExtension() throws Exception
	{
		String fileName = fileUtil.removeTMPExt(flatFile);
		assertEquals(fileName,"fileName");
	}
	@Test
	public void TestRemoveTMPExtWithoutTheExtension() throws Exception
	{
		flatFile.setFileName("fileName");
		String fileName = fileUtil.removeTMPExt(flatFile);
		assertEquals(fileName,flatFile.getFileName());
	}
	
	@Test
	public void TestDeleteTempFileWithExceptionNoFileName()
	{
		flatFile.setFileName(null);
		try {
			Boolean returnValue=fileUtil.deleteTempFile(flatFile);
		} catch (Exception e) {
			String expected = "Error renaming file: from  to  - Missing filename: null";
			assertEquals(expected,e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestDeleteTempFileWithExceptionNoDirectoryPath()
	{
		flatFile.setDirectoryPath(null);
		try {
			Boolean returnValue=fileUtil.deleteTempFile(flatFile);
		} catch (Exception e) {
			String expected = "Error renaming file: from  to  - Missing directory: null";
			assertEquals(expected,e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void TestDeleteTempFile() throws Exception
	{
		Boolean returnValue=fileUtil.deleteTempFile(flatFile);
		assertEquals(returnValue,true);
	}
	
	//@Test
	public void TestRetrieveFlatFileWithExceptionNoFileName()
	{
		
			flatFile.setFileName(null);
			String returnValue = fileUtil.retrieveFlatFile(flatFile);
			assertEquals(returnValue,"");	
	}
	
	
	//@Test
	public void TestRetrieveFlatFileWithExceptionNoDirectoryPath()
	{
		
			flatFile.setDirectoryPath(null);
			String returnValue = fileUtil.retrieveFlatFile(flatFile);
			assertEquals(returnValue,"");	
	}
	
	@Test(expected=IOException.class)
	public void TestRetrieveFlatFile() throws IOException
	{
		fileUtil.createFlatFile(flatFile);
		String returnValue = fileUtil.retrieveFlatFile(flatFile);
		System.out.println(returnValue);
	}
	
	
}
