package th.foju.aliasgenerator;

import th.foju.aliasgenerator.syllables.FileBasedSyllables;
import th.foju.aliasgenerator.syllables.SyllablesBasedNames;

public class AliasGeneratorConfig {

  private AliasGenerator aliasGenerator;

  public AliasGeneratorConfig() {
    SyllablesBasedNames namePool = new SyllablesBasedNames(new FileBasedSyllables());
    this.aliasGenerator = new AliasGenerator(namePool);
  }

  public AliasGenerator newInstance(){
    return aliasGenerator;
  }
}
