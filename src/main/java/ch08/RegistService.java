package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistService {
	Map<String, Regist> register = new HashMap<>();
	
	// db를 연결하지 않았음으로 생성자에서 객체를 생성해 데이터를 만듬.
	public RegistService() {
		Regist r1 = new Regist("101","김지우","서울시","silver","010-1111-1111");
		Regist r2 = new Regist("102","홍길동","인천시","gold","010-2222-2222");
		Regist r3 = new Regist("103","율곡","김포시","vip","010-3333-3333");
		
		register.put("101", r1);
		register.put("102", r2);
		register.put("103", r3);
	}
	
	// 모든 고객정보를 가져오는 메소드
	public ArrayList<Regist> findAll() {
		return new ArrayList<>(register.values());
	}
	
	// id로 원하는 고객 상세정보를 가져오는 메소드
	public Regist find(String id) {
		return register.get(id);
	}
}
