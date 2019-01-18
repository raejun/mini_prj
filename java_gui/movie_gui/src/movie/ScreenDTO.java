package movie;

import java.util.Date;

public class ScreenDTO {
   
   private String screenCode;
   private String screenName;
   private String movieCode;
   private String movieName;
   private String dayCode;
   private Date srtDate;
   private Date endDate;
   private Date runDay;
   private String srtTime;
   private String endTime; 
   
   public ScreenDTO() {
   }

   public ScreenDTO(String screenCode, String screenName, String movieCode, String movieName, String dayCode, Date srtDate, Date endDate, Date runDay, String srtTime,
         String endTime) {
      this.screenCode = screenCode;
      this.screenName = screenName;
      this.movieCode = movieCode;
      this.movieName = movieName;
      this.dayCode = dayCode;
      this.srtDate = srtDate;
      this.endDate = endDate;
      this.runDay = runDay;
      this.srtTime = srtTime;
      this.endTime = endTime;
   }

   public String getScreenCode() {
      return screenCode;
   }
   
   public void setScreenCode(String screenCode) {
      this.screenCode = screenCode;
   }
   
   public String getScreenName() {
      return screenName;
   }

   public void setScreenName(String screenName) {
      this.screenName = screenName;
   }
   
   public String getMovieCode() {
      return movieCode;
   }
   
   public void setMovieCode(String movieCode) {
      this.movieCode = movieCode;
   }
   
   public String getMovieName() {
      return movieName;
   }
   
   public void setMovieName(String movieName) {
      this.movieName = movieName;
   }

   public String getDayCode() {
      return dayCode;
   }

   public void setDayCode(String dayCode) {
      this.dayCode = dayCode;
   }

   public Date getSrtDate() {
      return srtDate;
   }

   public void setSrtDate(Date srtDate) {
      this.srtDate = srtDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   public Date getRunDay() {
      return runDay;
   }

   public void setRunDay(Date runDay) {
      this.runDay = runDay;
   }

   public String getSrtTime() {
      return srtTime;
   }

   public void setSrtTime(String srtTime) {
      this.srtTime = srtTime;
   }

   public String getEndTime() {
      return endTime;
   }

   public void setEndTime(String endTime) {
      this.endTime = endTime;
   }

   @Override
   public String toString() {
      return "ScreenDTO [screenCode=" + screenCode + ", screenName=" + screenName + ", movieCode=" + movieCode + 
            ", movieName=" + movieName + ", dayCode=" + dayCode + ", srtDate=" + srtDate + ", endDate="
            + endDate + ", runDay=" + runDay + ", srtTime=" + srtTime + ", endTime=" + endTime + "]";
   }

}