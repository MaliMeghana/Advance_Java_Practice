package in.edac.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;




@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String pname;
	private String price;
	@Lob
	private String path;
	private int cid;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String pname, String price, String path, int cid) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.path = path;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
}
