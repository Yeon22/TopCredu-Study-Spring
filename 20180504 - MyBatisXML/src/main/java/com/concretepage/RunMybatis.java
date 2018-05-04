package com.concretepage;

public class RunMybatis {

	public static void main(String[] args) {
		VillageDAO villageDAO = new VillageDAO();
		
		//insert
		Village village = new Village();
		village.setName("Crossing Republic");
		village.setDistrict("Ghaziabad");
		villageDAO.save(village);
		System.out.println("---Data saved---");
		
		//update
		village = new Village();
		village.setId(1);
		village.setName("Dhananjaypur");
		village.setDistrict("Varanasi");
		villageDAO.update(village);
		System.out.println("---Data updated---");
		
		//select
		village = villageDAO.getData(1);
		System.out.println("id : " + village.getId() + ", Name : " + village.getName() + ", District : " + village.getDistrict());
		
		//delete
		villageDAO.delete(1);
		System.out.println("---Data deleted---");
	}

}
