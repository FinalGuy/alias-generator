package th.foju.aliasgenerator.syllables;

public enum PredefinedSyllableFile implements SyllableFile {

  FANTASY("/fantasy.txt"), ELVES("/elven.txt"), GOBBLINS("/goblin.txt"), ROMAN("/roman.txt");


  private final String resourceName;

  PredefinedSyllableFile(String resourceName) {
    this.resourceName = resourceName;
  }

  @Override
  public String resourceName() {
    return resourceName;
  }

}
