package saram_test;

import java.util.List;

import saram_model.SaramDao;
import saram_model.SaramDto;

public class SaramDaoTest {

	public static void main(String[] args) {
		//testSaramSelectAll();
		//testSelectOne();
		//testInsert();
		//testUpdate();
		testDelete();
	}

	private static void testDelete() {
		SaramDto dto = new SaramDto(1, null, null, 0);
		SaramDao.delete(dto);
		testSaramSelectAll();
	}

	private static void testUpdate() {
		SaramDto dto = new SaramDto(3, "KIM", "Beomjoon", 45);
		SaramDao.update(dto);
		testSaramSelectAll();
	}

	private static void testInsert() {
		SaramDao.insert(new SaramDto(0, "test1", "name1", 15));
	}

	private static void testSelectOne() {
		SaramDto saram = SaramDao.selectOne(new SaramDto(1, null, null, 0));
		System.out.println(saram.toString());
	}

	private static void testSaramSelectAll() {
		List<SaramDto> list = SaramDao.selectAll();
		for(SaramDto saram : list) {
			System.out.println(saram);
		}
	}

}
