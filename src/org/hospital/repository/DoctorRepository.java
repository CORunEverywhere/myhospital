package org.hospital.repository;
import org.hospital.dao.DoctorDao;
import org.hospital.entity.Doctor;

public class DoctorRepository {
    DoctorDao doctorDao = new DoctorDao();
    public Doctor doctor_login(String name){
        return doctorDao.queryDoctorBySno(Integer.valueOf(name));
    }
}
