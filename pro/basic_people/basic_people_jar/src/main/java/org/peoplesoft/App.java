package org.peoplesoft;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.peoplesoft.dao.PersonDAO;
import org.peoplesoft.model.entities.BankAccount;
import org.peoplesoft.model.entities.Person;
import org.peoplesoft.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		Person person = new Person("Andia", "Victor");
		person.setDocumentType("CI");
		person.setDocumentNumber(87441865L);
		person.setBirthDate(new Date());

		// List<Person> persons = dao.getAllPersons();
		// for (Person personX : persons) {
		// System.out.println(personX);
		// }

		BankAccount ac1 = new BankAccount();
		ac1.setAccountNumber(5234591L);
		ac1.setBankName("Banco Sol");
		ac1.setOwner(person);
		
		BankAccount ac2 = new BankAccount();
		ac2.setAccountNumber(5234590L);
		ac2.setBankName("BNB");
		ac2.setOwner(person);

		List<BankAccount> accounts = new LinkedList<BankAccount>();
		accounts.add(ac1);
		accounts.add(ac2);
		person.setAccounts(accounts);

		// BankAccountDAO adao = new BankAccountDAO();
		// adao.save(ac1);

		PersonDAO dao = new PersonDAO();
		dao.save(person);

		HibernateUtil.shutdown();
		System.out.println("Fin!");
	}
}
