package th.foju.aliasgenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static th.foju.aliasgenerator.syllables.PredefinedSyllableFile.ELVES;
import static th.foju.aliasgenerator.syllables.PredefinedSyllableFile.GOBBLINS;

import org.junit.Before;
import org.junit.Test;

public class AliasGeneratorIntegrationTest {

  AliasGenerator cut;

  @Before
  public void setUp() {
    cut = new AliasGeneratorConfig().newInstance();
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

  @Test
  public void sollWeitereQuellenAkzeptieren() {
    AliasGeneratorConfig config = new AliasGeneratorConfig();
    config.useSyllableFiles(GOBBLINS);
    AliasGenerator goblinGenerator = config.newInstance();
    config.useSyllableFiles(ELVES);
    AliasGenerator elvenGenerator = config.newInstance();
    assertNotEquals(goblinGenerator.aliasFor("key"), elvenGenerator.aliasFor("key"));
  }
}