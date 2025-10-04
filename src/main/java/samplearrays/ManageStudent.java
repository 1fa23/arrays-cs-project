package samplearrays;

@SuppressWarnings("ALL")
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
        for(Student student : students){
            if(student.getAge()>=18){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int sumGrade=0;
        for(Student student : students){
            sumGrade +=student.getGrade();
        }
        return (double)sumGrade/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for (int i=0;i<students.length;i++){
            for(int j=i;j<students.length;j++){
                if(students[i].getGrade()<students[j].getGrade()){
                    Student a=students[j];
                    students[j]=students[i];
                    students[i]=a;

                }

            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {


        for(Student student : students){
            if(student.getGrade()>=15){
                System.out.println(student);

            }
        }


    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student student : students){
            if(student.getId()==id){
                student.setGrade(newGrade);
                return true;
            }
        }

        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i=0;i<students.length;i++){
            for(int j=i+1;j<students.length;j++){
                if(students[i].getName().equalsIgnoreCase(students[j].getName())){
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

    public static Student[][] createSchool(Student[]  students){
        Student[][] school =new Student[2][3];
        int count=0;
        for(int i=0;i< school.length;i++){
            for(int j=0;j< school[i].length;j++){
                if(count<students.length){
                    school[i][j]=students[count];
                    count++;
                }


            }
        }

        return school;

    }

    public static   Student[] findTopStudent(Student[][] school){
        // we suppose that there is one topStudent in a class .
        Student[] topStudents=new Student[school.length];
        // the maximum number of top students is the number of the rows which the number of classes
        int count=0;
        for(int i=0;i< school.length;i++){
            int highestGrade=-1;
            for(int j=0;j<school[i].length;j++){
                if(school[i][j]!=null && school[i][j].getGrade()>highestGrade){
                    highestGrade=school[i][j].getGrade();
                }
            }

            for(Student student : school[i]){
                if(student!=null && student.getGrade()==highestGrade) {
                    topStudents[i] = student;



                }
            }


        }






        return topStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student student1=new Student(1,"farah");
        Student student2=new Student(2,"ibtissam");
        Student student3=new Student(3,"Sabah",18);
        Student student4=new Student(4,"khadija",19,16);
        Student student5=new Student(5,"malika",17);

        Student[] arr= {student1,student2,student3,student4,student5};


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldestStudent=findOldest(arr);
        System.out.println("Oldest Student : "+oldestStudent);



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
        sortByGradeDesc(arr);
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id

        // function
        int id=1;
        if (updateGrade(arr,id,18)){
            for(Student student : arr){
                if(student.getId()==id){
                    Student updated=student;
                    System.out.println("\nUpdated id=4? " + updated);

                }
            }

        }


        if(findStudentByName(arr, "Diana")==null){
            System.out.println("There is no student with the name Dina");
        }
        else {
            System.out.println(findStudentByName(arr, "Diana"));

        }

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

        // 11) Display the school :
        Student[][] school=createSchool(arr);
        System.out.println("school");

        for(int i=0;i<2;i++){
            System.out.println("class :" +i);
            for(int j=0;j<school[i].length;j++){
                if(school[i][j]!=null){
                    System.out.println(school[i][j]);
                }
            }
        }

        //find top student
        Student[] students= findTopStudent(school);
        for(int i=0;i<students.length;i++){
            System.out.println("Top student in class "+i+":"+students[i]);
        }







    }
}
