public class Time1Test {

   public static void main(String[] args) {
      // create and initialize a Time1 object
      Time1 time = new Time1(); // invokes Time1 constructor

      // output string representations of the time
      displayTime("After time object is created", time);
      System.out.println(); 

      // change time and output updated time 
      time.setTime(13, 27, 6); 
      displayTime("After calling setTime", time);
      System.out.println(); 

      // attempt to set time with invalid values
      try
      {
         time.setTime(99, 99, 99); // all values out of range
      } 
      catch (IllegalArgumentException e)
      {
         System.out.printf("Exception: %s%n%n", e.getMessage());
      } 

      // display time after attempt to set invalid values
      displayTime("After calling setTime with invalid values", time);
   } 

   // displays a Time1 object in 24-hour and 12-hour formats
   private static void displayTime(String header, Time1 t) {
      System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n",
         header, t.toUniversalString(), t.toString());
   } 
   
}


class Time1 {
   private int hour; // 0 - 23
   private int minute; // 0 - 59
   private int second; // 0 - 59

   // set a new time value using universal time; throw an 
   // exception if the hour, minute or second is invalid
   public void setTime(int hour, int minute, int second) {
      // validate hour, minute and second
      if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || 
         second < 0 || second >= 60) {
         throw new IllegalArgumentException(
            "hour, minute and/or second was out of range");
      }

      this.hour = hour;
      this.minute = minute;
      this.second = second;
   } 

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString() {
      return String.format("%02d:%02d:%02d", hour, minute, second);
   } 

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s", 
         ((hour == 0 || hour == 12) ? 12 : hour % 12),
         minute, second, (hour < 12 ? "AM" : "PM"));
   } 
}
