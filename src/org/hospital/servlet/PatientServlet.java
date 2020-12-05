package org.hospital.servlet;

import org.hospital.entity.patient;
import org.hospital.entity.recipe;
import org.hospital.service.patientService;
import org.hospital.service.recipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Patient")
public class PatientServlet extends BaseServlet{
    public void AddPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用户患者进行注册
        //源页面：patient/patientRegister
        request.setCharacterEncoding("utf-8");
        String username  = request.getParameter("username");
        String name  = request.getParameter("name");
        String sex = request.getParameter("sex");
        int year = Integer.parseInt(request.getParameter("year"));
        String phone = request.getParameter("phone");
        String password  = request.getParameter("password");
        patientService service  = new patientService();
        patient ppatient = new patient(username,name,sex,year,phone,password);
        if(service.addPatient(ppatient)) {
        	request.setAttribute("msg", "注册成功");
        }else {
        	request.setAttribute("msg", "用户名重复，请重新注册");
        }
        request.getRequestDispatcher("patient/patientLogin.jsp").forward(request, response);
    }
    public void QueryAllPatient(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询所有病人信息
        //源页面：admin/admin_login.jsp
        request.setCharacterEncoding("utf-8");
        patientService service = new patientService();
        List<patient> patients = service.queryAllPatient();
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("admin/patientAdmin.jsp").forward(request, response);
    }
    public void QueryPatientByName(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //通过姓名查询病人信息
        //源页面：admin/patientAdmin.jsp
    	request.setCharacterEncoding("utf-8");
        String no  = request.getParameter("sname")  ;
        patientService service  = new patientService();
        List<patient> patients = service.queryPatientByName(no) ;
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("admin/queryPatient.jsp").forward(request, response);
    }
    public void DeletePatientById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //删除病人信息
        //源页面：admin/patientAdmin.jsp
    	request.setCharacterEncoding("utf-8");
        int no  = Integer.parseInt(request.getParameter("sno"))  ;
        patientService service  = new patientService();
        service.deletePatient(no);
        request.setAttribute("msg", "删除病人信息成功");
        request.getRequestDispatcher("admin/operateSuccess2.jsp").forward(request, response);
    }
    public void QueryPatientByUsername(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //通过用户名查询，进行登录操作
        //y源页面：patient/patientLogin.jsp
        request.setCharacterEncoding("utf-8");
        String username  = request.getParameter("username");
        String password  = request.getParameter("password");
        patientService service  = new patientService();
        patient ppatient = service.queryPatientByUsername(username) ;
        if(ppatient!=null&&password.equals(ppatient.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("ppatient", ppatient);
            //request.getRequestDispatcher("patient/patientSuccess.jsp").forward(request, response);
            response.sendRedirect("patient/patientSuccess.jsp");
        }
        else {
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("patient/patientLogin.jsp").forward(request, response);
        }
    }
    public void UpdatePatient(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //对患者信息进行修改
        //源页面：patient/updatePatient.jsp
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String username  = request.getParameter("username");
        String name  = request.getParameter("name");
        String sex = request.getParameter("sex");
        int year = Integer.parseInt(request.getParameter("year"));
        String phone = request.getParameter("phone");
        String password  = request.getParameter("password");
        patient ppatient = new patient(username,name,sex,year,phone,password);
        patientService service  = new patientService();
        service.updatePatient(id, ppatient);
        request.setAttribute("msg", "修改成功，请重新登录");
        request.getRequestDispatcher("patient/patientLogin.jsp").forward(request, response);
       
    }
    public void QueryRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过患者编号查找药单
        //源页面：patient/patientSuccess.jsp
        request.setCharacterEncoding("utf-8");

        int pid = Integer.parseInt(request.getParameter("pid"));
        recipeService rrecipeService = new recipeService();
        List<recipe> recipes = rrecipeService.queryRecipeByPid(pid); 
        HttpSession session = request.getSession();
        session.setAttribute("recipes", recipes);
        request.getRequestDispatcher("patient/queryRecipe.jsp").forward(request, response);
    }
    
    public void UpdateRecipeByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过患者编号改变药方状态，即付款
        //源页面：doctor/drugAdmin2.jsp
        request.setCharacterEncoding("utf-8");

        int pid = Integer.parseInt(request.getParameter("id"));
        recipeService rrecipeService = new recipeService();
        rrecipeService.updateRecipeState(pid);
        request.getRequestDispatcher("patient/pay.jsp").forward(request, response);
    }
}
