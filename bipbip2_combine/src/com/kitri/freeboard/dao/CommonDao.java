package com.kitri.freeboard.dao;

import java.util.Map;

import com.kitri.freeboard.model.FreeBoardDto;
import com.kitri.member.model.MemberDto;

public interface CommonDao {
	
	int getNextSeq();
	FreeBoardDto getArticle(int seq);
	
//	����¡ ó��
	int newArticleCount (int bcode);
	int totalArticleCount(Map<String, String> map);
	
	void updateHit (int seq);

	int plusUp(int seq);
	int plusdown(int seq);


	
	void updateHit(int seq, MemberDto loginInfo);
	MemberDto updateLoginInfo(MemberDto loginInfo);
}
