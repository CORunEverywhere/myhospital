package org.hospital.repository;

import org.hospital.dao.AdminDao;
import org.hospital.entity.admin;

public class AdminRepository {
	AdminDao hospital = new AdminDao();
	
	public admin queryAdminBySname(String sname) {
		return hospital.queryAdminBySname(sname);
	}
	public boolean updateAdminBySname(String newpassword,String sname) {
		return hospital.updateAdminBySname(newpassword, sname);
	}
}
