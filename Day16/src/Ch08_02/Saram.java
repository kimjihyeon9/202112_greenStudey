package Ch08_02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Saram implements Externalizable {
	int no;
	String name;
	String email;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(no);
		out.writeUTF(name);
		out.writeUTF(email);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		no = in.read();
		name = in.readUTF();
		email = in.readUTF();
	}
	
	public Saram() {
		this(0, "", "");
	}
	
	public Saram(int no, String name, String email) {
		this.no =no;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Saram [no=" + no + ", name=" + name + ", email=" + email + "]";
	}

}
