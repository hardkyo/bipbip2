package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.admin.model.PathDto;
import com.kitri.factory.MemberActionFactory;
import com.kitri.member.model.MemberDto;
import com.kitri.util.Constant;
import com.kitri.util.Encoding;
import com.kitri.util.NumberCheck;
import com.kitri.util.PageMove;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		<basic path>
		String root = request.getContextPath(); 
		String act = request.getParameter("act");
		String path = "/index.jsp";

		
		PathDto pathDto = new PathDto();
		pathDto.setContentPath("/main/main.jsp");
		if (act != null || !act.isEmpty()) {
			pathDto.setPath("/default.jsp");
		} else {
			pathDto.setPath("/index.jsp");
		}
//////////////////////////��ü �Ѱ��ؼ� �����ִ� �⺻���/////////////////////////////////
		
		
//		<login active logic>
		if ("mvlogin".equals(act)) {
			pathDto.setContentPath("/member/login.jsp");
			pathDto.setTitleHead("�α���");

			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(pathDto.getPath(), request, response);

			////// �α��� �������� �̵� ///////
			
		} else if ("mvjoin".equals(act)) {
			pathDto.setContentPath("/member/join.jsp");
			pathDto.setTitleHead("ȸ������");

			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(pathDto.getPath(), request, response);

			////// ȸ������ �������� �̵� //////
			
		} else if ("register".equals(act)) {
			path = MemberActionFactory.getRegisterAction().execute(request, response);
			// ȸ������ ���� ������ ���� ���丮 ����
			
			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(path, request, response); // ������ ���� ����ִ� ������ ��Ʈ�ѷ����� ������ jsp ���Ϸ� ����
			
			//// ȸ������ ���� ���� //////
			
		} else if ("login".equals(act)) {
			path = MemberActionFactory.getLoginAction().execute(request, response);
			// �α��� ���������� ���� ���丮 ����
			
			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(path, request, response); // ������ ���� ����ִ� ������ ��Ʈ�ѷ����� ������ jsp ���Ϸ� ����
			
			// �α��� ���� ���� // 
			
		} else if ("logout".equals(act)) {
			HttpSession session = request.getSession();
			session.invalidate(); // session ���� ������. 
			
			response.sendRedirect(root + path); // ������ ���� ����ִ� ������ ��Ʈ�ѷ����� ������ jsp ���Ϸ� ����
			
		} else if ("modify".equals(act)) {
			path = MemberActionFactory.getModifyAction().execute(request, response);
			
			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(path, request, response);


		} else if ("mvmodify".equals(act)) {
			pathDto.setContentPath("/member/modify.jsp");
			pathDto.setTitleHead("ȸ����������");
			
			path = MemberActionFactory.getMvmodifyAction().execute(request, response); 
			
			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(pathDto.getPath(), request, response); // ������ ���� ����ִ� ������ ��Ʈ�ѷ����� ������ jsp ���Ϸ� ����

		} else if ("memberdelete".equals(act)) {
			path = MemberActionFactory.getDeleteAction().execute(request, response);
			PageMove.forward(path, request, response);

		} else if ("idsearch".equals(act)) {
			path = MemberActionFactory.getIdcheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		
		} else if ("main".equals(act)) {
			pathDto.setContentPath("/main/exmain.jsp");
			pathDto.setHeadPath("/main/exmainhead.jsp");
			pathDto.setTitleHead("�����ſ���");

			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(pathDto.getPath(), request, response);

		} else if ("contact".equals(act)) {
			pathDto.setContentPath("/member/contact.jsp");
			pathDto.setTitleHead("���ǻ���");
			
			request.setAttribute("pathInfo", pathDto);
			PageMove.forward(pathDto.getPath(), request, response);
			
		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(Constant.DEFAULT_CHAR_SET);
		doGet(request, response);
	}

}