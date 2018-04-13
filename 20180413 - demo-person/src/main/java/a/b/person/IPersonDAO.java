package a.b.person;

public interface IPersonDAO {
	int insertUser(final Person person);
	int insertUse2(final Person person);
	void deletePerson(int personID);
	void selectAllPerson();
	void selectPersonByName();
}
