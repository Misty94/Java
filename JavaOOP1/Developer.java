import java.util.ArrayList;

public class Developer{
    // attributes (what it has)
    public String name;
    public ArrayList<String> languages = new ArrayList<String>();
    public ArrayList<Project> projects = new ArrayList<Project>();
    public int salary;
    public double hoursOfSleep;


    // methods (what it does)
    public void displayStatus(){
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
        System.out.println("Hours of sleep: " + this.hoursOfSleep);
        System.out.println("Language: " + this.languages);
        System.out.println("Projects :");
        for(Project eachProject: this.projects){
            eachProject.displayInfo();
        }
    }

    public void addProject(Project proj){
        this.projects.add(proj);
    }
}

// import java.util.ArrayList;
// public class Developer{
//     // attributes (what it has)
//     public String name;
//     public ArrayList<String> languages;
//     // projects
//     public ArrayList<Project> projects;
//     public int salary;
//     public double hoursOfSeleep;

//     // methods (what it does)\
//     public void displayStatus(){
//         System.out.println("Name: " + this.name);
//         System.out.println("Salary: " + this.salary);
//         System.out.println("Languages: " + this.languages);
//         System.out.println("Hours of Sleep: " + this.hoursOfSeleep);
//         System.out.println("Projects: " + this.projects);
//     }
// }
