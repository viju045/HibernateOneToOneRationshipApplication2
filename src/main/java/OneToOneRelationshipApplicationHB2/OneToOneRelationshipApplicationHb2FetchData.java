package OneToOneRelationshipApplicationHB2;

import OneToOneRelationshipApplicationHB2.model.Student;
import OneToOneRelationshipApplicationHB2.model.University;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.SocketOption;
import java.util.Iterator;
import java.util.List;

public class OneToOneRelationshipApplicationHb2FetchData {

    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

        TypedQuery query = session.createQuery("from Student student");
        List<Student> list = query.getResultList();
        Iterator<Student>iterator =  list.listIterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.getFirst_Name()+" "+student.getLast_Name()+" "+student.getCollege_Name()+" "+student.getCode());

            University university = student.getUniversity();
            System.out.println(university.getUniversity_Name()+" "+university.getUniversity_Address()+" "+university.getUniversity_Email());
        }
          session.close();
        System.out.println("Data has been retrive successfiully");

    }
}
