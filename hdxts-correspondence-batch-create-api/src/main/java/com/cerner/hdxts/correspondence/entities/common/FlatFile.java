package com.cerner.hdxts.correspondence.entities.common;

public class FlatFile
{
	private String directoryPath;
	private String fileName;
	private String fileContentEncoding;
	private Boolean createFileIfNotExists;
	private String content;

	public String getDirectoryPath()
	{
		return this.directoryPath;
	}

	public void setDirectoryPath(String directoryPath)
	{
		this.directoryPath = directoryPath;
	}

	public String getFileName()
	{
		return this.fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileContentEncoding()
	{
		return this.fileContentEncoding;
	}

	public void setFileContentEncoding(String fileContentEncoding)
	{
		this.fileContentEncoding = fileContentEncoding;
	}

	public Boolean getCreateFileIfNotExists()
	{
		return this.createFileIfNotExists;
	}

	public void setCreateFileIfNotExists(Boolean createFileIfNotExists)
	{
		this.createFileIfNotExists = createFileIfNotExists;
	}

	public String getContent()
	{
		return this.content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
