package cn.ptp.hibernate;

import cn.ptp.hibernate.Users;

public interface UsersDao{
	public void save(Users users);
	public void delete(int id);
	public Users get(int id);
}