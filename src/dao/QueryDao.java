package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import Model.Query;

@Component(value="queryDao")
public class QueryDao {

private NamedParameterJdbcTemplate jdbc;
	
	

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
public Boolean savePackages(Query query){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", query.getName());
		params.addValue("email", query.getEmail());
		params.addValue("mobile", query.getMobile());
		params.addValue("message", query.getMessage());
		params.addValue("subject", query.getSubject());
		params.addValue("country", query.getCountry());
		params.addValue("packageId", 0);
		params.addValue("entryDate", query.getEntryDate());
		params.addValue("month", query.getMonth());
		params.addValue("year", query.getYear());
		
		
		return jdbc.update("INSERT INTO queries (name,email,mobile,message,subject,country,packageId,entryDate,month,year) VALUES(:name ,:email, :mobile ,:message, :subject, :country ,:packageId , :entryDate, :month ,:year)", params) == 1;
		
	}
	
	public List<Query> getQueries(){
		
		return jdbc.query("SELECT id, name,email,mobile, message, subject , country,packageId, entryDate FROM queries", new RowMapper<Query>() {

			@Override
			public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Query query = new Query();
				query.setId(rs.getInt("id"));
				query.setName(rs.getString("name"));
				query.setEmail(rs.getString("email"));
				query.setMobile(rs.getString("mobile"));
				query.setMessage(rs.getString("message"));
				query.setSubject(rs.getString("subject"));
				query.setCountry(rs.getString("country"));
				query.setPackageId(rs.getInt("packageId"));
				query.setEntryDate(rs.getString("entryDate")); 
				
				
				
				System.out.println(query.toString());
				return query;
			}
		});
	}


}
