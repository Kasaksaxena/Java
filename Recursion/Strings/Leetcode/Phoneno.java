
// a problem we can use string mapping for storing
public class Phoneno {
    public static void main(String[] args){
        pad("" ,"23");
        System.out.println(" " +"\n");
        pad1("" ,"23");


    }
    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0';//convert '2'to 2
        for (int i =(digit-2)*3; i<(digit*2); i++) {
            char ch=(char)('a'+i);
            pad(p+ch,up.substring(1));
            
        }
    }


    
        static void pad1(String p, String up) {
            if (up.isEmpty()) {
                System.out.println(p);
                return;
            }
    
            int digit = up.charAt(0) - '0'; // Convert char '2' to int 2
    
            if (digit < 2 || digit > 9) {
                return; // Ignore invalid digits
            }
    
            int lettersCount = (digit == 7 || digit == 9) ? 4 : 3; // Digits 7 & 9 have 4 letters
            int startChar = (digit - 2) * 3 + ('a'); // Starting character for digit
    
            if (digit > 7) { // Adjust for 'pqrs' (7) and 'wxyz' (9)
                startChar++;
            }
    
            for (int i = 0; i < lettersCount; i++) {
                char ch = (char) (startChar + i);
                pad(p + ch, up.substring(1));
            }
        }
    
}
