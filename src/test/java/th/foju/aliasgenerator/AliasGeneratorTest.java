package th.foju.aliasgenerator;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AliasGeneratorTest {

  AliasGenerator cut;

  @Mock
  NamePool namePool;

  @Before
  public void setUp() throws Exception {
    cut = new AliasGenerator(namePool);
  }

  @Test
  public void shouldCreateAliasUsingNamePool() {
    String key = "key";
    given(namePool.nameFor(key)).willReturn("name");
    String alias = cut.aliasFor(key);
    assertEquals(alias, "name");
  }
}