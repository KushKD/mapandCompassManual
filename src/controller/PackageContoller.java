package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import Model.Packages;
import Model.Query;
import dao.PackageDao;
import helpers.Helpers;

@Controller 
public class PackageContoller {
	
	@Autowired
	ServletContext context;
	
	
	private PackageDao packageDao;
	
	
	
	public PackageDao getPackageDao() {
		return packageDao;
	}  

	@Autowired
	public void setPackageDao(PackageDao packageDao) {
		this.packageDao = packageDao;
	}  

	@RequestMapping(value="/createpackage", method=RequestMethod.GET)
	public String createPackage(Model mv){
		mv.addAttribute("packages", new Packages());
		return "createpackage";
	}
	
	@RequestMapping(value="/packages", method=RequestMethod.GET)
	public String getPackages(Model model){
		
		
		packageDao.getPackages();
		model.addAttribute("packages", packageDao.getPackages());
		return "packages";
	}
	
	
	
	@RequestMapping(value="/savepackage", method=RequestMethod.POST)
	public String savePackage(Model mv , @Valid Packages packages , BindingResult result ){
		
		Boolean flag = false;
		
		
		try {
			
			if(result.hasErrors()){
				return "createpackage";
			}else{
				packages.setEntryDate(Helpers.GetDateToday());
				packages.setMonth(Helpers.GetMonthToday());
				packages.setYear(Helpers.GetYearToday());
				
				Packages smallImage = uploadImageThumbnail(packages);
				Packages BigImag = uploadImageBig(smallImage);
				

				System.out.println("Package Value " + BigImag.toString());
				
				
				flag =   packageDao.savePackages(BigImag);
				
				if(flag){
					return "index";
				}else{
					return "createpackage";
				}  
				
				
				
			}
			
			
			
			
		} catch (DataAccessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			System.out.println(ex.getLocalizedMessage());
			System.out.println(ex.getClass());
			return "createpackage";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getClass());
			return "createpackage";
		}
		
		
		
	}

private Packages uploadImageBig(Packages post) throws IOException {
		
		
		
		MultipartFile  multipartFile = post.getPackagethumbnailbigpic();
		String uploadPath = context.getRealPath("/resources/images/packages/thumbnailbig/");
		System.out.println(uploadPath);
		///AnitaNangia/WebContent/resources/documents/pdf
		FileCopyUtils.copy(post.getPackagethumbnailbigpic().getBytes(), new File(uploadPath+"/"+post.getPackagethumbnailbigpic().getOriginalFilename()));
		System.out.println(uploadPath+"/"+post.getPackagethumbnailbigpic().getOriginalFilename());
		String fileName = multipartFile.getOriginalFilename();
		post.setPackagethumbnailbig(fileName);
		
		return  post;
	}


private Packages uploadImageThumbnail(Packages post) throws IOException {
	
	
	
	MultipartFile  multipartFile = post.getPackagethumbnailpic();
	String uploadPath = context.getRealPath("/resources/images/packages/thumbnail/");
	System.out.println(uploadPath);
	///AnitaNangia/WebContent/resources/documents/pdf
	FileCopyUtils.copy(post.getPackagethumbnailpic().getBytes(), new File(uploadPath+"/"+post.getPackagethumbnailpic().getOriginalFilename()));
	System.out.println(uploadPath+"/"+post.getPackagethumbnailpic().getOriginalFilename());
	String fileName = multipartFile.getOriginalFilename();
	post.setPackagethumbnail(fileName);
	
	return  post;
}


}
