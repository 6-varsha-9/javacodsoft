import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        int maxMarksPerSubject = 100; // Assuming maximum marks per subject is 100

        for (int i = 0; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1)+"(out of 100): ");
            int marks = scanner.nextInt();
            if (marks < 0 || marks > maxMarksPerSubject) {
                System.out.println("Marks should be between 0 and " + maxMarksPerSubject + ". Please enter valid marks.");
                i--; // Decrement i to repeat this subject's input
                continue;
            }
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
