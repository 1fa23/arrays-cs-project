package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};


        int[] newRegestredCourses= new int[registeredCourses.length+1];
        System.arraycopy(registeredCourses, 0, newRegestredCourses, 0, registeredCourses.length);
        int newCourse=10;
        newRegestredCourses[registeredCourses.length]=newCourse;
        System.out.println("The courses : ");
        for (int newRegestredCours : newRegestredCourses) {
            System.out.println(newRegestredCours);
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
        for (int course : courses){
            if(course==courseNumber){
                return true;
            }

        }

        return false;

    }
}
