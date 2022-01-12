package member_model;

import java.util.Objects;

import javax.sound.midi.Sequence;

public class MemberDTO {
	private int idx;
	private String name;
	private String email;
	private String phone;
	
	public MemberDTO() { // 생성자 오버로딩
		this(0, "", "", "");
	}

	public MemberDTO(int idx, String name, String email, String phone) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
//		return idx + "\t" + name + "\t" + email + "\t" + phone;
		return String.format("%4d%10s%20s%20s", idx, name, email, phone); // format을 이용해서 조금더 편하게 구현
	}

	@Override
	public int hashCode() {
		return Objects.hash(idx);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		return idx == other.idx;
	}
	
	@Override
	protected Object clone(){ // DAO의 모든 참조를 DTO로 넘겨주고 DAO 참조를 끊으려고 만들었다(정보를 다 넘겼기 때문에)
		try {
			return new MemberDTO(idx, name, email, phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
