import org.hibernate.Session;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_acc")
    private String paymentAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public static void createBase(Session session) {
        String path = "C:\\Users\\user\\IdeaProjects\\java-repo\\telegram-bot\\src\\main\\resources\\payment.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String line = reader.readLine();
            String[] spLine;
            while (line != null) {
                Payment payment = new Payment();
                spLine = line.split(";");

                payment.setPaymentMethod(spLine[0]);
                payment.setPaymentAccount(spLine[1]);

                line = reader.readLine();

                session.save(payment);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
