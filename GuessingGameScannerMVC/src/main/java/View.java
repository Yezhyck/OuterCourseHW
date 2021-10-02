import java.util.LinkedList;

public class View {
    public static final String DOT = ".";
    public static final String COMA = ",";
    public static final String BRACKET_1 = "[";
    public static final String BRACKET_2 = "]";
    public static final String THAN = " THAN ";
    public static final String RANGE = "RANGE: ";
    public static final String ANSWER = "ANSWER: ";
    public static final String FIRST = "FIRST LIMIT:";
    public static final String SECOND = "SECOND LIMIT:";
    public static final String STATISTIC = "STATISTIC:";
    public static final String INPUT_NUMBER = "INPUT NUMBER MUST BE IN ";
    public static final String DUTY = "INPUT VALUE MUST BE AN INTEGER NUMBER.";
    public static final String INVALID_CHOICE = "INVALID CHOICE. TRY AGAIN.";
    public static final String MORE = "FIRST LIMIT MUST BE MORE THAN SECOND LIMIT.";
    public static final String START_GAME = "GOOD, LET'S START THE GAME. GUESS NUMBER IN ";
    public static final String TWO_LIMITS = "PLEASE, ENTER TWO LIMITS TO GENERATE GUESSED NUMBER.";
    public static final String CHOICE = "SET CUSTOM LIMITS OR USE DEFAULT. ENTER (1/2) ACCORDINGLY:";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPlayerAttempts(LinkedList<Integer> attempts, LinkedList<String> resultsOfAttempts) {
        for (int i = 0; i < attempts.size(); i++)
            System.out.println("ATTEMPT = " + attempts.get(i) +
                    ", RESULT = " + resultsOfAttempts.get(i));
    }
}
