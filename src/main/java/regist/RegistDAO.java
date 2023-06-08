package regist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RegistDAO {
	Connection conn = null; // 데이터베이스의 연결을 담당
	PreparedStatement pstmt; // 쿼리문의 실행을 담당
	Map<String,Regist> regists = new HashMap<>();

	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// DB 연결 메소드
	public void open() {
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); // DB연결 (URL,"계정","비밀번호")
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	// DB 연결 닫는 메소드
	public void close() {
		try {
			// pstmt, conn은 리소스(데이터를 읽고 쓰는 객체)임으로 사용 후 반드시 닫아줘야 한다.
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 학생 정보 전부 불러오기 메소드
	public ArrayList<Regist> getAll() {
		open(); // DB 연결
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM REGIST");
			
			// ResultSet : 데이터베이스 데이터를 받는 역할
			ResultSet rs = pstmt.executeQuery(); // 쿼리문실행 (executeQuery는 SELECT 사용 시 사용)
			
			while(rs.next()) { // 한 행씩 값이 있는지 판단해서 가져옴
				Regist r = new Regist();
				String id = rs.getString("id");
				
				r.setId(rs.getString("id"));// rs.getInt("컬럼명")
				r.setName(rs.getString("name"));
				r.setGrade(rs.getString("grade"));
				r.setAddress(rs.getString("address"));
				r.setPhone(rs.getString("phone"));
				
				regists.put(id,r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return new ArrayList<>(regists.values());
	}
	
	// 학생 정보 입력 메소드
	public void insert(Regist r) {
		open();
		try {
			// INSERT INTO REGIST VALUES(RG_SEQ.NEXTVAL,'김지우','서울시','SILVER','010-1111-1111');
			pstmt = conn.prepareStatement("INSERT INTO REGIST VALUES(RG_SEQ.NEXTVAL, ?, ?, ?, ?)");
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getGrade());
			pstmt.setString(4, r.getPhone());
			
			pstmt.executeUpdate(); // insert, delete, update 실행 시 실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public Regist find(String id) {
		return regists.get(id);
	}
}
