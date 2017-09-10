package testing.mockito;

/**
 * Created by abilash on 1/11/16.
 */
public class Portfolio {
    StockService stockService;

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }
}
