package samplearrays;


public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int oldestIndex=0;
        for(int i=0;i<students.length;i++){
            if (students[i].getAge()>students[oldestIndex].getAge()){
                oldestIndex=i;
            }

        }

        Student oldest=students[oldestIndex];

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count=0;
        for(int i=0;i<students.length;i++){
            if(students[i].getAge()>=18){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int sumGrade=0;
        for(int i=0;i<students.length;i++){
            sumGrade +=students[i].getGrade();
        }
        return (double)sumGrade/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName() == name) {
                Student student = students[i];
                return student;
            }
        }

        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for (int i=0;i<students.length;i++){
            for(int j=0;j<i;j++){
                if(students[i].getGrade()>students[j].getGrade()){
                    Student a=students[i];
                    students[i]=students[j];
                    students[j]=a;

                }
                else {
                    Student a=students[j];
                    students[j]=students[i];
                    students[i]=a;

                }
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {

        System.out.println("the achievers : ");
        for(int i=0;i<students.length;i++){
            if(students[i].getGrade()>=15){
                System.out.println(students[i].getName());

            }
        }


    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(int i=0;i<students.length;i++){
            if(students[i].getId()==id){
                students[i].setGrade(newGrade);
                return true;
            }
        }

        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i=0;i<students.length;i++){
            for(int j=0;j<students.length;j++){
                if(students[i].getName()==students[j].getName()){
                    return true;
                }
            }
        }

        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents= new Student[students.length+1];
        for(int i=0;i<students.length;i++){
            newStudents[i]=students[i];

        }
        newStudents[newStudents.length-1]=newStudent;

        return newStudents;

    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student student1=new Student(1,"farah");
        Student student2=new Student(2,"ibtissam");
        Student student3=new Student(3,"Sabah",18);
        Student student4=new Student(4,"khadija",19,14);
        Student student5=new Student(3,"malika",17);

        Student[] arr= {student1,student2,student3,student4,student5};


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldestStudent=findOldest(arr);
        System.out.println(oldestStudent);



        // 3) Count adults
        int count=countAdults(arr);
        System.out.println(" The number of adults :"+count);


        // 4) Average grade

        double average=averageGrade(arr);
        System.out.println(" The average grade :"+average);


        // 5) Find by name
        Student findStudentByName=findStudentByName(arr,"farah");
        System.out.println(findStudentByName);


        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");

        printHighAchievers(arr);        // 8) Update grade by id
        // function
        if (updateGrade(arr,1,18)){
            Student updated=arr[1];
            System.out.println("\nUpdated id=4? " + updated);
        }

        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        if(hasDuplicateNames(arr)){
            System.out.println("There are duplicate names .");
        }
        else {
            System.out.println("There are no duplicate names .");
        }


        // 10) Append new student
        Student appendStudent= new Student(5,"diana");
        Student[] newArr= appendStudent(arr,appendStudent);
        for( Student student : newArr){
            System.out.println(student);
        }






    }
}
