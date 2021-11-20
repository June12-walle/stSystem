package com.offcn.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.entity.Medicine;
import com.offcn.service.MedicineService;
import com.offcn.utils.PageTool;

@WebServlet("/medicine")
@MultipartConfig
public class MedicineServlet extends BaseServlet {
	MedicineService medicineService = new MedicineService();

	// 分页查询药品信息
	public void findMedicineByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取查询条件
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		Medicine medicine = new Medicine(name);
		if (type != null) {
			medicine.setType(Integer.valueOf(type));
		}
		int totalCount = medicineService.getTotalCount(medicine);
		String currentPage = request.getParameter("currentPage");
		PageTool pageTool = new PageTool(totalCount, currentPage);
		List<Medicine> medicineList = medicineService.findDoctorsByPage(medicine, pageTool);
		request.setAttribute("medicine", medicine);
		request.setAttribute("pageTool", pageTool);
		request.setAttribute("medicineList", medicineList);
		request.getRequestDispatcher("/medicine/index.jsp").forward(request, response);
	}

	// 分页查询药品信息
	public void insertMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String picture = "";// 图片
		String inPrice = request.getParameter("inPrice");
		String salPrice = request.getParameter("salPrice");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String descs = request.getParameter("descs");
		String qualityDate = request.getParameter("qualityDate");
		String description = request.getParameter("description");
		String produceFirm = request.getParameter("produceFirm");
		String readme = request.getParameter("readme");
		String remark = request.getParameter("remark");
		// 获取上传图片文件头信息
		Part part = request.getPart("picture");
		String header = part.getHeader("Content-Disposition");
		picture = header.substring(header.lastIndexOf("filename") + 10, header.length() - 1);
		picture = UUID.randomUUID() + picture;
		String path = "E:/Hospital-pic";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		part.write(path + "/" + picture);
		Medicine medicine = new Medicine(mid, picture, Double.valueOf(inPrice), Double.valueOf(salPrice), name,
				Integer.valueOf(type), descs, Integer.valueOf(qualityDate), description, produceFirm, readme, remark);
		boolean flag = medicineService.insertMedicine(medicine);
		if (flag) {
			request.getRequestDispatcher("medicine?method=findMedicineByPage").forward(request, response);
		}
	}

	// 批量删除
	public void delMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		boolean flag = medicineService.delMedicine(ids);
		if (flag) {
			request.getRequestDispatcher("medicine?method=findMedicineByPage").forward(request, response);
		}
	}

	// 查询药品详情
	public void findMedicineByMid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		Medicine medicine = medicineService.findMedicineByMid(mid);
		request.setAttribute("medicine", medicine);
		request.getRequestDispatcher("/medicine/look.jsp").forward(request, response);
	}

	// 查询药品详情
	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		Medicine medicine = medicineService.findMedicineByMid(mid);
		request.setAttribute("medicine", medicine);
		request.getRequestDispatcher("/medicine/edit.jsp").forward(request, response);
	}

	// 修改药品信息
	public void updateMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String picture = "";// 图片
		String inPrice = request.getParameter("inPrice");
		String salPrice = request.getParameter("salPrice");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String descs = request.getParameter("descs");
		String qualityDate = request.getParameter("qualityDate");
		String description = request.getParameter("description");
		String produceFirm = request.getParameter("produceFirm");
		String readme = request.getParameter("readme");
		String remark = request.getParameter("remark");
		// 获取上传图片文件头信息
		Part part = request.getPart("picture");
		//如果没有修改图片则使用旧的图片
		if (part.getSize()==0) {
			picture=request.getParameter("oldpicture");
		}else {
			String header = part.getHeader("Content-Disposition");
			picture = header.substring(header.lastIndexOf("filename") + 10, header.length() - 1);
			picture = UUID.randomUUID() + picture;
			String path = "E:/Hospital-pic";
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			part.write(path + "/" + picture);
		}
		Medicine medicine = new Medicine(mid, picture, Double.valueOf(inPrice), Double.valueOf(salPrice), name,
				Integer.valueOf(type), descs, Integer.valueOf(qualityDate), description, produceFirm, readme, remark);
		boolean flag = medicineService.updateMedicine(medicine);
		if (flag) {
			request.getRequestDispatcher("medicine?method=findMedicineByPage").forward(request, response);
		}
	}

}
