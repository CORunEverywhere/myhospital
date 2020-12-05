package org.hospital.servlet;

import org.hospital.entity.*;
import org.hospital.service.DepotKeeperService;
import org.hospital.service.drugService;
import org.hospital.service.patientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Drug")
public class DrugServlet extends BaseServlet{
    public void AddDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 新增药品，同时加入记录
        //源页面：keeper/addDrug.jsp
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        DepotKeeperService keeperService = new DepotKeeperService();
        DepotKeeper keeper = keeperService.queryDepotKeeperBySno(id);
        
        String no = request.getParameter("sno");
        String name =  request.getParameter("sname") ;
        String factory =  request.getParameter("sfactory") ;
        String unit =  request.getParameter("sunit") ;
        int number = Integer.parseInt(  request.getParameter("snumber")) ;
        String price =  request.getParameter("sprice") ;
        drug ddrug = new drug(no,name,factory,unit,number,price);

        drugService service = new drugService();
        boolean result = service.addDrug(ddrug,keeper) ;
//        if(result) {
//            request.getSession().setAttribute("msg", "增加药物成功");
//        }
        request.getRequestDispatcher("keeper/operateSuccess1.jsp").forward(request, response);
    }
    public void DeleteDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 暂时不使用，删除时不会计入“记录”中
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("utf-8");
        String no = request.getParameter("sno") ;
        drugService service = new drugService();
        boolean result = service.deleteDrugBySno(no) ;
        if(result) {
            //response.sendRedirect("QueryStudentByPageServlet0");
            request.setAttribute("error", "nodeleteError");
        }else {
            request.setAttribute("error", "deleteError");
        }
        request.getRequestDispatcher("queryDrugByPageServlet").forward(request, response);
    }
    public void QueryAllRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有出入库记录
        //源页面：keeper/depot_keeper_login.jsp
        request.setCharacterEncoding("utf-8");
        drugService  ddrugService = new drugService();
        List<record> records = ddrugService.queryAllRecord() ;
        request.setAttribute("records", records);
        request.getRequestDispatcher("keeper/queryRecord.jsp").forward(request, response);
    }
    public void QueryDrugByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 分页展示药品信息
        //源页面：keeper/depot_keeper_login.jsp
        drugService  ddrugService = new drugService();
        int count = ddrugService.getTotalCount();
        drugPage page = new drugPage();
        String cPage = request.getParameter("currentPage");
        if(cPage == null) {
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);
        page.setTotalCount(count);
        int pageSize = 3 ;
        page.setPageSize(pageSize);
        List<drug> students = ddrugService.queryDrugsByPage(currentPage, pageSize) ;
        page.setDrugs(students);
        page.setTotalPage();
        request.setAttribute("p", page);
        request.getRequestDispatcher( "keeper/drugAdmin.jsp").forward(request, response);
    }
    public void QueryAllDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //源页面：doctor/queryForm.jsp（挂号单）
        //查询所有 的药品，用于挂号
        drugService  ddrugService = new drugService();
        int count = ddrugService.getTotalCount();
        int sno = Integer.parseInt(request.getParameter("pid"));
        int id = Integer.parseInt(request.getParameter("id"));
        patientService ppatientService = new patientService();
        patient ppatient = ppatientService.queryPatientBySno(sno);
        HttpSession session = request.getSession();
        session.setAttribute("ppatient", ppatient);//患者编号
        session.setAttribute("id", id);//挂号单号
        //以下代码用于分页
        drugPage page = new drugPage();
        String cPage = request.getParameter("currentPage");

        if(cPage == null) {
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);

        page.setTotalCount(count);

        int pageSize = 3 ;
        page.setPageSize(pageSize);

        List<drug> students = ddrugService.queryDrugsByPage(currentPage, pageSize) ;
        page.setDrugs(students);
        page.setTotalPage();

        request.setAttribute("p", page);

        request.getRequestDispatcher( "doctor/drugAdmin2.jsp").forward(request, response);
    }
    public void QueryAllDrug0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //源页面：doctor/queryForm.jsp（挂号单）
        //查询所有 的药品，用于挂号
        drugService  ddrugService = new drugService();
        int count = ddrugService.getTotalCount();
        drugPage page = new drugPage();
        String cPage = request.getParameter("currentPage");
        if(cPage == null) {
            cPage = "0";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);
        page.setTotalCount(count);
        int pageSize = 3 ;
        page.setPageSize(pageSize);
        List<drug> students = ddrugService.queryDrugsByPage(currentPage, pageSize) ;
        page.setDrugs(students);
        page.setTotalPage();
        request.setAttribute("p", page);

        request.getRequestDispatcher( "doctor/drugAdmin2.jsp").forward(request, response);
    }
    public void QueryDrugBySno2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //原函数是按照编号查询，现改为按照名称查询，更符合
        //源页面：keeper/drugAdmin.jsp
        request.setCharacterEncoding("utf-8");
        String no  = request.getParameter("sno")  ;
        drugService service  = new drugService();
        List<drug> drugs  = service.queryDrugByName(no) ;

        request.setAttribute("drugs", drugs);
           request.setAttribute("msg", "查询结果如下");
           request.getRequestDispatcher("doctor/queryDrug.jsp").forward(request, response);

    }
    public void QueryDrugBySno3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用于更新药品的出入库数量
        //源页面：keeper/drugAdmin.jsp
        request.setCharacterEncoding("utf-8");
        String no  = request.getParameter("sno")  ;
        drugService service  = new drugService();
        drug ddrug = service.queryDrugBySno(no) ;

        request.setAttribute("ddrug", ddrug);
        request.getRequestDispatcher("keeper/updateDrugRecord.jsp").forward(request, response);
    }
    public void QueryDrugBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询后用于对药品信息的更新
        //源页面：drugAdmin.jsp
        request.setCharacterEncoding("utf-8");
        String no  = request.getParameter("sno")  ;
        drugService service  = new drugService();
        drug ddrug = service.queryDrugBySno(no) ;

        request.setAttribute("ddrug", ddrug);
        request.getRequestDispatcher("keeper/updateDrug.jsp").forward(request, response);

    }
    public void UpdateDrugRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 药品出入库记录
        //源页面：keeper/updateDrugRecord.jsp
        request.setCharacterEncoding("utf-8");
        int number = Integer.parseInt(request.getParameter("number"));
        int id = Integer.parseInt(request.getParameter("id"));
        DepotKeeperService keeperService = new DepotKeeperService();
        DepotKeeper keeper = keeperService.queryDepotKeeperBySno(id);
        
        String no  = request.getParameter("sno") ;
        String name  = request.getParameter("sname") ;
        int num  = Integer.parseInt(request.getParameter("snumber")) ;
        if (number+num<0) num= -number;
        drugService service  = new drugService();
        drug ddrug = new drug(no,name,num);
        boolean result = service.updateDrugNumberBySno(no, ddrug,keeper);
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
//        if (result){
//            request.getSession().setAttribute("msg", "药品出入库成功");
//        }
//        if(result) {
//            request.setAttribute("msg", "药品出入库成功");
//        }
//        request.getRequestDispatcher("keeper/operateSuccess1.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/keeper/operateSuccess1.jsp");//
    }
    public void UpdateDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 更新药品的基本信息
        //源页面：keeper/updateDrug.jsp
        request.setCharacterEncoding("utf-8");
        String no = request.getParameter("sno");
        String name =  request.getParameter("sname") ;
        String factory =  request.getParameter("sfactory") ;
        String unit =  request.getParameter("sunit") ;
        String price =  request.getParameter("sprice") ;
        drug ddrug = new drug(no,name,factory,unit,price);
        drugService service = new drugService();
        boolean result = service.updateDrugBySno(no, ddrug);
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        if(result) {
            request.setAttribute("msg", "更新药品信息成功");
        }
//        request.getRequestDispatcher("keeper/operateSuccess1.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/keeper/operateSuccess1.jsp");
    }
}
