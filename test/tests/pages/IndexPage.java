package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements the behavior of the Index Page  
 * @author Andrew Pearson-Wood
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits: Login");
  }
  
  /**
   * Click on the logout button.
   */
  public void logout(){
    find("#logout").click();
  }
  
  /**
   * Click on the newContact button.
   */
  public void goToNewContact(){
    find("#newContact").click();
  }
  
  /**
   * Click on the login page.
   */
  public void goToLogin(){
    find("#login").click();
  }
  
  public boolean isLoggedIn(){
    return !find("#logout").isEmpty();
  }
  
}
