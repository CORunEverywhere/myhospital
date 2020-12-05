package org.hospital.servlet;

import org.hospital.entity.DepotKeeper;
import org.hospital.entity.DepotKeeperPage;
import org.hospital.service.DepotKeeperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/DepotKeeper")
public class DepotKeeperServlet extends BaseServlet{
    public void AddDepotKeeper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ���Ӳֿ����Ա
        //Դҳ�棺admin/DepotKeepeAdmin.jsp
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("sname");
        String sex = request.getParameter("ssex");
        String birthyear = request.getParameter("sbirthyear") ;
        String title = request.getParameter("stitle");
        String department = request.getParameter("sdepartment");
        String address = request.getParameter("saddress");
        String phonenumber = request.getParameter("sphonenumber");
        String password = phonenumber;
        DepotKeeper depotKeeper  = new DepotKeeper(name,sex,birthyear,password,address,phonenumber) ;

        DepotKeeperService depotKeeperService = new DepotKeeperService();
        boolean result = depotKeeperService.addDepotKeeper(depotKeeper) ;
//        if (result){
//            request.getSession().setAttribute("msg","新增成功");
//        }
//        if(!result) {
//            request.setAttribute("msg", "���Ӳֿ����Ա�߻��ɹ�");
//        }

        response.sendRedirect(request.getContextPath()+"/admin/operateSuccess1.jsp");
//        request.getRequestDispatcher("admin/operateSuccess1.jsp").forward(request, response);
    }
    public void DeleteDepotKeeper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ɾ���ֿ����Ա
        //Դҳ�棺admin/DepotKeepeAdmin.jsp
        request.setCharacterEncoding("utf-8");
        int no = Integer.parseInt( request.getParameter("sno") );
        DepotKeeperService service = new DepotKeeperService();
        boolean result = service.deleteDepotKeeperBySno(no) ;
//        if (result){
//            request.getSession().setAttribute("msg","删除成功");
//        }
//        if(result) {
//            //response.sendRedirect("QueryStudentByPageServlet0");
//            request.setAttribute("msg", "ɾ���ֿ����Ա�߻��ɹ�");
//        }
        response.sendRedirect(request.getContextPath()+"/admin/operateSuccess1.jsp");
//        request.getRequestDispatcher("admin/operateSuccess1.jsp").forward(request, response);
    }
    public void QueryDepotKeeperByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ͨ�������ֿ����Ա
        //Դҳ�棺admin/DepotKeepeAdmin.jsp
        request.setCharacterEncoding("utf-8");
        String no  = request.getParameter("sname")  ;
        DepotKeeperService service  = new DepotKeeperService();
        List<DepotKeeper> DepotKeepers = service.queryDepotKeeperBySname(no) ;
        request.setAttribute("DepotKeepers", DepotKeepers);
        request.getRequestDispatcher("admin/queryDepotKeeper.jsp").forward(request, response);
    }
    public void QueryDepotKeeperBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ͨ�������ֿ����Ա
        //Դҳ�棺admin/DepotKeepeAdmin.jsp
        request.setCharacterEncoding("utf-8");
        int sno  = Integer.parseInt(request.getParameter("sno"))  ;
        DepotKeeperService service  = new DepotKeeperService();
        DepotKeeper depotKeeper = service.queryDepotKeeperBySno(sno);
        request.setAttribute("depotKeeper", depotKeeper);
        request.getRequestDispatcher("admin/updateDepotKeeper.jsp").forward(request, response);
    }
    public void UpdateDepotKeeperBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sno = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthyear = request.getParameter("birthyear");
        String address = request.getParameter("address");
        String sex = request.getParameter("sex");
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");

        DepotKeeper depotKeeper = new DepotKeeper();
        depotKeeper.setId(sno);
        depotKeeper.setName(name);
        depotKeeper.setAddress(address);
        depotKeeper.setBirthYear(birthyear);
        depotKeeper.setPassword(password);
        depotKeeper.setPhonenumber(phonenumber);
        depotKeeper.setSex(sex);

        DepotKeeperService service = new DepotKeeperService();
        service.updateDepotKeeperBySno(sno, depotKeeper);

        request.getRequestDispatcher("admin/operateSuccess1.jsp").forward(request,response);

    }
    public void QueryDepotKeeperByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ��ҳ���Ҳֿ����Ա
        //Դҳ�棺admin/DepotKeepeAdmin.jsp
        DepotKeeperService depotKeeperService = new DepotKeeperService();
        int count = depotKeeperService.getTotalCount();

        DepotKeeperPage page = new DepotKeeperPage();
        String cPage = request.getParameter("currentPage");
        if(cPage == null) {
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);
        page.setTotalCount(count);
        int pageSize = 3 ;
        page.setPageSize(pageSize);

        List<DepotKeeper> students = depotKeeperService.queryDepotKeepersByPage(currentPage, pageSize) ;
        page.setDepotKeepers(students);
        page.setTotalPage();
        request.setAttribute("p", page);
        request.getRequestDispatcher( "admin/DepotKeeperAdmin.jsp").forward(request, response);
    }
}
