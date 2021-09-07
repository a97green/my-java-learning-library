import org.hibernate.Session;
import sun.text.normalizer.UCharacterIterator;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "clue")
    private int clue;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "region_name")
    private String regionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKey() {
        return clue;
    }

    public void setKey(int key) {
        this.clue = key;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public static void createBase(Session session) {
        String path = "src\\main\\resources\\region.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String line = reader.readLine();
            String[] splitLine;
            while (line != null) {
                Region region = new Region();
                splitLine = line.split(";");

                region.setKey(Integer.parseInt(splitLine[0]));
                region.setCityName(splitLine[1]);
                region.setRegionName(splitLine[2]);

                line = reader.readLine();

                session.save(region);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
