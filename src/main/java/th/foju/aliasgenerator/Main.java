package th.foju.aliasgenerator;

public class Main {

  public static void main(String[] arguments) {
    AliasGenerator aliasGenerator = new AliasGeneratorConfig().newInstance();
    System.out.println(aliasGenerator.aliasFor(arguments[0]));
  }

}
