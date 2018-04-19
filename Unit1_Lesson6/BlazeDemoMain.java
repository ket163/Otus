import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazeDemoMain extends TestPrepare {

    String inputName = "Igor";
    String city = "Moscow";
    String address = "Moscow";
    String zipcode = "128188";
    String cardNumber = "1111222233334444";
    String cardMonth = "12";
    String cardYear = "2018";
    String nameOnCard = "Test Test";





    @Test

    public void BuyTicketTest () {

        driver.get("http://blazedemo.com/index.php");

        //Страница Choose
        ChooseFlight chooseFlight = new ChooseFlight(driver);
        ReserveFlight reserveFlight = new ReserveFlight(driver);
        PurchaseFlight purchaseFlight = new PurchaseFlight(driver);

        String titleTextCheck = "Flights from "
                + chooseFlight.selectDepartureText()
                + " to " + chooseFlight.selectDestinationText()
                + ":";



        chooseFlight.selectDeparture();
        chooseFlight.selectDestination();
        chooseFlight.clickFindFlightsButton();
        Assert.assertEquals(reserveFlight.getTitle(),titleTextCheck);


        //Страница Reserve
        String airlineText = reserveFlight.getAirlineText();
        String flightText = reserveFlight.getFlightNumberText();
        String priceText1 = reserveFlight.getPriceText();
        reserveFlight.clickChooseFlightButton();


//        //Страница Purchase

        Assert.assertTrue(purchaseFlight.getAirlineText().contains(airlineText));
        Assert.assertTrue(purchaseFlight.getFlightText().contains(flightText));
        Assert.assertTrue(purchaseFlight.getPriceText().contains(priceText1));
        Assert.assertEquals(purchaseFlight.getTotalCost(),purchaseFlight.getSumTotalCost());

        purchaseFlight.fillUpForm(inputName,city,address,zipcode,cardNumber,cardMonth,cardYear,nameOnCard);
        purchaseFlight.clickButton();


        //Страница Confirmation










    }
}
