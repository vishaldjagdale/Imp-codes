import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class Solution {
    public static int countStudents(ArrayList<Integer> arr, int pages){
        int n=arr.size();
        int students=1;
        long noOfPages=0; 
        for(int i=0;i<n;i++){
            if(noOfPages + arr.get(i) > pages){
                students++;
              noOfPages=arr.get(i);
            }
            else{
            
            noOfPages+=arr.get(i);
        }
        }
        return students;
        
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m > n) return -1;
        int low= Collections.max(arr);
        int high=0;
        for(int num : arr){
            high+=num;
        }
        while(low <=high){
            int mid=(low+ high)/2;
            int students=countStudents(arr, mid);
            if(students > m ){
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}