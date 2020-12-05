package org.hospital.service;

import org.hospital.dao.recipeDao;
import org.hospital.entity.recipe;

import java.util.List;

public class recipeService {
	recipeDao rrcipeDao = new recipeDao();
	//
	public void addRecipe(recipe rrecipe) {
		if(rrcipeDao.isExsit(rrecipe.getPid(), rrecipe.getDid())) {
			rrcipeDao.addRecipe(rrecipe);
		}else {
			rrcipeDao.updateRecipeAmonut(rrecipe.getId(), 1);//拿不到id，由于service层传过来的rrecipe是用没有id的构造函数构造的，所以是空指针
		}
	}
	
	public void deleteRecipe(int id) {
		rrcipeDao.deleteRecipeBySno(id);
	}
	
	public void updateRecipeAmount(int id,int amount) {
		rrcipeDao.updateRecipeAmonut(id, amount);
		if(rrcipeDao.queryRecipeById(id).getAmount()<=0) {
			rrcipeDao.deleteRecipeBySno(id);
		}
	}


	//
	public List<recipe> queryRecipeByPid(int pid){
		return rrcipeDao.queryRecipeByPid(pid);
	}
	
	public void updateRecipeState(int id) {
		rrcipeDao.updateRecipeState(id);
	}

}
