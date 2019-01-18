package movie;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class ScreenPanel extends JPanel {
   
   JTextField tfDayCode;
   JComboBox cbMovieName, cbScreenName;
   JPanel pSrtEndDate, pRunDay, pSrtEndTime;
   SpinnerDateModel dateModel, timeModel;
   Calendar calendar;
   Date start, end, date, time;
   JSpinner sSrtDate, sEndDate, sRunDay, sSrtTime, sEndTime;
   JButton btnInsert, btnUpdate, btnDelete;

   public ScreenPanel() {
      setLayout(new GridLayout(7, 2, 5, 5));
      
      calendar = Calendar.getInstance(); 
      date = calendar.getTime();

      calendar.add(Calendar.YEAR, -50);
      start = calendar.getTime();
      calendar.add(Calendar.YEAR, 100);
      end = calendar.getTime();
      
      time = new Date();
      tfDayCode =  new JTextField();
      dateModel = new SpinnerDateModel(date, start, end, Calendar.YEAR);
      timeModel = new SpinnerDateModel(time, null, null, Calendar.HOUR_OF_DAY);
      sSrtDate = new JSpinner(dateModel);
      sEndDate = new JSpinner(dateModel);
      sRunDay = new JSpinner(dateModel);
      sSrtTime = new JSpinner(timeModel);
      sEndTime = new JSpinner(timeModel);
      
      sSrtDate.setEditor(new JSpinner.DateEditor(sSrtDate, "yyyy-MM-dd"));
      sEndDate.setEditor(new JSpinner.DateEditor(sEndDate, "yyyy-MM-dd"));
      
      sRunDay.setEditor(new JSpinner.DateEditor(sRunDay, "yyyy-MM-dd"));
      sSrtTime.setEditor(new JSpinner.DateEditor(sSrtTime, "HH:mm")); 
      sEndTime.setEditor(new JSpinner.DateEditor(sEndTime, "HH:mm")); 
      
      pSrtEndDate.add(sSrtDate);
      pSrtEndDate.add(sEndDate);
      
      pRunDay.add(sRunDay);
      pSrtEndTime.add(sSrtTime);
      pSrtEndTime.add(sEndTime);
      
   }
   
   

}