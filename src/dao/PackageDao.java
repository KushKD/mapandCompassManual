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

import Model.Packages;

@Component(value="packagesDao")
public class PackageDao {

private NamedParameterJdbcTemplate jdbc;
	

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public Boolean savePackages(Packages packages){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("packagenamemc", packages.getPackagenamemc());
		params.addValue("packageshortdesc", packages.getPackageshortdesc());
		params.addValue("packagelongdesc", packages.getPackagelongdesc());
		params.addValue("packagethumbnail", packages.getPackagethumbnail());
		params.addValue("packagethumbnailbig", packages.getPackagethumbnailbig());
		params.addValue("packagehashtag", packages.getPackagehashtag());
		params.addValue("packagerate", packages.getPackagerate());
		params.addValue("packageregion", packages.getPackageregion());
		params.addValue("entryDate", packages.getEntryDate());
		params.addValue("month", packages.getMonth());
		params.addValue("year", packages.getYear());
		
		
		return jdbc.update("INSERT INTO packeges (packagenamemc,packageshortdesc,packagelongdesc,packagethumbnail,packagethumbnailbig,packagehashtag,packagerate,packageregion,entryDate,month,year) VALUES(:packagenamemc ,:packageshortdesc, :packagelongdesc ,:packagethumbnail, :packagethumbnailbig, :packagehashtag ,:packagerate ,:packageregion, :entryDate, :month ,:year)", params) == 1;
		
	}
	
	public List<Packages> getPackages(){
		
		return jdbc.query("SELECT package_id,packagenamemc,packageshortdesc, packagethumbnail, packagehashtag , packagerate FROM packeges", new RowMapper<Packages>() {

			@Override
			public Packages mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Packages packages = new Packages();
				
				packages.setPackage_id(rs.getInt("package_id"));
				packages.setPackagenamemc(rs.getString("packagenamemc"));
				packages.setPackageshortdesc(rs.getString("packageshortdesc"));
				packages.setPackagethumbnail(rs.getString("packagethumbnail"));
				packages.setPackagehashtag(rs.getString("packagehashtag"));
				packages.setPackagerate(rs.getString("packagerate"));
				
				System.out.println(packages.toString());
				return packages;
			}
		});
	}

}
