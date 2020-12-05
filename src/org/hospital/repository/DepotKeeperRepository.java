package org.hospital.repository;

import org.hospital.dao.DepotKeeperDao;
import org.hospital.entity.DepotKeeper;

public class DepotKeeperRepository {
    DepotKeeperDao depotKeeperDao = new DepotKeeperDao();
    public DepotKeeper depotKeeper_login(String id){
        return depotKeeperDao.queryDepotKeeperBySno(Integer.valueOf(id));
    }
}
