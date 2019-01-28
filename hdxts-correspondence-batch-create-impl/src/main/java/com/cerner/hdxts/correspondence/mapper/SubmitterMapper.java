package com.cerner.hdxts.correspondence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SubmitterMapper implements ResultSetExtractor<List<Long>>
{
	@Override
	public List<Long> extractData(ResultSet rs) throws SQLException, DataAccessException 
	{
		List<Long> submitterIds = new ArrayList<>();
		if (rs != null) 
		{
			while(rs.next()){
				submitterIds.add(rs.getLong("SUBMITTER_ID"));
			}
		}
		return submitterIds;
	}

}
