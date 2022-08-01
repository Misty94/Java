import java.util.Date;
import java.util.ArrayList;
// import java.util.*
class VoiceMessageUtil {
    public String greeting(){
        return "Hi, anonymous!";
    }

    public String greeting(String name){
        return "Hi, " + name;
    }

    public String greeting(int count){
        return "Hi, count: " + count;
    }

    public String getCurrentDate(){
        Date today = new Date();
        return "Today is " + today;
    }

    public int totalMessages(int[] numArr){
        int sum = 0;
        for(int i = 0; i < numArr.length; i++){
            sum += numArr[i];
        }
        return sum;
    }

    public void printMessages(String[] msgArr){
        // traditional for loop
        for(int i=0; i<msgArr.length; i++){
            System.out.println(msgArr[i]);
        }
        // enhanced for loop
        for (String msg: msgArr){
            System.out.println(msg);
        }
    }

    public void printMessages1(ArrayList<String> msgArr){
        for(int i=0; i<msgArr.size(); i++){
            System.out.println(msgArr.get(i));
        }
    }
}