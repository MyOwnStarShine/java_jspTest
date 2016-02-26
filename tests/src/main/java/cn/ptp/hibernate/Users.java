package cn.ptp.hibernate;

//-------------- JPA方式
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table(name="users")

class Users 
{
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String salt;
	private String passwd;
	private int create_at;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt() {
		this.salt = "salttt";
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int getCreateAt() {
		return create_at;
	}
	
	public void setCreateAt() {
		this.create_at = 1422332255;
	}
	
}



/*
 * annotation 注解方式
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

class Users 
{
	@Id
	private int id;
	private String username;
	private String salt;
	private String passwd;
	private int create_at;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt() {
		this.salt = "salttt";
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int getCreateAt() {
		return create_at;
	}
	
	public void setCreateAt() {
		this.create_at = 1422332255;
	}
	
}
*/



