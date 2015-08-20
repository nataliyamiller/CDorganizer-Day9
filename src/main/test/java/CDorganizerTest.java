import org.junit.*;
import static org.junit.Assert.*;

public class CDorganizerTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void CDorganizer_instantiatesCorrectly_true {
    CDorganizer myCDorganizer = new CDorganizer("Great", "ABBA");
    assertEquals(true, myCDorganizer instance of CDorganizer);
  }

  @Test
  public void CDorganizer_instantiatesWithDescription_true() {
    CDorganizer myCDorganizer = new CDorganizer("Great", "ABBA");
    assertEquals("Great", myCDorganizer.getTitle());
    assertEquals("ABBA", myCDorganizer.getArtist());
  }

  @Test
  public void CDorganizer_returnsAllInstancesOfCDs_true() {
    CDorganizer firstCDorganizer = new CDorganizer("Great", "ABBA");
    CDorganizer secondCDorganizer = new CDorganizer("Wonderful", "Mikki");
    assertTrue(CDorganizer.all().contains(firstCDorganizer));
    assertTrue(CDorganizer.all().contains(secondCDorganizer));
  }

  @Test
  public void newID_CDIntantiatesWithAnID_true() {
    CDorganizer myCDorganizer = new CDorganizer("Great", "ABBA");
    assertEquals(CDorganizer.all().size(), myTask.getId());
  }

  @Test
  public void find_returnsCDWithSAmeID_secondCD() {
    CDorganizer firstCDorganizer = new CDorganizer();
    CDorganizer secondCDorganzier = new CDorganizer();
    assertEquals(CDorganizer.find(secondCDorganizer.getId()), secondCDorganizer);
  }

  @Test
  public void find_returnsNullWhenTaskNotFound_null() {
    assertTrue(CDorganizer.find(99) == null);
  }

  @Test
  public void clear_emptiesAllCDsFromArrayList(0 {
    CDorganizer myCDorganizer = new CDorganizer("Great", "ABBA");
    CDorganizer.clear();
    assertEquals(CDorganizer.all().size(), 0);
  })
}
