package testing.mockito;

import org.junit.Test;
import static org.junit.Assert.*;
import testing.mockito.Portfolio;
import testing.mockito.Stock;
import testing.mockito.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by abilash on 1/11/16.
 */
public class PortfolioTest {

    @Test
    public void main(){
        //Create a portfolio object which is to be tested
        Portfolio portfolio = new Portfolio();

        //Creates a list of stocks to be added to the portfolio
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google", 10);
        Stock microsoftStock = new Stock("2","Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        StockService stockServiceMock = mock(StockService.class);

        when(stockServiceMock.getPrice(googleStock)).thenReturn(50.1);
        when(stockServiceMock.getPrice(microsoftStock)).thenReturn(1000.1);

        portfolio.setStockService(stockServiceMock);


        System.out.println("Google Stock Price = " + portfolio.getStockService().getPrice(googleStock));
        System.out.println("MS Stock Price = " + portfolio.getStockService().getPrice(microsoftStock));

        double actual = portfolio.getStockService().getPrice(googleStock);
        double expected = 50.1;
        double delta = 0.1; //??
        assertEquals(actual, expected, delta);
    }
}