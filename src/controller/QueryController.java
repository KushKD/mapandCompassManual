package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Model.Query;
import dao.PackageDao;
import dao.QueryDao;
import helpers.Helpers;

@Controller
public class QueryController {
	
	
	private QueryDao queryDao;
	
	
	
	@Autowired
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}  

	@RequestMapping(value="/contactus", method=RequestMethod.GET)
	public String getContactUs(Model mv){
		mv.addAttribute("query", new Query());
		return "contactus";
	} 

	@RequestMapping(value="/getQuery", method=RequestMethod.POST)
	public String getQuery(Model mv , @Valid Query query , BindingResult result){
		Boolean flag = false;
		
		try{
			System.out.println(query.toString());
			
			if(result.hasErrors()){
				return "contactus";
			}else{
				
				query.setEntryDate(Helpers.GetDateToday());
				query.setMonth(Helpers.GetMonthToday());
				query.setYear(Helpers.GetYearToday());
				
				
				
				flag = queryDao.savePackages(query);
				
				if(flag){
					return "index";
				}else{
					return "contactus";
				}  
				
				//return "contactus";
				
				
				
			}
			
		}catch(DataAccessException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getClass());
			return "contactus";
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getClass());
			return "contactus";
			
		}
		
		
		
	}
	
	@RequestMapping(value="/getqueries", method=RequestMethod.GET)
	public String getQueries(Model mv){
		
		
		mv.addAttribute("query", queryDao.getQueries());
		
		
		return "getqueries";
	}

}
