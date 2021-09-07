import org.hibernate.Session;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany
    @JoinColumn(name = "clue")
    private List<Price> prices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public static void createBase(Session session) {
        String path = "C:\\Users\\user\\IdeaProjects\\CreateDataBaseTelegramBot\\src\\main\\resources\\product.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String line = reader.readLine();
            String[] separators;
            while (line != null) {
                Product product = new Product();
                separators = line.split(";");
                product.setName(separators[1]);

                line = reader.readLine();

                session.save(product);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
