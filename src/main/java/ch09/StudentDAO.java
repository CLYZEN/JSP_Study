package ch09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// model : 데이터베이스와 직접 연결 DAO , 컨트롤러에게 데이터를 넘겨줌

public class StudentDAO {
	Connection conn = null; // 데이터베이스의 연결을 담당
	PreparedStatement pstmt; // 쿼리문의 실행을 담당

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
	public ArrayList<Student> getAll() {
		open(); // DB 연결
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM STUDENT");
			
			// ResultSet : 데이터베이스 데이터를 받는 역할
			ResultSet rs = pstmt.executeQuery(); // 쿼리문실행 (executeQuery는 SELECT 사용 시 사용)
			
			while(rs.next()) { // 한 행씩 값이 있는지 판단해서 가져옴
				Student s = new Student();
				
				s.setId(rs.getInt("id"));// rs.getInt("컬럼명")
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return students;
	}
	
	// 학생 정보 입력 메소드
	public void insert(Student s) {
		open();
		try {
			pstmt = conn.prepareStatement("INSERT INTO STUDENT VALUES(ID_SEQ.NEXTVAL, ?, ?, ?, ?)");
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			pstmt.executeUpdate(); // insert, delete, update 실행 시 실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
}
