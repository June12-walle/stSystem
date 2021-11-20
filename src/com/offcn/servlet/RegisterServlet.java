package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.entity.Doctor;
import com.offcn.entity.Register;
import com.offcn.service.DoctorService;
import com.offcn.service.RegisterService;
import com.offcn.utils.PageTool;

@WebServlet("/register")
public class RegisterServlet extends BaseServlet {
	RegisterService registerService = new RegisterService();
	DoctorService doctorService = new DoctorService();

	// 分页查询
	public void findRegisterByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取查询条件
		String rid = request.getParameter("rid");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		Register register = new Register(rid, name);
		if (department != null) {
			register.setDepartment(Integer.valueOf(department));
		}
		int totalCount = registerService.getTotalCount(register);
		String currentPage = request.getParameter("currentPage");
		PageTool pageTool = new PageTool(totalCount, currentPage);
		List<Register> registerList = registerService.findDoctorsByPage(register, pageTool);
		System.out.println(registerList.size());
		request.setAttribute("register", register);
		request.setAttribute("pageTool", pageTool);
		request.setAttribute("registerList", registerList);
		request.getRequestDispatcher("/register/index.jsp").forward(request, response);
	}

	// 添加挂号信息
	public void insertRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要添加的页面信息
		String rid = request.getParameter("rid");
		String name = request.getParameter("name");
		String idCard = request.getParameter("idCard");
		String siNumber = request.getParameter("siNumber");
		String registerMoney = request.getParameter("registerMoney");
		String phone = request.getParameter("phone");
		String isPay = request.getParameter("isPay");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String consultation = request.getParameter("consultation");
		String department = request.getParameter("department");
		String did = request.getParameter("did");
		String remark = request.getParameter("remark");
		// 封装挂号病人信息
		Register register = new Register(rid, name, idCard, siNumber, Double.valueOf(registerMoney), phone,
				Integer.valueOf(isPay), Integer.valueOf(sex), Integer.valueOf(age), Integer.valueOf(consultation),
				Integer.valueOf(department), Integer.valueOf(did), 1, new Date(), remark);
		boolean flag = registerService.insertRegister(register);
		if (flag) {
			request.getRequestDispatcher("register?method=findRegisterByPage").forward(request, response);
		}
	}

	// 查询单条记录
	public void findRegisterByRid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid = request.getParameter("rid");
		Register register = registerService.findRegisterByRid(rid);
		request.setAttribute("register", register);
		request.getRequestDispatcher("register/look.jsp").forward(request, response);
	}

	// 回显
	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid = request.getParameter("rid");
		String department = request.getParameter("department");
		List<Doctor> doctorList = doctorService.findDoctorsByDepartment(Integer.valueOf(department));
		Register register = registerService.findRegisterByRid(rid);
		request.setAttribute("register", register);
		request.setAttribute("doctorList", doctorList);
		request.getRequestDispatcher("register/edit.jsp").forward(request, response);
	}

	// 修改
	public void updateRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("hello");
		// 获取要添加的页面信息

		String rid = request.getParameter("rid");
		String name = request.getParameter("name");
		String idCard = request.getParameter("idCard");
		String siNumber = request.getParameter("siNumber");
		String registerMoney = request.getParameter("registerMoney");
		String phone = request.getParameter("phone");
		String isPay = request.getParameter("isPay");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String consultation = request.getParameter("consultation");
		String department = request.getParameter("department");
		String did = request.getParameter("did");
		String remark = request.getParameter("remark");

		// 封装挂号病人信息
		Register register = new Register(rid, name, idCard, siNumber, Double.valueOf(registerMoney), phone,
				Integer.valueOf(isPay), Integer.valueOf(sex), Integer.valueOf(age), Integer.valueOf(consultation),
				Integer.valueOf(department), Integer.valueOf(did), new Date(), remark);
		boolean flag = registerService.updateRegister(register);
		if (flag) {
			request.getRequestDispatcher("register?method=findRegisterByPage").forward(request, response);
		}
	}
	//批量删除
	public void delRegister(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("ids");
		boolean flag=registerService.delRegister(ids);
		if (flag) {
			request.getRequestDispatcher("register?method=findRegisterByPage").forward(request, response);
		}
	}
}
