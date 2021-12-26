package p04.mvc_pattern;

import java.util.ArrayList;

public class Main_Book {
//mvc2모델 참고
	public static void main(String[] args) {
		//ArrayList<SampleDTO> findAll() 호출
		
		Sample_DAO sd = new Sample_DAO();
		ArrayList<SampleDTO> a = sd.findAll();
	
		
		//ArrayList<SampleDTO>에 들어있는 내용을 반복문을 통해 출력
			for(SampleDTO s : a) {
			System.out.println(s.getId()+ ", "+s.getName()+  " , "+s.getPrice());
		}
		
		
	}

}
