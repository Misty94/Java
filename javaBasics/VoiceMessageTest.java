import java.util.ArrayList;
class VoiceMessageTest {
    public static void main(String[] args){
        VoiceMessageUtil alexMachine = new VoiceMessageUtil();
        System.out.println(alexMachine.greeting());
        System.out.println(alexMachine.greeting("Alex"));
        System.out.println(alexMachine.greeting(10));
        System.out.println(alexMachine.getCurrentDate());

        // Fixed Array
        int[] messagesPerDay1 = new int[5]; // [0,0,0,0,0]
        messagesPerDay1[0] = 5;
        messagesPerDay1[1] = 8;
        messagesPerDay1[2] = 6;

        System.out.println("Total messages: " +alexMachine.totalMessages(messagesPerDay1));

        int[] messagesPerDay2 = { 5, 8, 6}; // length is 3

        for(int i = 0; i < messagesPerDay2.length; i++){
            System.out.println(messagesPerDay2[i]);
        }

        String[] messages = { "Please call back!", "Hello There", "Help debug!"};

        for(int i = 0; i < messages.length; i++){
            System.out.println(messages[i]);
        }

        alexMachine.printMessages(messages);
    }

    // Dynamic ArrayList
    // ArrayList<Data Type> varName = new ArrayList<Data Type>();
    ArrayList<String> messageArrayList = new ArrayList<String>();
    messageArrayList.add("Finish Alfred bot");
    messageArrayList.add("Finish Cafe Business Logic");
    messageArrayList.add("Read ahead for OOP");

    alexMachine.printMessages(messageArrayList);

    // type casting
    int days = 7;
    double cast = 10.01; // days * cost

    // no loss of data in conversion: implicit casting
    double totalCost = days * cost; // cost: double; day: int 7 -> double 7.00

    // loss of data in conversion: explicit casting

    int roundedTotalCost = days * (int) cost; // day: int ; cost: double -> int;     10.01 -> 10
    System.out.println(roundedTotalCost);

    
}