import java.util.ArrayList;
public class DeveloperTest{
    public static void main(String[] args){
        System.out.println("---- Developer Test ----");
        Developer dev1 = new Developer();
        dev1.name = "Alex Miller";
        dev1.salary= 100000;
        dev1.hoursOfSleep = 6;
        dev1.languages.add("Python");
        dev1.languages.add("Java");
        
        // create 2 projects to put into the dev1
        Project project1 = new Project();
        project1.title = "iShelter";
        project1.language = "Python";
        dev1.addProject(project1);
        dev1.displayStatus();



    }
}





// import java.util.ArrayList;
// public class DeveloperTest{
//     public static void main(String[] args){
//         System.out.println("---- Developer Test -----");
//         Developer dev1 = new Developer();
//         dev1.name = "Misty Strickland";
//         dev1.salary = 130000;
//         dev1.hoursOfSleep = 6;
//         dev1.languages = new ArrayList<String>();
//         dev1.languages.add("Python");
//         dev1.languages.add("Java");

//         Project project1 = new Project();
//         project1.title
//     }
// }