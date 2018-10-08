package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.blogDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.entity.blog;

public class upblog extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //��ȡjspҳ�洫�����Ĳ���
		int id = Integer.parseInt(request.getParameter("id"));
		String info = request.getParameter("message");
		
		blog b=new blog();
		b.setBtitle(name);
		b.setUid(id);
		b.setBinfo(info);
		
		blogDao bd=new blogDao();
		
		if(bd.upblog(b)){
			//request.setAttribute("username", name);  //��request���з��ò���
			//request.setAttribute("xiaoxi", "ע��ɹ�");
			request.getRequestDispatcher("/blogServlet").forward(request, response);  //ת������¼ҳ��
		}else{
			
			response.sendRedirect("/leif.jsp");//�ض�����ҳ
		}
	}
}
