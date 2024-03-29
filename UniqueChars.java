/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String withoutDup = "" + s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Check if the current character is already in the result string
            if (withoutDup.indexOf(currentChar) == -1 || (currentChar == ' ')) {
                withoutDup += currentChar;
            }
        }

        return withoutDup;
    }


}