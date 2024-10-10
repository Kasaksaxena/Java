public class Smallestletter{
    public static void main(String[] args) {
        char[] letter={'c','d','f','h','j'};
        char target='e';
        char ans=smallestletter(letter, target);
        System.out.println(ans);
        
        
    }
    static char  smallestletter(char[] letter,int target){
        
        int start=0;
        int end=letter.length-1;
        

        while(start<=end){
           int  mid=start+(end-start)/2;

          if(target<letter[mid]){
            end=mid-1;
          } 
          else{
            start=mid +1;
          } 

        }
    return letter[start%letter.length];

    }
}