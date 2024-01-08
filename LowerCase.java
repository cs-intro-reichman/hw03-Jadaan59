/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
//  * Returns a string which is identical to the original string,
//  * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    * we assume that we make this proces on a single String
    */
    public static String lowerCase(String str) {
        String newstr = "";
        for (int i = 0; i < str.length(); i++){
            if ((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')){
              newstr += (char) (str.charAt(i)+32);
            }
            else {
                newstr += (char) str.charAt(i);
            }
        }
        return newstr;
    }
}