package OneToOneRelationshipApplicationHB2;


import OneToOneRelationshipApplicationHB2.model.Student;
import OneToOneRelationshipApplicationHB2.model.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;

public class OneToOneRelationshipApplicationHb2Application {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction txs = session.beginTransaction();

		Student student = new Student();
		student.setFirst_Name("vijay");
		student.setLast_Name("Mohite");
		student.setCollege_Name("PGMCOE");
		student.setCode("0049");

		University university = new University();
		university.setUniversity_Name("SPPU");
		university.setUniversity_Address("pune");
		university.setUniversity_Email("sppu@gmail.com");

		student.setUniversity(university);
		university.setStudent(student);

		session.persist(student);
		txs.commit();

		session.close();
		System.out.println("Successful Done");

	}

}
