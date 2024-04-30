import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static final Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int currentQuestionIndex = 0;

    private static Question[] questions = {
            new Question("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Berlin", "D. Madrid"}, 1),
            new Question("What is the largest planet in our solar system?", new String[]{"A. Jupiter", "B. Saturn", "C. Earth", "D. Mars"}, 0),
            new Question("Who wrote 'Romeo and Juliet'?", new String[]{"A. William Shakespeare", "B. Jane Austen", "C. Charles Dickens", "D. Mark Twain"}, 0),
            new Question("What is the chemical symbol for water?", new String[]{"A. H2O", "B. CO2", "C. NaCl", "D. O2"}, 0),
            new Question("Who painted the Mona Lisa?", new String[]{"A. Pablo Picasso", "B. Leonardo da Vinci", "C. Vincent van Gogh", "D. Michelangelo"}, 1)
    };

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz!\n");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                nextQuestion();
            }
        }, 15000); // 15 seconds for each question

        displayQuestion();
    }

    private static void displayQuestion() {
        Question currentQuestion = questions[currentQuestionIndex];
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());

        for (String option : currentQuestion.getOptions()) {
            System.out.println(option);
        }

        System.out.print("\nEnter your answer (A/B/C/D): ");
        String userAnswer = scanner.nextLine().toUpperCase();

        if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
            int userChoice = userAnswer.charAt(0) - 'A'; // Convert A/B/C/D to 0/1/2/3
            checkAnswer(userChoice);
        } else {
            System.out.println("Invalid choice! Please enter A, B, C, or D.");
            displayQuestion();
        }
    }

    private static void checkAnswer(int userChoice) {
        Question currentQuestion = questions[currentQuestionIndex];
        if (userChoice == currentQuestion.getCorrectAnswerIndex()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer is: " + currentQuestion.getOptions()[currentQuestion.getCorrectAnswerIndex()]);
        }

        nextQuestion();
    }

    private static void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            displayQuestion();
        } else {
            endQuiz();
        }
    }

    private static void endQuiz() {
        System.out.println("\nQuiz ended!");
        System.out.println("Your score: " + score + "/" + questions.length);
        scanner.close();
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
