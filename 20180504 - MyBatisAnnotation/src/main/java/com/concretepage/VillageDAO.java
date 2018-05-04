package com.concretepage;

import org.apache.ibatis.session.SqlSession;

public class VillageDAO {
	public void save(Village village) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		mapper.insertVillage(village);
		session.commit();
		session.close();
	}
	
	public void update(Village village) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		mapper.updateVillage(village);
		session.commit();
		session.close();
	}
	
	public void delete(Integer id) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		mapper.deleteVillage(id);
		session.commit();
		session.close();
	}
	
	public Village getData(Integer id) {
		SqlSession session = MyBatisUtill.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		Village village = mapper.selectVillage(id);
		session.close();
		
		return village;
	}
}
