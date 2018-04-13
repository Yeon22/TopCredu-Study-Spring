package a.b.person;

public interface IPersonDAO {
	int insertUser(Person person);
	void deletePerson(int personID);
	void selectAllPerson();
	void selectPersonByName();
}
