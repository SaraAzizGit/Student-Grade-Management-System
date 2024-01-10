import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static class Student {
        int ID, age, year;
        String fname;
        String lname;
        String sex;
        String semester;
        float CGPA;
        Course course;
        Grade grade;

        Student() {
            course = new Course();
            grade = new Grade();
        }
    }

    static class Course {
        float FMS;
        float OS;
        float AEE;
        float HCI;
    }

    static class Grade {
        float FMSg;
        float OSg;
        float AEEg;
        float HCIg;
    }

    static Student[] s;
    static int n;

    static void Student_Info() {
        System.out.print("\nEnter Number Of Students: ");
        n = input.nextInt();
        s = new Student[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Student();
            System.out.print("\nEnter Student " + (i + 1) + " First Name: ");
            s[i].fname = input.next();
            System.out.print("Enter Student " + (i + 1) + " Last Name: ");
            s[i].lname = input.next();
            System.out.print("Enter Student " + (i + 1) + " ID Number: ");
            s[i].ID = input.nextInt();
            System.out.print("Enter Student " + (i + 1) + " Gender: ");
            s[i].sex = input.next();
            System.out.print("Enter Student " + (i + 1) + " Age: ");
            s[i].age = input.nextInt();
            System.out.print("Enter Student " + (i + 1) + " Year: ");
            s[i].year = input.nextInt();
            System.out.print("Enter Student " + (i + 1) + " Semester: ");
            s[i].semester = input.next();
        }
    }

    static void CourseMark() {
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Student " + (i + 1) + " FMS Marks: ");
            s[i].course.FMS = input.nextFloat();
            System.out.print("Enter Student " + (i + 1) + " OS Marks: ");
            s[i].course.OS = input.nextFloat();
            System.out.print("Enter Student " + (i + 1) + " AEE Marks: ");
            s[i].course.AEE = input.nextFloat();
            System.out.print("Enter Student " + (i + 1) + " HCI Marks: ");
            s[i].course.HCI = input.nextFloat();
        }
    }

    static float CourseGrade(float mark) {
        float result;
        if (mark <= 100 && mark > 90) {
            result = 4.0f;
            System.out.println("A+");
        } else if (mark <= 90 && mark > 85) {
            result = 4;
            System.out.println("A");
        } else if (mark <= 85 && mark > 80) {
            result = 3.75f;
            System.out.println("A-");
        } else if (mark <= 80 && mark > 75) {
            result = 3.5f;
            System.out.println("B+");
        } else if (mark <= 75 && mark > 70) {
            result = 3;
            System.out.println("B");
        } else if (mark <= 70 && mark > 65) {
            result = 2.75f;
            System.out.println("B-");
        } else if (mark <= 65 && mark > 60) {
            result = 2.5f;
            System.out.println("C+");
        } else if (mark <= 60 && mark > 50) {
            result = 2;
            System.out.println("C");
        } else if (mark <= 50 && mark > 45) {
            result = 1.75f;
            System.out.println("C-");
        } else if (mark <= 45 && mark > 40) {
            result = 1.5f;
            System.out.println("D+");
        } else if (mark <= 40 && mark > 30) {
            result = 1;
            System.out.println("D");
        } else if (mark <= 30 && mark > 0) {
            result = 0;
            System.out.println("F");
        } else {
            System.out.println("Mark out of range.");
            result = 0;
        }
        return result;
    }

    static void Calculate_CGPA() {
        int credit = 5;
        int Tcredit = 20;
        float[] SumofGP = new float[2];
        for (int a = 0; a < n; a++) {
            if ((s[a].grade.FMSg != 0 && s[a].grade.OSg != 0) && (s[a].grade.AEEg != 0 && s[a].grade.HCIg != 0)) {
                SumofGP[a] = (s[a].grade.FMSg * credit) + (s[a].grade.OSg * credit) + (s[a].grade.AEEg * credit) + (s[a].grade.HCIg * credit);
            } else if (s[a].grade.FMSg == 0) {
                SumofGP[a] = (s[a].grade.OSg * credit) + (s[a].grade.AEEg * credit) + (s[a].grade.HCIg * credit);
            } else if (s[a].grade.OSg == 0) {
                SumofGP[a] = (s[a].grade.FMSg * credit) + (s[a].grade.AEEg * credit) + (s[a].grade.HCIg * credit);
            } else if (s[a].grade.HCIg == 0) {
                SumofGP[a] = (s[a].grade.FMSg * credit) + (s[a].grade.OSg * credit) + (s[a].grade.AEEg * credit);
            } else {
                SumofGP[a] = (s[a].grade.FMSg * credit) + (s[a].grade.OSg * credit) + (s[a].grade.HCIg * credit);
            }
            s[a].CGPA = SumofGP[a] / Tcredit;
        }
    }

    static void Display_GradeReport() {
        System.out.println("\n============================================================================");
        System.out.println("                         Student Grade Report:");
        System.out.println("============================================================================");
        for (int i = 0; i < n; i++) {
            System.out.println("Full Name: " + s[i].fname + " " + s[i].lname + "\t\tYear:" + s[i].year + "\t\tSemester: " + s[i].semester);
            System.out.println("Gender: " + s[i].sex + "\t\t" + "Age: " + s[i].age + "\n");
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    System.out.print("FMS:\t");
                    s[i].grade.FMSg = CourseGrade(s[i].course.FMS);
                } else if (j == 1) {
                    System.out.print("OS:\t");
                    s[i].grade.OSg = CourseGrade(s[i].course.OS);
                } else if (j == 2) {
                    System.out.print("AEE:\t");
                    s[i].grade.AEEg = CourseGrade(s[i].course.AEE);
                } else {
                    System.out.print("HCI:\t");
                    s[i].grade.HCIg = CourseGrade(s[i].course.HCI);
                }
            }
            Calculate_CGPA();
            System.out.println("\n>> CGPA = " + s[i].CGPA);
            Status(s[i].CGPA);
            System.out.println("============================================================================");
        }
    }

    static void Status(float sta) {
        if (sta == 4) {
            System.out.println("Status: Excellent");
        } else if (sta >= 3.75 && sta <= 3.99) {
            System.out.println("Status: Very Good");
        } else if (sta > 3.5 && sta <= 3.74) {
            System.out.println("Status: Good");
        } else if (sta > 3.49 && sta <= 3.25) {
            System.out.println("Status: Above Average");
        } else if (sta >= 2.0 && sta <= 3.24) {
            System.out.println("Status: Average");
        } else if (sta > 1.75 && sta <= 1.99) {
            System.out.println("Status: Satisfactory");
        } else if (sta > 1.00 && sta <= 1.74) {
            System.out.println("Status: Pass");
        } else if (sta > 0.0 && sta < 1.0) {
            System.out.println("Status: Fail");
        }
    }
}