package th.foju.aliasgenerator;


import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import th.foju.aliasgenerator.syllables.SyllableModule;

public class AliasGenerator {

  private final NamePool namePool;

  @Inject
  AliasGenerator(NamePool namePool) {
    this.namePool = namePool;
  }

  public static AliasGenerator newInstance() {
    Injector injector = Guice.createInjector(new AliasGeneratorModule(), new SyllableModule());
    return injector.getInstance(AliasGenerator.class);
  }

  public String aliasFor(String keyString) {
    Key key = new HashBasedKey(keyString);
    return namePool.nameFor(key).text();
  }
}
