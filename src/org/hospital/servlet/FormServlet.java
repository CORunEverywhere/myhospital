package org.hospital.servlet;

import org.hospital.entity.Doctor;
import org.hospital.entity.form;
import org.hospital.entity.patient;
import org.hospital.service.doctorService;
import org.hospital.service.formService;
import org.hospital.service.patientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Form")
public class FormServlet extends BaseServlet{
    public void AddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ӹҺŵ�
        //ԭҳ�棺patient/queryDoctorDepart.jsp
        request.setCharacterEncoding("utf-8");
        int pid = Integer.parseInt( request.getParameter("pid") );
        int did = Integer.parseInt( request.getParameter("did") );
        doctorService dservice = new doctorService();
        patientService pservice = new patientService();
        formService fservice = new formService();
        Doctor ddoctor = dservice.queryDoctorBySno(did);
        patient ppatient = pservice.queryPatientBySno(pid);

        form fform = new form(ppatient.getId(),ppatient.getName(),ddoctor.getId(),ddoctor.getName(),0);
        fservice.addForm(fform);
        request.setAttribute("msg", "�Һųɹ�");
        request.getRequestDispatcher("patient/patientSuccess.jsp").forward(request, response);
    }
    public void QueryFormByDid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		formService service  = new formService();
		List<form> forms = service.queryFormByDid(id);
		request.setAttribute("forms", forms);
		request.getRequestDispatcher("doctor/queryForm.jsp").forward(request, response);
	}
    public void UpdateFormByDid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �ı�Һŵ���״̬
		//Դҳ�棺doctor/queryRecipe
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		formService service  = new formService();
		service.updateFormState(id);
		request.getRequestDispatcher("doctor/doctor_login.jsp").forward(request, response);
	}
}
