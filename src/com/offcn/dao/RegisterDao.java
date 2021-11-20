package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.Register;
import com.offcn.utils.PageTool;

public class RegisterDao {
	QueryRunner qRunner=new QueryRunner(new ComboPooledDataSource());
	//查询总记录数
	public int getTotalCount(Register register) {
		int count = 0;
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT COUNT(*) FROM register WHERE 1=1");
		if (register.getRid()!=null&&!register.getRid().equals("")) {
			sql.append(" AND rid = "+register.getRid());
		}
		if (register.getName()!=null&&!register.getName().equals("")) {
			sql.append(" AND Name like '%"+register.getName()+"%'");
		}
		if (register.getDepartment()!=0) {
			sql.append(" AND department = "+register.getDepartment());
		}
		try {
			Long l=(Long) qRunner.query(sql.toString(), new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//分页 
	public List<Register> findDoctorsByPage(Register register, PageTool pageTool) {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM register WHERE 1=1");
		if (register.getRid()!=null&&!register.getRid().equals("")) {
			sql.append(" AND rid = "+register.getRid());
		}
		if (register.getName()!=null&&!register.getName().equals("")) {
			sql.append(" AND Name like '%"+register.getName()+"%'");
		}
		if (register.getDepartment()!=0) {
			sql.append(" AND department = "+register.getDepartment());
		}
		sql.append(" LIMIT ?,?");
		try {
			return qRunner.query(sql.toString(), new BeanListHandler<Register>(Register.class),
					pageTool.getStartIndex(),pageTool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//添加操作
	public int insertRegister(Register register) {
		String sql="INSERT  INTO `register`(`rid`,`name`,`idcard`,`sinumber`,`registermoney`,`phone`,`ispay`,`sex`,`age`,`consultation`,`department`,`did`,`status`,`remark`,`registerdate`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return qRunner.update(sql,register.getRid(),register.getName(),register.getIdCard(),register.getSiNumber(),register.getRegisterMoney(),register.getPhone(),register.getIsPay(),register.getSex(),register.getAge(),register.getConsultation(),register.getDepartment(),
					register.getDid(),register.getStatus(),register.getRemark(),register.getRegisterDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//根据rid查询挂号人信息
	public Register findRegisterByRid(String rid) {
		String sql="SELECT * FROM `register` WHERE rid=?";
		try {
			return qRunner.query(sql, new BeanHandler<Register>(Register.class),rid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//修改
	public int updateRegister(Register register) {
		String sql="UPDATE register SET NAME=?,idCard=?,sinumber=?,registermoney=?,phone=?,ispay=?,sex=?,age=?,consultation=?,department=?,did=?,registerdate=?,remark=? WHERE rid=?";
		try {
			return qRunner.update(sql,register.getName(),register.getIdCard(),register.getSiNumber(),register.getRegisterMoney(),register.getPhone(),register.getIsPay(),register.getSex(),register.getAge(),register.getConsultation(),register.getDepartment(),
					register.getDid(),register.getRegisterDate(),register.getRemark(),register.getRid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//批量删除
	public int delRegister(String ids) {
		String sql="DELETE FROM register WHERE rid IN("+ids+")";
		try {
			return qRunner.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
