package testing.mockito;

/**
 * Created by abilash on 1/11/16.
 */
public class StockService {
    double getPrice(Stock stock){
        return stock.getValue() * 1.5;
    }
}
