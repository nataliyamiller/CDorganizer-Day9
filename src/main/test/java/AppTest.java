import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }
  @ClassRule
public static ServerRule server = new ServerRule();

@Rule
  public ClearRule clearRule = new ClearRule();

@Test
public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Here is your CD Organizer");
}

@Test
public void cdTitleIsCreatedTest() {
  goTo("http://localhost:4567/");
  click("a", withText("Add a new CD"));
  fill("#title").with("Great");
  submit(".btn");
  assertThat(pageSource()).contains("Your CD has been saved.");
}

@Test
public void CDTitleIsDisplayedTest() {
goTo("http://localhost:4567/cds/new");
fill("#title").with("Wonderful");
submit(".btn");
click("a", withText("All CD's"));
assertThat(pageSource()).contains("Wonderful");
}

@Test
public void multipleCDTitlesAreDisplayedTest() {
  goTo("http://localhost:4567/cds/new");
  fill("#title").with("Great");
  submit(".btn");
  goTo("http://localhost:4567/cds/new");
  fill("#title").with("Wonderful");
  submit(".btn");
  click("a", withText("All CD's"));
  assertThat(pageSource()).contains("Great");
  assertThat(pageSource()).contains("Wonderful");
}
}
