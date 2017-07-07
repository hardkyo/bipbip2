package com.kitri.freeboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import com.kitri.action.Action;
import com.kitri.freeboard.model.FreeBoardDto;
import com.kitri.freeboard.service.FreeBoardServiceImpl;
import com.kitri.member.model.MemberDto;

public class FreeBoardModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count = 0;
		String root = request.getContextPath();
		String path = "/board/freeboard.jsp";
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");

		int seq = Integer.parseInt(request.getParameter("seq"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println(subject + "\n ����Ʈ�� �� �� ���ñ�???");
		System.out.println(content + "\nffffffffffffffffffff");
		if (memberDto != null) { // �α��� �ߴٸ�
			FreeBoardDto boardDto = new FreeBoardDto();

			boardDto.setSeq(seq);
			boardDto.setSubject(subject);
			boardDto.setContent(content);

			count = FreeBoardServiceImpl.getService().modifyArticle(boardDto);
			if (count != 0) {
				request.setAttribute("seq", seq + "");
				JOptionPane.showMessageDialog(null, "���� ����!");
			} else {
				JOptionPane.showMessageDialog(null, "���� ����!");
			}
		}
		return path;
	}
}
