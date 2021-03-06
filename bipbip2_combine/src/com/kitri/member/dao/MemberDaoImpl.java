package com.kitri.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


import com.kitri.member.model.MemberDto;
import com.kitri.util.db.DBClose;
import com.kitri.util.db.DBConnection;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	private MemberDaoImpl(){}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}


	@Override
	public int register(MemberDto memberDto) {
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "";
			sql += "insert into \n";
			sql += "member(id, pass, name, email, phone, addr1, addr2) \n";
			sql += "values (?, ?, ?, ?, ?, ?, ?) \n";
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(++idx, memberDto.getId());
			pstmt.setString(++idx, memberDto.getPass());
			pstmt.setString(++idx, memberDto.getName());
			pstmt.setString(++idx, memberDto.getEmail());
			pstmt.setString(++idx, memberDto.getPhone());
			pstmt.setString(++idx, memberDto.getAddr1());
			pstmt.setString(++idx, memberDto.getAddr2());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
		
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select id, pass, name \n");
			sb.append("from member \n");
			sb.append("where id = ? and pass = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("pass"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setPass(rs.getString("pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return memberDto;
	}


	@Override
	public int modify(MemberDto memberDto2) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update member\n");
			sql.append("set pass=?, email=?, addr1=?, addr2=? \n");
			sql.append("where id=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx =0;
			pstmt.setString(++idx, memberDto2.getPass());
			pstmt.setString(++idx, memberDto2.getEmail());
			pstmt.setString(++idx, memberDto2.getAddr1());
			pstmt.setString(++idx, memberDto2.getAddr2());
			pstmt.setString(++idx, memberDto2.getId());
			
			cnt += pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int delete(String id) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete member \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			cnt += pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	public MemberDto getMember(String id) {
		MemberDto memberDto2 = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from member \n");
			sql.append("where id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto2 = new MemberDto();
				memberDto2.setId(rs.getString("id"));
				memberDto2.setName(rs.getString("name"));
				memberDto2.setPass(rs.getString("pass"));
				memberDto2.setAddr1(rs.getString("addr1"));
				memberDto2.setAddr2(rs.getString("addr2"));
				memberDto2.setPhone(rs.getString("phone"));
				memberDto2.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDto2;
	}

	@Override
	public int idCheck(String id) {
		int count = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) \n");
			sql.append("from member \n");
			sql.append("where id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return count;
		
	}
}
