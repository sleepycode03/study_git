import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class RSP {
    public static int player_total_score = 0;
    public static int com_total_score = 0;
    public static int player_save_score = 0;
    public static int com_save_score = 0;
    public static boolean reGame = true;
    public static int total_round = 30;
    public static String player_hand = "papers";
    public static String com_hand = "scissors";
    public static String[][] hand_num = {{"scissors", "0"}, {"rock", "1"}, {"paper", "2"}};

    public static String[] hand_group = {"scissors", "rock", "paper"};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException{
        if (reGame) {
            playGame();
        }
    }
    public static void playGame() throws IOException, InterruptedException{
        String input_player_hand;

        reset_all();
        graphic_controler();
        input_player_hand = get_player_hand();
    }

    public static void graphic_controler() throws IOException, InterruptedException{

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        
        System.out.printf("           %s                                     %s         \n" +
                           " ┏--------------------┓               ┏--------------------┓\n" +
                           "        %-8s             vs               %-8s         \n" +
                           " ┗--------------------┛               ┗--------------------┛\n" +
                           "           %s                                     %s        \n", player_total_score, com_total_score, player_hand, com_hand, player_save_score, com_save_score);
    }

    public static String get_player_hand() {
        String input_hand;
        while (true) {
            System.out.println("패를 선택해주세요 (rock, scissors, paper)");
            input_hand = sc.next();
            if(Arrays.asList(hand_group).contains(input_hand)) {
                return input_hand;
            } else {
                System.out.println("패가 잘못되었습니다.");
            }
        }
        
    }

    public static void reset_all() {
        player_total_score = 0;
        player_save_score = 0;
        com_total_score = 0;
        com_save_score = 0;
        reGame = true;

    }
}