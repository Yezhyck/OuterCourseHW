import java.util.LinkedList;
import java.util.Random;

public class Model {
    private int start;
    private int end;
    private int answer;
    public static final int ZERO = 0;
    public static final int ONE_HUNDRED = 100;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final String MORE = "MORE";
    public static final String LESS = "LESS";
    public static final String EQUALS = "EQUALS";
    private LinkedList<Integer> attempts;
    private LinkedList<String> resultOfAttempts;

    public Model() {
        attempts = new LinkedList<>();
        resultOfAttempts = new LinkedList<>();
    }

    public Model(int firstLimit, int secondLimit) {
        attempts = new LinkedList<>();
        resultOfAttempts = new LinkedList<>();
    }

    public void setDefaultLimits() {
        start = ZERO;
        end = ONE_HUNDRED;
    }

    public boolean setCustomLimits(int firstLimit, int secondLimit) {
        if (firstLimit < secondLimit) {
            start = firstLimit;
            end = secondLimit;
            return true;
        }
        return false;
    }

    public void guessTheNumber() {
        if (start < end) answer = new Random().ints(1, start, end + 1).toArray()[0];
    }

    public boolean checkNumber(int inputNumber) {
        return inputNumber >= start && inputNumber <= end;
    }

    public String updateModel(int inputNumber) {
        String outputAnswer;
        if (inputNumber == answer) {
            outputAnswer = EQUALS;
        } else if (inputNumber > answer) {
            end = inputNumber - 1;
            outputAnswer = LESS;
        } else {
            start = inputNumber + 1;
            outputAnswer = MORE;
        }
        return outputAnswer;
    }

    public void configurePlayer(int value, String string) {
        addNewAttempt(value);
        addNewAttemptValue(string);
    }

    public void addNewAttempt(int value) {
        attempts.add(value);
    }

    public void addNewAttemptValue(String value) {
        resultOfAttempts.add(value);
    }

    public LinkedList<String> getResultOfAttempts() {
        return resultOfAttempts;
    }

    public void setResultOfAttempts(LinkedList<String> resultOfAttempts) { this.resultOfAttempts = resultOfAttempts; }

    public LinkedList<Integer> getAttempts() {
        return attempts;
    }

    public void setAttempts(LinkedList<Integer> attempts) {
        this.attempts = attempts;
    }

    public void setStart(int start) { this.start = start; }

    public void setEnd(int end) { this.end = end; }

    public int getStart() { return start; }

    public int getEnd() { return end; }

    public int getAnswer() { return answer; }
}
