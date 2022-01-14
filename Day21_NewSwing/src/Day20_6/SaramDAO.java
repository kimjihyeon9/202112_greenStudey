package Day20_6;

import java.util.Vector;

public class SaramDAO {
	// 일관성을 위해 여기에 옮겨뒀다
	private static Vector<SaramDTO> saramList = new Vector<SaramDTO>();
	static {
		saramList.add(new SaramDTO(1, "kim", "kim@aaa.com", "010-1111-1111"));
		saramList.add(new SaramDTO(2, "lee", "lee@aaa.com", "010-2222-2222"));
		saramList.add(new SaramDTO(3, "park", "park@aaa.com", "010-3333-3333"));
	}
	public static int sequence = 4;
	
	public Vector selectAll() {
		Vector vector = new Vector();
		for(int i = 0; i < saramList.size(); i++) {
			vector.add(saramList.get(i).toVector()); // toVector -> 데이터를 Vector로 넘겨주는 거 만듬
		}
		return vector;
	}
	
	public Vector selectList(SaramDTO saramDTO) {
		Vector vector = new Vector();
		for(int i = 0; i < saramList.size(); i++) {
			if(saramDTO.getName().equals(saramList.get(i).getName())) {
				vector.add(saramList.get(i).toVector());
			}
		}
		return vector;
	}

	public void insert(SaramDTO saramDTO) {
		if(saramDTO != null) {
			saramDTO.setIdx(sequence++);
			saramList.add(saramDTO);
		}
	}
	
	public Vector search(SaramDTO saramDTO) {
		Vector vector = new Vector();
		for(int i = 0; i < saramList.size(); i++) {
			if(saramDTO.getName().equals(saramList.get(i).getName())) {
				vector = saramList.get(i).toVector();
				return vector;
			}
		}
		return null;
	}
	
	public Vector modify(SaramDTO saramDto) {
		Vector vector = new Vector();		
		int index = 0;
		for(int i = 0; i<saramList.size(); i++) {
			if(saramDto.getIdx() == saramList.get(i).getIdx()) {
				index = i;
				saramList.set(index, saramDto);
			}
		}
		vector = saramList.get(index).toVector();
		return vector;
	}

	public Vector delete(SaramDTO saramDto) {
		Vector vector = new Vector();		
		int index = 0;
		for(int i = 0; i<saramList.size(); i++) {
			if(saramDto.getIdx() == saramList.get(i).getIdx()) {
				index = i;
				saramList.remove(index);
			}
		}
		vector = saramList.get(index).toVector();
		return vector;
	}

}
