package org.hospital.service;

import org.hospital.dao.drugDao;
import org.hospital.entity.DepotKeeper;
import org.hospital.entity.drug;
import org.hospital.entity.record;

import java.util.List;

public class drugService {
	drugDao ddrugDao = new drugDao();
	
	public drug queryDrugBySno(String sno) {
		return ddrugDao.queryDrugBySno(sno);
	}
	
	public List<drug> queryDrugByName(String name) {
		return ddrugDao.queryDrugByName(name);
	}
	
	public List<drug> queryDrugsByPage(int currentPage,int pageSize) {
		return ddrugDao.queryDrugsByPage(currentPage,pageSize);
	}
	
	public boolean updateDrugBySno(String sno,drug ddrug) {
		if(ddrugDao.isExist(sno)) {
			return ddrugDao.updateDrugBySno(sno,ddrug);
		}
		return false;
	}
	
	public boolean updateDrugNumberBySno(String sno,drug ddrug,DepotKeeper keeper) {
		if(ddrugDao.isExist(sno)) {
			return ddrugDao.updateDrugNumberBySno(sno,ddrug,keeper);
		}
		return false;
	}
	
	public boolean deleteDrugBySno(String sno) {
		if(ddrugDao.isExist(sno)) {
			return ddrugDao.deleteDrugBySno(sno);
		}else {
			return false;
		}
	}
	
	public boolean addDrug(drug ddrug,DepotKeeper keeper) {
		if(!ddrugDao.isExist(ddrug.getSno())) {
			ddrugDao.addDrug(ddrug,keeper);
			return true;
		}else {
			return false;
		}
	}
	public List<record> queryAllRecord() {
		return ddrugDao.queryAllRecord();
	}
	public int getTotalCount() {
		return ddrugDao.getTotalCount();
	}
}
