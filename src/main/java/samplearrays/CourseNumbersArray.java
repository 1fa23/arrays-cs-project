package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};


        int[] newRegestredCourses= new int[registeredCourses.length+1];
        for(int i=0;i<registeredCourses.length;i++){
            newRegestredCourses[i]=registeredCourses[i];

        }
        int newCourse=10;
        newRegestredCourses[registeredCourses.length]=newCourse;
        System.out.println("The courses : ");
        for(int i=0;i<newRegestredCourses.length;i++){
            System.out.println(newRegestredCourses[i]);
        }

        int specificCourse=2080;
        if(findCourse(newRegestredCourses,specificCourse)){
            System.out.println("The course exists");

        }
        else {
            System.out.println("The course does not exist");
        }



    }

    public static boolean findCourse(int[]courses,int courseNumber){
        for (int i=0;i<courses.length;i++){
            if(courses[i]==courseNumber){
                return true;
            }

        }

        return false;

    }
}
