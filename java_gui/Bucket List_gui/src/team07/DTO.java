package team07;

public class DTO {
   private String title;
   private String cont;
   private String pland;
   private String impled;
   private String feel;
   private String chek;
   private int rank;
   
   public int getRank() {
      return rank;
   }
   public void setRank(int rank) {
      this.rank = rank;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getCont() {
      return cont;
   }
   public void setCont(String cont) {
      this.cont = cont;
   }
   public String getPland() {
      return pland;
   }
   public void setPland(String pland) {
      this.pland = pland;
   }
   public String getImpled() {
      return impled;
   }
   public void setImpled(String impled) {
      this.impled = impled;
   }
   public String getFeel() {
      return feel;
   }
   public void setFeel(String feel) {
      this.feel = feel;
   }
   public String getChek() {
      return chek;
   }
   public void setChek(String chek) {
      this.chek = chek;
   }
   @Override
   public String toString() {
      return "DTO [rank=" + rank + ", title=" + title + ", cont=" + cont + ", pland=" + pland + ", impled=" + impled
            + ", feel=" + feel + ", chek=" + chek + "]";
   }
}