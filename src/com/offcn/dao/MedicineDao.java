package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.Medicine;
import com.offcn.utils.PageTool;

public class MedicineDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());

	// 获取所有记录数
	public int getTotalCount(Medicine medicine) {
		int count = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM medicine WHERE 1=1");
		if (medicine.getName() != null && !medicine.getName().equals("")) {
			sql.append(" AND Name like '%" + medicine.getName() + "%'");
		}
		if (medicine.getType() != 0) {
			sql.append(" AND type = " + medicine.getType());
		}
		try {
			Long l = (Long) qRunner.query(sql.toString(), new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 分页查询
	public List<Medicine> findDoctorsByPage(Medicine medicine, PageTool pageTool) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM medicine WHERE 1=1");
		if (medicine.getName() != null && !medicine.getName().equals("")) {
			sql.append(" AND Name like '%" + medicine.getName() + "%'");
		}
		if (medicine.getType() != 0) {
			sql.append(" AND type = " + medicine.getType());
		}
		sql.append(" LIMIT ?,?");
		try {
			return qRunner.query(sql.toString(), new BeanListHandler<Medicine>(Medicine.class),
					pageTool.getStartIndex(), pageTool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 添加新药
	public int insertMedicine(Medicine medicine) {
		String sql = "INSERT  INTO `medicine`(`mid`,`picture`,`inPrice`,`salPrice`,`name`,`type`,`descs`,`qualityDate`,`description`,`produceFirm`,`readme`,`remark`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return qRunner.update(sql, medicine.getMid(), medicine.getPicture(), medicine.getInPrice(),
					medicine.getSalPrice(), medicine.getName(), medicine.getType(), medicine.getDescs(),
					medicine.getQualityDate(), medicine.getDescription(), medicine.getProduceFirm(),
					medicine.getReadme(), medicine.getRemark());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 批量删除
	public int delMedicine(String ids) {
		String sql = "DELETE FROM medicine WHERE MID IN (" + ids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 根据药品编号查询药品详情
	public Medicine findMedicineByMid(String mid) {
		String sql = "SELECT * FROM medicine WHERE MID=?";
		try {
			return qRunner.query(sql, new BeanHandler<Medicine>(Medicine.class), mid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 修改药品信息
	public int updateMedicine(Medicine medicine) {
		String sql = "UPDATE medicine SET picture=?,inprice=?,salprice=?,NAME=?,TYPE=?,descs=?,qualitydate=?,description=?,produceFirm=?,readme=?,remark=? WHERE mid=?";
		try {
			return qRunner.update(sql, medicine.getPicture(), medicine.getInPrice(), medicine.getSalPrice(),
					medicine.getName(), medicine.getType(), medicine.getDescs(), medicine.getQualityDate(),
					medicine.getDescription(), medicine.getProduceFirm(), medicine.getReadme(), medicine.getRemark(),
					medicine.getMid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
