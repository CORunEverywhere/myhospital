package org.hospital.service;

import org.hospital.dao.patientDao;
import org.hospital.entity.patient;

import java.util.List;

public class patientService {
	patientDao ppatientDao = new patientDao();
	
	public boolean addPatient(patient ppatient) {
		if(ppatientDao.isExist(ppatient.getUsername())) {
			ppatientDao.addPatient(ppatient);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deletePatient(int sno) {
		ppatientDao.deletePatientBySno(sno);
	}
	
	public patient queryPatientBySno(int sno) {
		return ppatientDao.queryPatientBySno(sno);
	}
	
	public patient queryPatientByUsername(String username) {
		return ppatientDao.queryPatientByUsername(username);
	}
	
	public List<patient> queryPatientByName(String name) {
		return ppatientDao.queryPatientByName(name);
	}
	
	public List<patient> queryAllPatient(){
		return ppatientDao.queryAllPatient();
	}
	
	public void updatePatient(int sno,patient ppatient) {
		ppatientDao.updatePatientBySno(sno, ppatient);
	}

}
