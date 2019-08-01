package pharentisBalance;

interface BracketBalance {
    boolean bracketBalance();
}

public class App {
    public static void main(String[] args) {
        String parenthisChain = "{}";
        CurlyBrace balancer = new CurlyBrace(parenthisChain);
        balancer.bracketBalance();
    }
}

class CurlyBrace implements BracketBalance {

    private String bracketChain;

    public CurlyBrace(String bracketChain) {
        this.bracketChain = bracketChain;
    }

    @Override
    public boolean bracketBalance() {
        char[] temp = bracketChain.toCharArray();
        int counter = 0;

        if (bracketChain.length() % 2 == 0) {
            for (int i = 0; i <= bracketChain.length() - 1; i++) {
                if (temp[i] == '{') {
                    counter++;
                } else if (temp[i] == '}') {
                    counter--;
                    if (counter < 0) {
                        System.out.println("Kolejnosc bledna.");
                        return false;
                    }
                }
            }
        } else {
            System.out.println("Liczba znakow nie parzysta.");
            return false;
        }
        if (counter == 0) {
            System.out.println("Liczba nawiasow poprawna.");
            return true;
        } else {
            System.out.println("Kolejnosc nawiasow bledna.");
            return false;
        }
    }
}