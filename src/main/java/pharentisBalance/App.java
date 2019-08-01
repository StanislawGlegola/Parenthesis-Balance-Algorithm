package pharentisBalance;

interface ParenthesisBalance {
    boolean parenthesisBalance();

}

public class App {
    public static void main(String[] args) {
        String curlyBracketsChain = "{}";
        CurlyBrackets balanceCurlyBrackets = new CurlyBrackets(curlyBracketsChain);
        balanceCurlyBrackets.parenthesisBalance();

        String roundBracketsChain = "(())";
        RoundBrackets balanceRoundBrackets = new RoundBrackets(roundBracketsChain);
        balanceRoundBrackets.parenthesisBalance();
    }
}

class CurlyBrackets implements ParenthesisBalance {

    private String curlyBracketChain;

    public CurlyBrackets(String curlyBracketChain) {
        this.curlyBracketChain = curlyBracketChain;
    }

    @Override
    public boolean parenthesisBalance() {
        char[] temp = curlyBracketChain.toCharArray();
        int counter = 0;

        if (curlyBracketChain.length() % 2 == 0) {
            for (int i = 0; i <= curlyBracketChain.length() - 1; i++) {
                if (temp[i] == '{') {
                    counter++;
                } else if (temp[i] == '}') {
                    counter--;
                    if (counter < 0) {
                        System.out.println("Curly Bracket order incorrect.");
                        return false;
                    }
                }
            }
        } else {
            System.out.println("Curly brackets number not even.");
            return false;
        }
        if (counter == 0) {
            System.out.println("Number of CURLY brackets correct.");
            return true;
        } else {
            System.out.println("Number of CURLY brackets incorrect.");
            return false;
        }
    }
}

class RoundBrackets implements ParenthesisBalance {

    private String roundBracketsChain;

    RoundBrackets(String roundBracketsChain) {
        this.roundBracketsChain = roundBracketsChain;
    }

    @Override
    public boolean parenthesisBalance() {
        char[] temp = roundBracketsChain.toCharArray();
        Stack stack = new Stack(20);

        if (roundBracketsChain.length() % 2 == 0) {
            for (int i = 0; i <= roundBracketsChain.length() - 1; i++) {
                if (temp[i] == '(') {
                    stack.push(1);
                } else if (temp[i] == ')') {
                    if (stack.stackIsEmpty()) {
                        System.out.println("Round brackets order incorrect.");
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        } else {
            System.out.println("Round brackets number not even");
            return false;
        }
        if (stack.stackIsEmpty()) {
            System.out.println("Number of ROUND brackets correct.");
            return true;
        } else {
            System.out.println("Number of ROUND brackets incorrect");
            return false;
        }
    }
}
