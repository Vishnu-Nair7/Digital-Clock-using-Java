import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.Timer;

public class MyDigiClock extends JFrame  implements ActionListener{
 
    Container c;
    Calendar calendar;
    JLabel borderLabel;

    // Digi Variables
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel timeLabel, dayLabel, dateLabel;
    String time, day, date;

    //World Clock Variables
    JLabel worldcLabel, LondonTimeLabel, TokyoTimeLabel, DubaiTimeLabel, NYTimeLabel;
    JLabel cbTokyo, cbNewYork, cbLondon, cbDubai;
    SimpleDateFormat wcFormat;
    String LondonTime, TokyoTime, DubaiTime, NYTime;

    //Alarm Clock
    JLabel actimeLabel, hourLabel, minLabel, alarmLabel,borderLabel1, noteLabel;
    JButton setButton;
    JTextField hourField, minuteField;
    int alarmHour, alarmMinute;

    //Stopwatch
    JLabel stopwatchLabel = new JLabel("STOP WATCH");
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel swtimeLabel = new JLabel();
    int swelapsedTime = 0;
    int swseconds = 0;
    int swminutes = 0;
    int swhours = 0;
    boolean started = false;
    String swseconds_string = String.format("%02d", swseconds);
    String swminutes_string = String.format("%02d", swminutes);
    String swhours_string = String.format("%02d", swhours);
    
    Timer timer = new Timer(1000, new ActionListener() {
     
     public void actionPerformed(ActionEvent e) {
      
      swelapsedTime = swelapsedTime+1000;
      swhours = (swelapsedTime/3600000);
      swminutes = (swelapsedTime/60000) % 60;
      swseconds = (swelapsedTime/1000) % 60;
      swseconds_string = String.format("%02d", swseconds);
      swminutes_string = String.format("%02d", swminutes);
      swhours_string = String.format("%02d", swhours);
      swtimeLabel.setText(swhours_string + ":" + swminutes_string + ":" + swseconds_string);
      
     }
     
    });

    MyDigiClock(){


        c = getContentPane();
        c.setBackground(new Color(137, 219, 236));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Digital Clock App by Vishnu");
        setLayout(null);
        setSize(800,700);
        setResizable(false);
        setLocationRelativeTo(null);
        

        //Digital Clock
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        wcFormat = new SimpleDateFormat("hh:mm:ss a");
        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,48));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana",Font.ITALIC,25));
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana",Font.ITALIC,25));
        
        borderLabel = new JLabel();
        borderLabel1 = new JLabel();

        timeLabel.setBounds(225, 30, 350, 65);
        dayLabel.setBounds(230, 100, 200, 50);
        dateLabel.setBounds(400, 100, 200, 50);
        borderLabel.setBounds(0, 170, 800, 2);
        borderLabel1.setBounds(0, 380, 800, 2);

        Border division = BorderFactory.createLineBorder(Color.black, 5);
        borderLabel.setBorder(division);
        borderLabel1.setBorder(division);


        //World Clock
        worldcLabel = new JLabel("World Clock");
        worldcLabel.setFont(new Font("Calibri",Font.BOLD,40));
        LondonTimeLabel = new JLabel(); 
        TokyoTimeLabel = new JLabel("T");
        DubaiTimeLabel = new JLabel("B");
        NYTimeLabel = new JLabel("N");
        cbLondon = new JLabel("London");
        cbTokyo = new JLabel("Tokyo");
        cbDubai = new JLabel("Dubai");
        cbNewYork = new JLabel("New york");

        Font wtf = new Font("Verdana", Font.PLAIN, 18);
        Font cb = new Font("Times New Roman", Font.PLAIN, 30);

        cbTokyo.setFont(cb);
        cbTokyo.setBackground(new Color(255, 255, 204));
        cbLondon.setFont(cb);
        cbLondon.setBackground(new Color(255, 255, 204));
        cbDubai.setFont(cb);
        cbDubai.setBackground(new Color(255, 255, 204));
        cbNewYork.setFont(cb);
        cbNewYork.setBackground(new Color(255, 255, 204));
        LondonTimeLabel.setFont(wtf);
        TokyoTimeLabel.setFont(wtf);
        NYTimeLabel.setFont(wtf);
        DubaiTimeLabel.setFont(wtf);

        worldcLabel.setBounds(295, 180, 300, 60);
        cbLondon.setBounds(30, 270, 150, 30);
        cbTokyo.setBounds(225, 270, 150, 30);
        cbNewYork.setBounds(420, 270, 150, 30);
        cbDubai.setBounds(610, 270, 150, 30);
        LondonTimeLabel.setBounds(30, 310, 150, 30);
        TokyoTimeLabel.setBounds(225, 310, 150, 30);
        NYTimeLabel.setBounds(420, 310, 150, 30);
        DubaiTimeLabel.setBounds(610, 310, 150, 30);

        Border border = BorderFactory.createLineBorder(Color.black, 2);
        LondonTimeLabel.setBorder(border);
        TokyoTimeLabel.setBorder(border);
        NYTimeLabel.setBorder(border);
        DubaiTimeLabel.setBorder(border);


        //Alarm Clock
        noteLabel = new JLabel("note: enter hour and minutes in 24 hr format.");
        alarmLabel = new JLabel("ALARM");
        actimeLabel = new JLabel("L");
        hourLabel = new JLabel("Hour:");
        minLabel = new JLabel("Minute:");
        setButton = new JButton("Set Alarm");
        hourField = new JTextField(2);
        minuteField = new JTextField(2);

        Font al = new Font("Roboto", Font.PLAIN, 23);
        Font nal = new Font("Roboto", Font.ITALIC, 15);
        noteLabel.setBounds(46, 480, 320, 40);
        noteLabel.setFont(nal);
        alarmLabel.setBounds(155, 395, 120, 40);
        alarmLabel.setFont(cb);
        hourLabel.setBounds(40, 455, 80, 30);
        hourLabel.setFont(al);
        hourField.setBounds(100, 455, 30, 30);
        hourField.setFont(al);
        minLabel.setBounds(140, 455, 80, 30);
        minLabel.setFont(al);
        minuteField.setBounds(220, 455, 30, 30);
        minuteField.setFont(al);
        setButton.setBounds(260, 455, 100, 30);
        


        //Stop Watch
        stopwatchLabel.setBounds(495, 395, 220, 40);
        stopwatchLabel.setFont(cb);
        swtimeLabel.setBounds(490, 455, 210, 100);
        startButton.setBounds(490, 565, 100,50);
        resetButton.setBounds(600, 565, 100,50);

        swtimeLabel.setText(swhours_string + ":" + swminutes_string + ":" + swseconds_string);
        swtimeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        swtimeLabel.setBorder(BorderFactory.createBevelBorder(1));
        swtimeLabel.setOpaque(true);
        swtimeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        
        


        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String hourText = hourField.getText();
                String minuteText = minuteField.getText();

                alarmHour = Integer.parseInt(hourText);
                alarmMinute = Integer.parseInt(minuteText);

                setButton.setEnabled(false);
                hourField.setEnabled(false);
                minuteField.setEnabled(false);

                setTime();
            }
        });


        
        c.add(timeLabel);
        c.add(dayLabel);
        c.add(dateLabel);
        c.add(worldcLabel);
        c.add(borderLabel);
        c.add(borderLabel1);
        c.add(cbLondon);
        c.add(cbTokyo);
        c.add(cbNewYork);
        c.add(cbDubai);
        c.add(LondonTimeLabel);
        c.add(TokyoTimeLabel);
        c.add(DubaiTimeLabel);
        c.add(NYTimeLabel);
        c.add(stopwatchLabel);
        c.add(hourLabel);
        c.add(hourField);
        c.add(minLabel);
        c.add(alarmLabel);
        c.add(noteLabel);
        c.add(minuteField);
        c.add(setButton);
        c.add(swtimeLabel);
        c.add(startButton);
        c.add(resetButton);
        setVisible(true);

        while(true) 
        {
            setTime();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
     if(e.getSource() == startButton) {
      
      if(started == false) {
       started = true;
       startButton.setText("STOP");
       start();
      }
      else {
       started = false;
       startButton.setText("START");
       stop();
      }
      
     }
     if(e.getSource() == resetButton) {
      started = false;
      startButton.setText("START");
      reset();
     }
     
    }

    void start() 
    {
        timer.start();
       }
       
       void stop() 
       {
        timer.stop();
       }
       
       void reset() 
       {
            timer.stop();
            swelapsedTime = 0;
            swseconds =0;
            swminutes=0;
            swhours=0;
            swseconds_string = String.format("%02d", swseconds);
            swminutes_string = String.format("%02d", swminutes);
            swhours_string = String.format("%02d", swhours);       
            swtimeLabel.setText(swhours_string + ":" + swminutes_string + ":" + swseconds_string);
       }
      

    
    public void setTime() {
        
            int counter = 0;
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(" " + time);
            
            
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
        
            wcFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            LondonTime = wcFormat.format(GregorianCalendar.getInstance().getTime());
            LondonTimeLabel.setText(" " + LondonTime);
        
            wcFormat.setTimeZone(TimeZone.getTimeZone("Japan"));
            TokyoTime = wcFormat.format(GregorianCalendar.getInstance().getTime());
            TokyoTimeLabel.setText(" " + TokyoTime);
        
            wcFormat.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
            DubaiTime = wcFormat.format(GregorianCalendar.getInstance().getTime());
            DubaiTimeLabel.setText(" " + DubaiTime);
        
            wcFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            NYTime = wcFormat.format(GregorianCalendar.getInstance().getTime());
            NYTimeLabel.setText(" " + NYTime);

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);

            if (currentHour == alarmHour && currentMinute == alarmMinute) {
                while(counter == 0){
                    JOptionPane.showMessageDialog(this, "Alarm!");  
                    break;
                }
                counter++;
                setButton.setEnabled(true);
                hourField.setEnabled(true);
                minuteField.setEnabled(true);
            }

            actimeLabel.setText("Current Time: " + currentHour + ":" + currentMinute);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(c, e);
            }
        
    }


    public static void main(String[] args) {
        new MyDigiClock();
    }

}
