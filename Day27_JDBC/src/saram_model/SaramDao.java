package saram_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbcp.jdbcUtil;

public class SaramDao {
	// 테이블의 내용을 읽어 온다
	// Statement, ResultSet, sql
	public static final String SQL_SELECT = "SELECT * FROM SARAM";
	public static final String SQL_INSERT = "INSERT INTO SARAM(id, name, age)values(?,?,?)";
	public static final String SQL_UPDATE = "UPDATE SARAM SET ID=?, NAME=?, AGE=? WHERE NO=?";
	public static final String SQL_DELETE = "DELETE FROM SARAM WHERE NO=?";
	public static final String SQL_SELECT_ONE = "SELECT * FROM SARAM WHERE NO=?";
	public static final String SQL_SELECT_ID = "SELECT * FROM SARAM WHERE ID=?";
	public static final String SQL_SELECT_NAME = "SELECT * FROM SARAM WHERE NAME=?";

	public static Statement stmt = null; // 실행문 담는 아이
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null; // 실행결과를 담는 아이
	public static Connection conn = null;

	public static List<SaramDto> selectAll() {
		List<SaramDto> list = new ArrayList<SaramDto>();
		conn = jdbcUtil.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				list.add(new SaramDto(no, id, name, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static SaramDto selectOne(SaramDto dto) {
		conn = jdbcUtil.getConnection();
		SaramDto saram = null;

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				saram = new SaramDto(no, id, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saram;
	}

	public static SaramDto selectById(SaramDto dto) {
		conn = jdbcUtil.getConnection();
		SaramDto saram = null;

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ID);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				saram = new SaramDto(no, id, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saram;
	}

	public static List<SaramDto> selectByName(SaramDto dto) {
		conn = jdbcUtil.getConnection();
		SaramDto saram = null;

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_NAME);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				saram = new SaramDto(no, id, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saram;
	}

	public static void insert(SaramDto dto) {
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				System.out.println(">>> 입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류!");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(SaramDto dto) {
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setInt(4, dto.getNo());

			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				System.out.println(">>> 수정 실패!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(SaramDto dto) {
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, dto.getNo());

			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				System.out.println(">>> 삭제 실패!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				jdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
