package com.concretepage;

import org.apache.ibatis.session.SqlSession;

public class VillageDAO {
	public void save(Village village) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		session.insert("com.concretepage.VillageMapper.insertVillage", village);
		session.commit();
		session.close();
	}
	
	public void update(Village village) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		session.update("com.concretepage.VillageMapper.updateVillage", village);
		session.commit();
		session.close();
	}
	
	public void delete(Integer id) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		session.delete("com.concretepage.VillageMapper.deleteVillage", id);
		session.commit();
		session.close();
	}
	
	public Village getData(Integer id) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		Village village = session.selectOne("com.concretepage.VillageMapper.selectVillage", id);
		session.close();
		
		return village;
	}
}
