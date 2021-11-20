package com.offcn.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.offcn.dao.MedicineDao;
import com.offcn.entity.Medicine;
import com.offcn.utils.PageTool;

public class MedicineService {
	MedicineDao medicineDao = new MedicineDao();

	// 获取数据总条数
	public int getTotalCount(Medicine medicine) {
		return medicineDao.getTotalCount(medicine);
	}

	// 分页查询
	public List<Medicine> findDoctorsByPage(Medicine medicine, PageTool pageTool) {
		return medicineDao.findDoctorsByPage(medicine, pageTool);
	}

	// 添加新药
	public boolean insertMedicine(Medicine medicine) {
		return medicineDao.insertMedicine(medicine) > 0 ? true : false;
	}

	// 批量删除
	public boolean delMedicine(String ids) {
		return medicineDao.delMedicine(ids) > 0 ? true : false;
	}

	// 根据药品编号查询药品详情
	public Medicine findMedicineByMid(String mid) {
		return medicineDao.findMedicineByMid(mid);
	}
	//修改药品信息
	public boolean updateMedicine(Medicine medicine) {
		return medicineDao.updateMedicine(medicine) > 0 ? true : false;
	}

}
