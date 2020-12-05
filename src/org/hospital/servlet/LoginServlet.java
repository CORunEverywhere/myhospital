package org.hospital.servlet;

import org.hospital.entity.DepotKeeper;
import org.hospital.entity.Doctor;
import org.hospital.entity.admin;
import org.hospital.repository.AdminRepository;
import org.hospital.repository.DepotKeeperRepository;
import org.hospital.repository.DoctorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends BaseServlet {

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����Ա��ҩƷ����Ա�Լ�ҽ���ĵ�¼
    	//Դҳ�棺register.jsp
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String login_type = request.getParameter("user");
        if(login_type==null){
            request.setAttribute("msg","请选择用户类型");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        switch (login_type){
            case "doctor":
                DoctorRepository doctorRepository = new DoctorRepository();
                Doctor doctor = doctorRepository.doctor_login(name);
                if(doctor!=null&&password.equals(doctor.getPassword())) {
                	HttpSession session = request.getSession();
                    session.setAttribute("ddoctor", doctor);
                    response.sendRedirect("doctor/doctor_login.jsp");
                }
                else {
                    response.sendRedirect("fail.jsp");
                }
                break;
            case "admin":
                AdminRepository service  = new AdminRepository();
                admin aadmin = service.queryAdminBySname(name) ;
                if(aadmin!=null&&password.equals(aadmin.getPassword())) {
                	HttpSession session = request.getSession();
                    session.setAttribute("aadmin", aadmin);
                    response.sendRedirect("admin/admin_login.jsp");
                }
                else {
                    response.sendRedirect("fail.jsp");
                }
                break;
            case "depot_keeper":
                DepotKeeperRepository depotKeeperRepository = new DepotKeeperRepository();
                DepotKeeper depotKeeper = depotKeeperRepository.depotKeeper_login(name);
                if(depotKeeper!=null&&password.equals(depotKeeper.getPassword())) {
                	HttpSession session = request.getSession();
                    session.setAttribute("keeper", depotKeeper);
                    response.sendRedirect("keeper/depot_keeper_login.jsp");
                }
                else {
                    response.sendRedirect("fail.jsp");
                }
                break;
        }
    }
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����Ա�޸�����
    	//Դҳ�棺admin/admin_login.jsp
    	String name = request.getParameter("username");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
    	AdminRepository service  = new AdminRepository();
        admin aadmin = service.queryAdminBySname(name) ;
        if(aadmin!=null&&password.equals(aadmin.getPassword())) {
         	service.updateAdminBySname(newPassword, name);
         	request.setAttribute("msg", "管理员密码已改变");
         	request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if(!password.equals(aadmin.getPassword())){
            request.setAttribute("err","原密码错误");
            request.getRequestDispatcher("admin/updateAdmin.jsp").forward(request,response);
        }
       
    }
}
