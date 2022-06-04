import java.util.Random;

public class TestC2BranchPrediction {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        Random rand = new Random();
        for (int i = 0; i < 10000000L; i++) {
            int state = rand.nextInt(10);
            switch (state) {
                case 0: case 1:
                    conditionalBranch(true, true, false);
                    break;
                case 2:
                    conditionalBranch(false, false, true);
                    break;
                default:
                    conditionalBranch(false, true, false);
                    break;
            }
        }
    }

    public static void conditionalBranch(boolean flagA, boolean flagB, boolean flagC) {
        if (flagA) {
            marker("DO SOMETHING A");
        } else if (flagB) {
            marker("DO SOMETHING B");
        } else if (flagC) {
            marker("DO SOMETHING C");
        }
    }

    public static void marker(String message) {
        try { message.intern(); } catch (Exception e) { }
    }
}
