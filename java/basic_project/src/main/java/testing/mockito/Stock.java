package testing.mockito;

/**
 * Created by abilash on 1/11/16.
 */
public class Stock {
    String id;
    String company;
    int value;

    public Stock(String id, String company, int value) {
        this.id = id;
        this.company = company;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
