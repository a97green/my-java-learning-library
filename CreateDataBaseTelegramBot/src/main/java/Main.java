import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Region.createBase(session);

        transaction.commit();
        sessionFactory.close();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(new File("src\\main\\resources\\tempIn")));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src\\main\\resources\\tempOut")));
//            String line = reader.readLine();
//            int i = 201;
//            while (line != null) {
//                writer.write(i + ";" + line + ";Центральный\n");
//                writer.write(i + ";" + line + ";Окраина\n");
//                i++;
//                line = reader.readLine();
//            }
//            writer.close();
//        }
//        catch (IOException e ) {
//            e.printStackTrace();
//        }
    }
}


