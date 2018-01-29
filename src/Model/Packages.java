package Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Packages {
	
	private int package_id;
	
	
	@NotNull(message="Package Name cannot be empty")
	@Size(min=5,message="Please enter valid Package name. Minimum length of name is 5 characters")
	private String packagenamemc;
	
	@NotNull(message="Short description of package cannot be empty")
	@Size(min=5,max=100,message="Please enter valid Short description of the package. Minimum length 5 and Maximum is 100")
	private String packageshortdesc;
	
	@NotNull(message="Long description of package cannot be empty")
	@Size(min=10,message="Please enter valid Long description of the package. Minimum length 10")
	private String packagelongdesc;
	
	
	private String packagethumbnail;
	private String packagethumbnailbig;
	
	@NotNull(message="HashTag of package (Like Adventure,Winter Sports etc.) cannot be empty")
	@Size(min=5,max=100,message="Please enter valid HashTag of the package. Minimum length 5 and Maximum is 100")
	private String packagehashtag;
	
	@NotNull(message="Short description of package cannot be empty")
	@Size(min=3,message="Please enter valid Rate of the package. Minimum length 3")
	private String packagerate;
	
	@NotNull(message="Package Region cannot be empty")
	@Size(min=3,max=100,message="Please enter valid Region (State,District etc.) of the package. Minimum length 3")
	private String packageregion;
	
	private String entryDate;
	private String month;
	private String year;
	
	private MultipartFile packagethumbnailpic;
	private MultipartFile packagethumbnailbigpic;
	
	
	public int getPackage_id() {
		return package_id;
	}
	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}
	 
	public String getPackageshortdesc() {
		return packageshortdesc;
	}
	public void setPackageshortdesc(String packageshortdesc) {
		this.packageshortdesc = packageshortdesc;
	}
	public String getPackagelongdesc() {
		return packagelongdesc;
	}
	public void setPackagelongdesc(String packagelongdesc) {
		this.packagelongdesc = packagelongdesc;
	}
	public String getPackagethumbnail() {
		return packagethumbnail;
	}
	public void setPackagethumbnail(String packagethumbnail) {
		this.packagethumbnail = packagethumbnail;
	}
	public String getPackagethumbnailbig() {
		return packagethumbnailbig;
	}
	public void setPackagethumbnailbig(String packagethumbnailbig) {
		this.packagethumbnailbig = packagethumbnailbig;
	}
	public String getPackagehashtag() {
		return packagehashtag;
	}
	public void setPackagehashtag(String packagehashtag) {
		this.packagehashtag = packagehashtag;
	}
	public String getPackagerate() {
		return packagerate;
	}
	public void setPackagerate(String packagerate) {
		this.packagerate = packagerate;
	}
	public String getPackageregion() {
		return packageregion;
	}
	public void setPackageregion(String packageregion) {
		this.packageregion = packageregion;
	}
	public String getPackagenamemc() {
		return packagenamemc;
	}
	public void setPackagenamemc(String packagenamemc) {
		this.packagenamemc = packagenamemc;
	}
	public MultipartFile getPackagethumbnailpic() {
		return packagethumbnailpic;
	}
	public void setPackagethumbnailpic(MultipartFile packagethumbnailpic) {
		this.packagethumbnailpic = packagethumbnailpic;
	}
	public MultipartFile getPackagethumbnailbigpic() {
		return packagethumbnailbigpic;
	}
	public void setPackagethumbnailbigpic(MultipartFile packagethumbnailbigpic) {
		this.packagethumbnailbigpic = packagethumbnailbigpic;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Packages [package_id=" + package_id + ", packagenamemc=" + packagenamemc + ", packageshortdesc="
				+ packageshortdesc + ", packagelongdesc=" + packagelongdesc + ", packagethumbnail=" + packagethumbnail
				+ ", packagethumbnailbig=" + packagethumbnailbig + ", packagehashtag=" + packagehashtag
				+ ", packagerate=" + packagerate + ", packageregion=" + packageregion + ", entryDate=" + entryDate
				+ ", month=" + month + ", year=" + year + ", packagethumbnailpic=" + packagethumbnailpic
				+ ", packagethumbnailbigpic=" + packagethumbnailbigpic + "]";
	}
	
	
	
	
	
	
	
	
	

}
