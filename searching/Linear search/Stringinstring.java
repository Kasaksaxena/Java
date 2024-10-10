

public class Stringinstring{
    public static void main(String[] args){
        String name="kunal";
        char target='u';
        boolean Ans=search(name,target);
        System.out.println(Ans);

    }

    static boolean search(String str,char target){
        if(str.length()==0){
            return false;
        }

        /*for(int i=0;i<str.length();i++){
            if(target== str.charAt(i)){
                return true;
            }
        }*/

       // enhanced for loop

       for(char ch:str.toCharArray()){
          if(ch==target){
            return true;
          }
       }
        return false;
    }
}