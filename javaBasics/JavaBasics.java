public class JavaBasics {
    // attributes
    // methods
    public static void main(String[] args){
        // public: publically available
        // void: not returning anything
        // main: name of the method
        System.out.println("Hello Java");

        String firstName = "Alex";
        String lastName = "Miller";
        int age = 28;
        boolean isStudent = true;
        double weight = 152.7;
        char grade = 'A';  // In Java, double quotes & single quotes matter

        System.out.println(firstName + " " + lastName + " : " + age);
        System.out.println(age);
        System.out.println(isStudent);
        System.out.println(weight);
        System.out.println(Integer.MAX_VALUE);

        // Integer age2 = 38;

        if(weight < 100){ // condition has to be a boolean
            System.out.println("You need to gain some weight!");
        } else {
            System.out.println("You are perfect");
        }

        System.out.println(weight < 100 ? "Please gain some weight" : "You are perfect!");
                            // condition ? if-true statement : else statement
        
        String name = firstName.concat(lastName);
        System.out.println(name.length());
        System.out.println(name);

        String greeting = String.format("Hi %s, you are %d years old", firstName, age);
        System.out.println(greeting);
        System.out.printf("Hi %s, you are %d years old \n", name, age);

        String firstName1 = "Martha";
        String firstName2 = new String("Martha");
        String firstName3 = "Martha";

        System.out.println(firstName1 == firstName3); // true
        System.out.println(firstName1 == firstName2); // false (memory location)
        System.out.println(firstName1.equals(firstName2)); // true (compares elements)
    }
}

// 1. file name = class name
// 2. filename/class: PascalCase
// 3. methods/var: camelCase

// Double quotes is for strings & single quotes are for char