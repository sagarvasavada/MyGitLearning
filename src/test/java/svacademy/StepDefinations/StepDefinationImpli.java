package svacademy.StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import svacademy.PageObjects.CartPage;
import svacademy.PageObjects.CheckoutPage;
import svacademy.PageObjects.ConfirmationPage;
import svacademy.PageObjects.LandingPage;
import svacademy.PageObjects.ProductCatalogue;
import svacademy.TestComponents.BaseTest;

public class StepDefinationImpli extends BaseTest
{

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
    @Given ("I landed on Ecommerce Page")

    public void I_landed_on_Ecommerce_Page() throws IOException
    {

       landingPage = launchApplication();
    }

    @Given ("^Logged in with username (.+) and password (.+)$")

    public void Logged_in_username_and_password(String username, String password)
    {
        productCatalogue= landingPage.loginApplication(username, password);
    }
 
    @Given ("^When_I_add_product_(.+)_to_Cart$")

    public void When_I_add_product_to_Cart(String productName) throws InterruptedException
    {
        List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
    }

    @When ("^Checkout (*+) and submit the order$")

    public void Checkout_and_submit_the_order(String productName)
    {
        CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		//Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
    }

    @Then ("{string} message is displayed on ConfirmationPage")

    public void message_is_displayed_on_ConfirmationPage(String string)
    {
        String confirmMessage = confirmationPage.getConfirmationMessage();
		//Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}
