public class NamTab {
  private String macro_name;
  private int start_macro;
  private int end_macro;

  public NamTab(String macro_name, int start_macro, int end_macro) {
    this.macro_name = macro_name;
    this.start_macro = start_macro;
    this.end_macro = end_macro;
  }

  public String getMacroName() {
    return this.macro_name;
  }

  public int getStartDefinition() {
    return this.start_macro;
  }

  public int getEndDefinition() {
    return this.end_macro;
  }

  public void setStartDefinition(int start_definition) {
    this.start_macro = start_definition;
  }

  public void setEndDefinition(int end_definition) {
    this.end_macro = end_definition;
  }
}
