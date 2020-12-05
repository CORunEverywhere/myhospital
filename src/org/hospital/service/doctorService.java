package org.hospital.service;

import org.hospital.dao.DoctorDao;
import org.hospital.entity.Doctor;

import java.util.List;

public class doctorService {
	DoctorDao ddoctorDao = new DoctorDao();
	
	public Doctor queryDoctorBySno(int sno) {
		return ddoctorDao.queryDoctorBySno(sno);
	}
	
	public List<Doctor> queryDoctorBySname(String sname) {
		return ddoctorDao.queryDoctorBySname(sname);
	}
	
	public List<Doctor> queryDoctorsByPage(int currentPage, int pageSize) {
		return ddoctorDao.queryDoctorsByPage(currentPage,pageSize);
	}
	
	public boolean updateDoctorBySno(int sno, Doctor ddoctor) {
		if(ddoctorDao.isExist(sno)) {
			return ddoctorDao.updateDoctorBySno(sno,ddoctor);
		}
		return false;
	}
	
	public boolean deleteDoctorBySno(int sno) {
		if(ddoctorDao.isExist(sno)) {
			return ddoctorDao.deleteDoctorBySno(sno);
		}else {
			return false;
		}
	}
	
	public boolean addDoctor(Doctor ddoctor) {
		if(!ddoctorDao.isExist(ddoctor.getId())) {
			ddoctorDao.addDoctor(ddoctor);
			return true;
		}else {
			return false;
		}
	}
	public List<Doctor> queryDoctorByDepart(String sdepart) {
		return ddoctorDao.queryDoctorByDepart(sdepart);
	}
	
	public int getTotalCount() {
		return ddoctorDao.getTotalCount();
	}
}
