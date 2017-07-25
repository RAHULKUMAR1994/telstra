import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   public static void main( String args[] ) {
	   
	   
      String line = "This order was placed for QT3000! OK?";
      String pattern = "[A-Za-z]*";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find()) {
    	  
    	  System.out.println(m.end());
    	  
    	  System.out.println(m.groupCount());
         System.out.println("Found value: " + m.group(0) );

         
      }else {
         System.out.println("no match");;
      }
   }
}