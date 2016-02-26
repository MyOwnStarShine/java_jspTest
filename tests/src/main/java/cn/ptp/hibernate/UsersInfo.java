package cn.ptp.hibernate;

//-------------- JPA方式
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table(name="users_info")

class UsersInfo 
{
	@Id
	@GeneratedValue
	private int id;
	private String truename;
	private String nickname;
	private String sex;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTruename() {
		return truename;
	}
	
	public void setTruename(String truename) {
		this.truename = truename;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
