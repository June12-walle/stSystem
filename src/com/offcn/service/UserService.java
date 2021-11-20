package com.offcn.service;

import javax.servlet.http.HttpSession;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;

public class UserService {
	UserDao userDao = new UserDao();		//newһ��dao��Ķ���

	// �����û���������
	public boolean checkLogin(User user, String verifyCode, HttpSession session) {
		User loginUser = userDao.findUserByUserNameAndPwd(user);
		// ��֤���ݿ��д��ڴ��û������û��������֤�������ɵ���֤�뱣��һ��
		if (loginUser != null) {
			session.setAttribute("user", loginUser);
			return true;
		}
		return false;
	}

	// ��֤����֤
	public boolean checkVerifyCode(String verifyCode, HttpSession session) {
		// ��session��ȡ�����ɵ���֤��
		String verCode = (String) session.getAttribute("verCode");
		// ��֤���ݿ��д��ڴ��û������û��������֤�������ɵ���֤�뱣��һ��
		if (verifyCode.equalsIgnoreCase(verCode)) {
			return true;
		}
		return false;
	}
	//��ѯ�û����Ƿ��ѱ�ע�ᣬҵ���߼�����
	public boolean checkUserName(String username) {
		User user=userDao.checkUserName(username);		//service�����dao��ķ���
		return user==null?false:true;		//true��ʾ���û������ݿ����ˣ���ע�����
	}
	//��ѯ�����Ƿ��ѱ�ע��
	public boolean checkEmail(String email) {
		User user=userDao.checkEmail(email);
		return user==null?false:true;
	}
	//ע��
	public boolean regist(User user) {
		return userDao.insertStudent(user)>0?true:false;
	}
}
