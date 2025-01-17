package Address_model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressDao {
	private static File file1 = new File("E:\\JH\\addr.dat");
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	private static ArrayList<AddressVo> aList = new ArrayList<>();
	public static int no = 1;
	
	public static File file2 = new File("E:\\JH\\address.txt");
	public static BufferedWriter bw;
	public static FileWriter fw;
	
	{
		try {
			fileload();
		} catch (ClassNotFoundException | IOException e) {}
	}

	public void add(AddressVo vo) {
		vo.setNo(no++);
		aList.add(vo);
	}

	public ArrayList<AddressVo> listAll() {
		ArrayList<AddressVo> aList2 = new ArrayList<>();
		for (int i = 0; i < aList.size(); i++) {
			AddressVo av = new AddressVo();
			av.setNo(aList.get(i).getNo());
			av.setName(aList.get(i).getName());
			av.setPhone(aList.get(i).getPhone());
			av.setAddr(aList.get(i).getAddr());
			av.setEmail(aList.get(i).getEmail());

			aList2.add(av);
		}
		return aList2;
	}

	public AddressVo search(AddressVo vo) {
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).getName().equals(vo.getName())) {
				AddressVo a = new AddressVo();
				a.setNo(aList.get(i).getNo());
				a.setName(aList.get(i).getName());
				a.setPhone(aList.get(i).getPhone());
				a.setAddr(aList.get(i).getAddr());
				a.setEmail(aList.get(i).getEmail());
				return a;
			}
		}
		return null;
	}

	public void edit(AddressVo vo) {
		if (vo == null)
			return;
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).getNo() == vo.getNo()) {
				aList.set(i, vo);
			}
		}
	}

	public void delete(AddressVo vo) {
		int i;
		if (vo != null) {
			i = aList.indexOf(vo);
			aList.remove(i);
		}
	}

	public void end() {
		System.out.println("프로그램을 종료합니다!");
		System.exit(0);
	}
	
	public void save() throws IOException, ClassNotFoundException {
		fos = new FileOutputStream(file1);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(aList);
		oos.close();
		
		fw = new FileWriter(file2);
		bw = new BufferedWriter(fw);

		for (int i = 0; i < aList.size(); i++) {
			AddressVo av = new AddressVo();
			av.setNo(aList.get(i).getNo());
			av.setName(aList.get(i).getName());
			av.setPhone(aList.get(i).getPhone());
			av.setAddr(aList.get(i).getAddr());
			av.setEmail(aList.get(i).getEmail());

			bw.write(av.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public void fileload() throws IOException, ClassNotFoundException {
		fis = new FileInputStream(file1);
		ois = new ObjectInputStream(fis);
		ArrayList<AddressVo> list2 = (ArrayList<AddressVo>) ois.readObject();
		aList.addAll(list2);
	}
}
