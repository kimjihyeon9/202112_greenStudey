package org.constudy21.saram;

import org.constudy21.model.SaramVo;
import org.constudy21.model.SaramDao;

public class SaramDaoTest {
	public static SaramDao dao = new SaramDao();

	public static void main(String[] args) {
		
	}

	// DAO �׽�Ʈ delete
	public static void test_delete(String[] args) {
		dao.delete(new SaramVo(1, null, null, null));
		// ��ü���
		test_selectAll(null);
	}

	// DAO �׽�Ʈ update
	public static void test_update(String[] args) {
		SaramVo vo = dao.selectByNo(3);
		// no�� ��Ű�̹Ƿ� �������� �ʴ´�.
		vo.setName("PARK2");
		vo.setPhone("010-3333-3300");
		vo.setEmail("park2@comstudy.org");
		dao.update(vo);

		SaramVo saram = dao.selectOne(new SaramVo(0, "PARK2", null, null));
		System.out.println(saram);
	}

	// DAO �׽�Ʈ selectByNo
	public static void test_selectByNo(String[] args) {
		SaramVo saram = dao.selectByNo(3);
		System.out.println(saram);
	}

	// DAO �׽�Ʈ selectOne
	public static void test_selectOne(String[] args) {
		SaramVo vo = new SaramVo(0, "LEE", null, null);
		SaramVo saram = dao.selectOne(vo);
		System.out.println(saram);

	}

	// DAO�׽�Ʈ selectAll
	public static void test_selectAll(String[] args) {
		SaramDao dao = new SaramDao();
		SaramVo[] saramArr = dao.selectAll();
		for (SaramVo saram : saramArr) {
			System.out.println(saram);
		}

	}

}
