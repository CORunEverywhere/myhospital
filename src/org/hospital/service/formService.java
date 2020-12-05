package org.hospital.service;

import org.hospital.dao.formDao;
import org.hospital.entity.form;

import java.util.List;

public class formService {
	formDao fformDao = new formDao();
	
	
	//鎻掑叆鎸傚彿璁板綍
	public void addForm(form fform) {
		fformDao.addfform(fform);
	}
	
	//淇敼鎸傚彿鐘舵��
	public void updateFormState(int id) {
		fformDao.updateformState(id);
	}
	
	//按照医生编号查找挂号单
	public List<form> queryFormByDid(int did) {
		return fformDao.queryFormByDid(did);
	}

}
