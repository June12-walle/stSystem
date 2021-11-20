package com.offcn.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.offcn.dao.DoctorDao;
import com.offcn.entity.Doctor;
import com.offcn.utils.PageTool;

public class DoctorService {
	DoctorDao doctorDao = new DoctorDao();

	// 分页查询医生信息
	public List<Doctor> findDoctorsByPage(PageTool pageTool) {
		return doctorDao.findDoctorsByPage(pageTool);
	}

	// 获取总记录数
	public int getTotalCount() {
		return doctorDao.getTotalCount();
	}

	// 根据编号查询单条记录
	public Doctor findDoctorByDid(int did) {
		return doctorDao.findDoctorsByDid(did);
	}

	// 根据编号修改医生记录
	public boolean updateDoctor(Doctor doctor) {
		return doctorDao.updateDoctor(doctor) > 0 ? true : false;
	}

	// 添加医生记录
	public boolean insertDoctor(Doctor doctor) {
		return doctorDao.insertDoctor(doctor) > 0 ? true : false;
	}

	// 删除医生记录
	public boolean delDoctor(String ids) {
		return doctorDao.delDoctor(ids) > 0 ? true : false;
	}

	// 分页查询医生信息
	public List<Doctor> findDoctorsByPage(Doctor doctor, PageTool pageTool) {
		return doctorDao.findDoctorsByPage(doctor, pageTool);
	}

	// 获取总记录数
	public int getTotalCount(Doctor doctor) {
		return doctorDao.getTotalCount(doctor);
	}

	// 根据科室号查询医生信息
	public List<Doctor> findDoctorsByDepartment(int department) {
		return doctorDao.findDoctorsByDepartment(department);
	}
}
