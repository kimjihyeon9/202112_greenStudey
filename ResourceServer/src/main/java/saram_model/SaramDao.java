package saram_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import dbcp.JdbcUtil;



public class SaramDao {
   
   // 실행할 SQL 문
   public static final String SQL_SELECT = "SELECT * FROM SARAM";
   // 변수들어갈 자리에 '?'를 써서 preparedStatement를 사용해서 변수값을 넣어줌
   public static final String SQL_INSERT = "INSERT INTO SARAM (id, name, age) VALUES(?,?,?)";
   public static final String SQL_UPDATE = "UPDATE SARAM SET ID = ?, NAME =?, AGE =? WHERE NO = ?";
   public static final String SQL_DELETE = "DELETE FROM SARAM WHERE NO =?";
   public static final String SQL_SELECT_ONE_NO = "SELECT * FROM SARAM WHERE NO = ?";
   public static final String SQL_SELECT_ONE_ID = "SELECT * FROM SARAM WHERE ID = ?";
   public static final String SQL_SELECT_ONE_NAME = "SELECT * FROM SARAM WHERE NAME = ?";
   
   // SQL문 실행시킬 애 : Statement 객체
   public static Statement stmt = null;
   // 실행결과를 받는애가 ResultSet 객체
   public static ResultSet rs = null;
   // SQL문 ?에 값을 넣어주기위해 PreparedStatement 객체 사용
   public static PreparedStatement pstmt = null;
   public static Connection conn = null;
   public static List<SaramDto> selectAll() {
      List<SaramDto> list = new ArrayList<>();
      // table 내용 읽어오기
      // Statement, ResultSet, sql
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.createStatement();
         // result 값을 얻으려면 executeQuery를 써야 함.
         // rs는 Iterator와 비슷하여 반복하여 사용하도록 만들어짐
         rs = stmt.executeQuery(SQL_SELECT);
         while (rs.next()) {
            // 첫번째 필드의 1을 넣어도 되고 속성값을 넣어도됨.
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
            JdbcUtil.close(conn);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      }
      return list;
   }
   
   public static JSONArray selectAllJSONArr() {
      List<SaramDto> list = selectAll();
      JSONArray jsonArr = new JSONArray();
      for(int i = 0; i<list.size(); i++) {
         jsonArr.put(list.get(i).toJSONObject());
      }
      
      
      return jsonArr;
   }
   
   public static SaramDto selectOne(SaramDto dto) {
      SaramDto saram = null;
      // table 내용 읽어오기
      // Statement, ResultSet, sql
      conn = JdbcUtil.getConnection();
      try {
         // SQL 코드를 prepareStatement 객체에 넣어준다.
         pstmt = conn.prepareStatement(SQL_SELECT_ONE_NO);
         // pstmt에 들어갈 SQL문에 변수 값을 넣어줘야함
         // 물음표 순서, 변수값
         pstmt.setInt(1, dto.getNo()); // pstmt.set데이터타입(물음표 순서, 넣어줄 값);
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
            JdbcUtil.close(conn);
         } catch (SQLException e) {
            e.printStackTrace();
         }

      }
      return saram;
   }
   public static SaramDto selectById(SaramDto dto) {
      SaramDto saram = null;
      // table 내용 읽어오기
      // Statement, ResultSet, sql
      conn = JdbcUtil.getConnection();
      try {
         // SQL 코드를 prepareStatement 객체에 넣어준다.
         pstmt = conn.prepareStatement(SQL_SELECT_ONE_ID);
         // pstmt에 들어갈 SQL문에 변수 값을 넣어줘야함
         // 물음표 순서, 변수값
         pstmt.setString(1, dto.getId()); // pstmt.set데이터타입(물음표 순서, 넣어줄 값);
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
            JdbcUtil.close(conn);
         } catch (SQLException e) {
            e.printStackTrace();
         }

      }
      return saram;
   }
   
   public static List<SaramDto> selectByName(SaramDto dto) {
      List<SaramDto> list = new ArrayList<>();
      conn = JdbcUtil.getConnection();
      try {
         pstmt = conn.prepareStatement(SQL_SELECT_ONE_NAME);
         pstmt.setString(1, dto.getName());
         rs = pstmt.executeQuery();
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
            JdbcUtil.close(conn);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return list;
   }
   
   public static void insert(SaramDto dto) {
      conn = JdbcUtil.getConnection();
      try {
         pstmt = conn.prepareStatement(SQL_INSERT);
         pstmt.setString(1, dto.getId());
         pstmt.setString(2, dto.getName());
         pstmt.setInt(3, dto.getAge());
         // 입력, 수정, 삭제일때 executeUpdate를 사용 리턴값 : 처리된 횟수
         int cnt = pstmt.executeUpdate();
         if(cnt == 0) {
            System.out.println(">>> 입력 실패!");
            // 입력 실패하면 rollback()해줌 -> 처리하던걸 취소하겠다.
            conn.rollback();
         }
      } catch (SQLException e) {
         System.out.println("SQL 오류 ....");
         try {
            conn.rollback();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         e.printStackTrace();
      }finally {
         try {
         if(pstmt != null) pstmt.close();
         if(conn != null) JdbcUtil.close(conn);
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
      }
   }
   
   public static void update(SaramDto dto) {
      conn = JdbcUtil.getConnection();
      try {
         pstmt = conn.prepareStatement(SQL_UPDATE);
         pstmt.setString(1, dto.getId());
         pstmt.setString(2, dto.getName());
         pstmt.setInt(3, dto.getAge());
         pstmt.setInt(4, dto.getNo());
         int cnt = pstmt.executeUpdate();
         if(cnt == 0) {
            System.out.println(">>> UPDATE 실패!");
            conn.rollback();
         }
      } catch (SQLException e) {
         System.out.println("SQL 오류 ....");
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      }finally {
         try {
         if(pstmt != null) pstmt.close();
         if(conn != null) JdbcUtil.close(conn);
            } catch (SQLException e) {
               e.printStackTrace();
            }
      }
   }
   
   public static void delete(SaramDto dto) {
      conn = JdbcUtil.getConnection();
      try {
         pstmt = conn.prepareStatement(SQL_DELETE);
         pstmt.setInt(1, dto.getNo());
         int cnt = pstmt.executeUpdate();
         if(cnt == 0) {
            System.out.println(">>> DELETE 실패!");
            conn.rollback();
         }
      } catch (SQLException e) {
         System.out.println("SQL 오류 ....");
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      }finally {
         try {
         if(pstmt != null) pstmt.close();
         if(conn != null) JdbcUtil.close(conn);
            } catch (SQLException e) {
               e.printStackTrace();
            }
      }
   }
}