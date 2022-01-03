package nitin.iO.fileOperations.csvDataReadOperations.corona;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author Created by nichaurasia
 * @create on Wednesday, September/30/2020 at 9:38 AM
 */

@Getter
@Setter
@ToString
public class Entity {
    private Date date;
    private int FIPS;
    private String county;
    private String state;
    private int confirmed;
    private int deaths;
    private int population;
    private String country;

    public Entity(Date date, Integer FIPS, String county, String state, Integer confirmed, Integer deaths, Integer population, String country) {
        this.date = date;
        this.FIPS = FIPS;
        this.county = county;
        this.state = state;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.population = population;
        this.country = country;
    }
}
