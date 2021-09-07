import org.hibernate.Session;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_weight")
    private String weight;

    @Column(name = "product_price")
    private String price;

    @Column(name = "clue")
    private int key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static void createBase(Session session) {
        String path = "C:\\Users\\user\\IdeaProjects\\CreateDataBaseTelegramBot\\src\\main\\resources\\price.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String line = reader.readLine();
            String[] splitLine;
            while (line != null) {
                Price price = new Price();
                splitLine = line.split(";");

                price.setWeight(splitLine[1]);
                price.setPrice(splitLine[2]);
                price.setKey(Integer.parseInt(splitLine[0]));

                line = reader.readLine();

                session.save(price);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
