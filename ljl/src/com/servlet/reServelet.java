package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.replyDao;
import com.entity.reply;

public class reServelet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String rname = request.getParameter("name"); //��ȡjspҳ�洫�����Ĳ���
		String rem = request.getParameter("em");
		String rinfo = request.getParameter("info");
		
		reply r=new reply();
		r.setRname(rname);
		r.setRem(rem);
		r.setRinfo(rinfo);
		
		replyDao rd=new replyDao();
		rd.register(r);
		request.getRequestDispatcher("/hello.jsp").forward(request, response);  //ת������¼ҳ��
//		if(rd.register(r)){
//			//request.setAttribute("rname", rname);  //��request���з��ò���
//			//request.setAttribute("xiaoxi", "ע��ɹ�");
//			response.setHeader("refresh", "1");
//			//response.sendRedirect("/hello.jsp");//�ض�����ҳ
//		}else{
//			
//			response.sendRedirect("/hello.jsp");//�ض�����ҳ
//		}
	}
}
