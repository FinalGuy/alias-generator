package th.foju.aliasgenerator;

public class AliasGenerator {

  private final NamePool namePool;

  AliasGenerator(NamePool namePool) {
    this.namePool = namePool;
  }

  public String aliasFor(String keyString) {
    Key key = new HashCodeBasedKey(keyString);
    return namePool.nameFor(key).text();
  }
}
