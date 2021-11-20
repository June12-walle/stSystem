package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.Doctor;
import com.offcn.utils.PageTool;

public class DoctorDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());

	// 分页查询医生信息
	public List<Doctor> findDoctorsByPage(PageTool pageTool) {
		String sql = "SELECT * FROM doctor LIMIT ?,?";
		try {
			return qRunner.query(sql, new BeanListHandler<Doctor>(Doctor.class), pageTool.getStartIndex(),
					pageTool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取总记录数
	public int getTotalCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM doctor";
		try {
			Long l = (Long) qRunner.query(sql, new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 根据编号查询单条记录
	public Doctor findDoctorsByDid(int did) {
		String sql = "SELECT * FROM doctor WHERE did=?";
		try {
			return qRunner.query(sql, new BeanHandler<Doctor>(Doctor.class), did);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 根据编号修改医生记录
	public int updateDoctor(Doctor doctor) {
		String sql = "UPDATE doctor SET NAME=?,cardno=?,phone=?,sex=?,age=?,birthday=?,email=?,department=?,education=?,remark=? WHERE did=?";
		try {
			return qRunner.update(sql, doctor.getName(), doctor.getCardno(), doctor.getPhone(), doctor.getSex(),
					doctor.getAge(), doctor.getBirthday(), doctor.getEmail(), doctor.getDepartment(),
					doctor.getEducation(), doctor.getRemark(), doctor.getDid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 添加医生记录
	public int insertDoctor(Doctor doctor) {
		String sql = "INSERT INTO doctor(NAME,cardno,phone,sex,age,birthday,email,department,education,remark) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			return qRunner.update(sql, doctor.getName(), doctor.getCardno(), doctor.getPhone(), doctor.getSex(),
					doctor.getAge(), doctor.getBirthday(), doctor.getEmail(), doctor.getDepartment(),
					doctor.getEducation(), doctor.getRemark());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 删除医生记录
	public int delDoctor(String ids) {
		String sql = "DELETE FROM doctor WHERE did IN(" + ids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 分页查询医生信息
	public List<Doctor> findDoctorsByPage(Doctor doctor, PageTool pageTool) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM doctor WHERE 1=1");
		if (doctor.getName() != null && !doctor.getName().equals("")) {
			sql.append(" AND Name like '%" + doctor.getName() + "%'");
		}
		if (doctor.getDepartment() != 0) {
			sql.append(" AND department = " + doctor.getDepartment());
		}
		sql.append(" LIMIT ?,?");
		try {
			return qRunner.query(sql.toString(), new BeanListHandler<Doctor>(Doctor.class), pageTool.getStartIndex(),
					pageTool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取总记录数
	public int getTotalCount(Doctor doctor) {
		int count = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM doctor WHERE 1=1");
		if (doctor.getName() != null && !doctor.getName().equals("")) {
			sql.append(" AND Name like '%" + doctor.getName() + "%'");
		}
		if (doctor.getDepartment() != 0) {
			sql.append(" AND department = " + doctor.getDepartment());
		}
		try {
			Long l = (Long) qRunner.query(sql.toString(), new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 根据科室号查询医生信息
	public List<Doctor> findDoctorsByDepartment(int department) {
		String sql = "SELECT * FROM doctor WHERE department=?";
		try {
			return qRunner.query(sql, new BeanListHandler<Doctor>(Doctor.class),department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
