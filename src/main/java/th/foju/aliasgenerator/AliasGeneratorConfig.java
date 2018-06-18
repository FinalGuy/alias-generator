package th.foju.aliasgenerator;

import static th.foju.aliasgenerator.syllables.PredefinedSyllableFile.FANTASY;

import th.foju.aliasgenerator.syllables.FileBasedSyllables;
import th.foju.aliasgenerator.syllables.SyllableFile;
import th.foju.aliasgenerator.syllables.SyllablesBasedNames;

public class AliasGeneratorConfig {

  private AliasGenerator aliasGenerator;

  public AliasGeneratorConfig() {
    init(FANTASY);
  }

  private void init(SyllableFile... syllableFiles) {
    FileBasedSyllables syllables = new FileBasedSyllables(syllableFiles);
    SyllablesBasedNames namePool = new SyllablesBasedNames(syllables);
    this.aliasGenerator = new AliasGenerator(namePool);
  }

  public void useSyllableFiles(SyllableFile... syllableFiles) {
    init(syllableFiles);
  }

  public AliasGenerator newInstance() {
    return aliasGenerator;
  }
}
