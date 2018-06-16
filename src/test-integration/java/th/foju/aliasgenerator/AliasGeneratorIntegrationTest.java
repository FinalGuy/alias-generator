package th.foju.aliasgenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class AliasGeneratorIntegrationTest {

  AliasGenerator cut;

  @Before
  public void setUp() {
    cut = AliasGenerator.newInstance();
  }

  @Test
  public void sollNamenErzeugen() {
    testCreationWithKey("My String");
    testCreationWithKey("My other String");
    testCreationWithKey("Yet another String");
  }

  private void testCreationWithKey(String key) {
    String firstAlias = cut.aliasFor(key);
    String secondAlias = cut.aliasFor(key);
    assertNotEquals(key, firstAlias);
    assertEquals(firstAlias, secondAlias);
    System.out.println(firstAlias);
  }


}