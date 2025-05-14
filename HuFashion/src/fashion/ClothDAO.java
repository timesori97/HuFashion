package fashion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//책임: 데이터베이스에 CRUD작업 수행 
public class ClothDAO {
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

   // DBMS주소:포트번호:데이터베이스 이름
   ClothDAO() {
      init();
   }
   
   

   private void init() {
      try {
         Class.forName(driver);
         // 라이브러리를 로드하는 의미
         // 이 라이브러리에는 오라클에 CRUD를 하기 위한 클래스들이 있음
         System.out.println("Oracle JDBC 드라이버 클래스 load 성공");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   

   public void insert(ClothDTO c) {
      try {
         // 연결하기
         Connection conn = DriverManager.getConnection(url, "system", "1111");
         System.out.println("oracle 데이터베이스 연결에 성공했습니다.");
         // 쿼리문 정의
         String sql = "insert into cloth values(?, ?, ?)";
         // statement 생성
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, c.getBrandName());
         stmt.setString(2, c.getClothType());
         stmt.setInt(3, c.getPrice());
         // 쿼리 전송 및 결과값 받기
         int result = stmt.executeUpdate();
         System.out.println(result + "건 삽입");
         // 연결 해제 - 자원반납
         stmt.close();
         conn.close();
      } catch (Exception e) {
         
      }
   }

   public ArrayList<ClothDTO> selectAll() {
      ArrayList<ClothDTO> clist = new ArrayList<>();
      try {
         // 연결 설정, 쿼리 만들기, 매핑, 쿼리 실행, 리턴값 받기
         Connection conn = DriverManager.getConnection(url, "system", "1111");
         System.out.println("oracle 데이터베이스 연결에 성공했습니다.");
         // 쿼리문 정의
         String sql = "select * from cloth";
         // statement 생성
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            ClothDTO c = new ClothDTO();
            c.setBrandName(rs.getString("brandname")); // id는 컬럼명
            c.setClothType(rs.getString("clothtype"));
            c.setPrice(rs.getInt("price"));
            clist.add(c);
         }

      } catch (Exception e) {

      }
      return clist;

   }

   public void delete(String deleteBrand) {
      try {
         // 연결하기
          Connection conn = DriverManager.getConnection(url, "system", "1111");
         System.out.println("oracle 데이터베이스 연결에 성공했습니다.");
         // 쿼리문 정의
         String sql = "delete from cloth where brandName=?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, deleteBrand);
         int result = stmt.executeUpdate();
         System.out.println(result + "건 삭제");
         stmt.close();
         conn.close();
         
         
      }catch(Exception e) {
         
      }
   }



   public void update(String brandName, String updateType, int updatePrice) {
      try {
         // 연결하기
          Connection conn = DriverManager.getConnection(url, "system", "1111");
         System.out.println("oracle 데이터베이스 연결에 성공했습니다.");
         // 쿼리문 정의
         String sql = "update cloth set clothType = ?, price = ? where brandName=?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, updateType);
         stmt.setInt(2, updatePrice);
         stmt.setString(3, brandName);
         int result = stmt.executeUpdate();
         
         System.out.println(result + "건 수정");
         stmt.close();
         conn.close();
         
         
      }catch(Exception e) {
         
      }
      
   }

}