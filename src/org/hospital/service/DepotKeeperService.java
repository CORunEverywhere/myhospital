package org.hospital.service;

import org.hospital.dao.DepotKeeperDao;
import org.hospital.entity.DepotKeeper;

import java.util.List;

public class DepotKeeperService {
    DepotKeeperDao depotKeeperDao = new DepotKeeperDao();

    public DepotKeeper queryDepotKeeperBySno(int sno) {
        return depotKeeperDao.queryDepotKeeperBySno(sno);
    }

    public List<DepotKeeper> queryDepotKeeperBySname(String sname) {
        return depotKeeperDao.queryDepotKeeperBySname(sname);
    }

    public List<DepotKeeper> queryDepotKeepersByPage(int currentPage,int pageSize) {
        return depotKeeperDao.queryDepotKeepersByPage(currentPage,pageSize);
    }

    public boolean updateDepotKeeperBySno(int sno,DepotKeeper ddoctor) {
        if(depotKeeperDao.isExist(sno)) {
            return depotKeeperDao.updateDepotKeeperBySno(sno,ddoctor);
        }
        return false;
    }

    public boolean deleteDepotKeeperBySno(int sno) {
        if(depotKeeperDao.isExist(sno)) {
            return depotKeeperDao.deleteDepotKeeperBySno(sno);
        }else {
            return false;
        }
    }

    public boolean addDepotKeeper(DepotKeeper ddoctor) {
        if(!depotKeeperDao.isExist(ddoctor.getId())) {
            depotKeeperDao.addDepotKeeper(ddoctor);
            return true;
        }else {
            return false;
        }
    }

    public int getTotalCount() {
        return depotKeeperDao.getTotalCount();
    }
}
