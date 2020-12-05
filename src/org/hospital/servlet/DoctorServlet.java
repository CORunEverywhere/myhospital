package org.hospital.servlet;

import org.hospital.entity.Doctor;
import org.hospital.entity.doctorPage;
import org.hospital.entity.recipe;
import org.hospital.service.doctorService;
import org.hospital.service.recipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Doctor")
public class DoctorServlet extends BaseServlet{
    public void Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 增加医生，由于命名未AddDoctor会出现no such method的错误，所以改为add
    	//源页面：admin/addDoctor.jsp
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("sname");
        String sex = request.getParameter("ssex");
        int birthyear = Integer.parseInt(  request.getParameter("sbirthyear")) ;
        String title = request.getParameter("stitle");
        String department = request.getParameter("sdepartment");
        String address = request.getParameter("saddress");
        String phonenumber = request.getParameter("sphonenumber");
        String password = phonenumber;
        Doctor ddoctor  = new Doctor(name,sex,birthyear,title,department,password,address,phonenumber) ;

        doctorService doctorService = new doctorService();
        boolean result = doctorService.addDoctor(ddoctor) ;
//        if (result){
//            request.getSession().setAttribute("msg", "新增医生成功");
//        }
        response.sendRedirect(request.getContextPath()+"/admin/operateSuccess.jsp");
//        if(!result) {
//            request.setAttribute("msg", "增加医生成功");
//        }
//        request.getRequestDispatcher("admin/operateSuccess.jsp").forward(request, response);
    }

    public void DeleteDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过编号删除医生
    	//源页面：admin/doctorAdmin.jsp
        request.setCharacterEncoding("utf-8");
        int no = Integer.parseInt( request.getParameter("sno") );
        doctorService service = new doctorService();
        boolean result = service.deleteDoctorBySno(no) ;
//        if(result) {
//            //response.sendRedirect("QueryStudentByPageServlet0");
//            request.getSession().setAttribute("msg", "删除医生成功");
//        }
        request.getRequestDispatcher("admin/operateSuccess.jsp").forward(request, response);
    }
    public void QueryDoctorByDepart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过部门查询医生
        //源页面：patient/queue.jsp
        request.setCharacterEncoding("utf-8");
        String depart  = request.getParameter("depart")  ;
        doctorService service  = new doctorService();
        List<Doctor> doctors = service.queryDoctorByDepart(depart) ;
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("patient/queryDoctorDepart.jsp").forward(request, response);
    }
    public void QueryDoctorByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过姓名查询医生信息
        //源页面：admin/doctorAdmin.jsp
        request.setCharacterEncoding("utf-8");
        String no  = request.getParameter("sname")  ;
        doctorService service  = new doctorService();
        List<Doctor> doctors = service.queryDoctorBySname(no) ;
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("admin/queryDoctor.jsp").forward(request, response);
    }
    public void QueryDoctorByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过分页的方式查询所有医生信息
        //源页面：admin_login.jsp
        doctorService  ddoctorService = new doctorService();
        int count = ddoctorService.getTotalCount();
        doctorPage page = new doctorPage();
        String cPage = request.getParameter("currentPage");
        if(cPage == null) {
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);
        page.setTotalCount(count);
        int pageSize = 3 ;
        page.setPageSize(pageSize);
        List<Doctor> students = ddoctorService.queryDoctorsByPage(currentPage, pageSize) ;
        page.setDoctors(students);
        page.setTotalPage();
        request.setAttribute("p", page);
        request.getRequestDispatcher( "admin/doctorAdmin.jsp").forward(request, response);
    }
    public void QueryDoctorBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 通过编号查找医生
        //源页面：admin_login.jsp
        request.setCharacterEncoding("utf-8");
        int no  = Integer.parseInt( request.getParameter("sno"))  ;
        doctorService service  = new doctorService();
        Doctor ddoctor = service.queryDoctorBySno(no) ;
        request.setAttribute("ddoctor", ddoctor);
        request.getRequestDispatcher("admin/updateDoctor.jsp").forward(request, response);
    }
    public void UpdateDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 通过编号查找医生后进行医生信息的更新
        //源页面：admin_login.jsp
        request.setCharacterEncoding("utf-8");
        int no = Integer.parseInt( request.getParameter("sno") ) ;
        String name =  request.getParameter("sname") ;
        String sex =  request.getParameter("ssex") ;
        String address =  request.getParameter("saddress") ;
        String phonenumber =  request.getParameter("sphonenumber") ;
        String department =  request.getParameter("sdepartment") ;
        String title =  request.getParameter("stitle") ;
        int birthYear  = Integer.parseInt( request.getParameter("sbirthyear")) ;
        Doctor ddoctor = new Doctor(name,sex,birthYear,title,department,address,phonenumber);

        doctorService service = new doctorService();
        boolean result = service.updateDoctorBySno(no, ddoctor);
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        if(result) {
            request.setAttribute("msg", "医生信息已更新");
        }
        request.getRequestDispatcher("admin/operateSuccess.jsp").forward(request, response);
    }
    public void AddRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //加入药方
        //源页面：doctor/drugAdmin2.jsp
        request.setCharacterEncoding("utf-8");

        int pid = Integer.parseInt(request.getParameter("pid"));
        String pname = request.getParameter("pname");
        int did = Integer.parseInt(  request.getParameter("did")) ;
        String dname = request.getParameter("dname");
        int price = Integer.parseInt(  request.getParameter("price")) ;
        recipe rrecipe  = new recipe(pid,pname,did,dname,1,price,0) ;
        recipeService rrecipeService = new recipeService();
        rrecipeService.addRecipe(rrecipe); 
        request.getRequestDispatcher("doctor/recipeSuccess.jsp").forward(request, response);
    }
    public void DeleteRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除药方
        //源页面：doctor/queryRecipe.jsp
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        recipeService rrecipeService = new recipeService();
        rrecipeService.deleteRecipe(id); 
        request.getRequestDispatcher("doctor/recipeDelete.jsp").forward(request, response);
    }
    public void QueryRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过患者编号查找药单
        //源页面：doctor/drugAdmin2.jsp
        request.setCharacterEncoding("utf-8");

        int pid = Integer.parseInt(request.getParameter("pid"));
        recipeService rrecipeService = new recipeService();
        List<recipe> recipes = rrecipeService.queryRecipeByPid(pid); 
        request.setAttribute("recipes", recipes);
        request.getRequestDispatcher("doctor/queryRecipe.jsp").forward(request, response);
    }
    public void UpdateRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过编号更新药单数量
        //源页面：doctor/queryRecipe.jsp
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        recipeService rrecipeService = new recipeService();
        rrecipeService.updateRecipeAmount(id, amount);
        request.getRequestDispatcher("doctor/recipeDelete.jsp").forward(request, response);
    }
}
