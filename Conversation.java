import java.util.Scanner;
import java.util.Random;

public class Conversation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String[] RandomResponses = {"Hmm.", "Okay", "Great!", "Uh-huh", "Sounds good", "HHHHHHH"};
        String[] mirroredWords = {"i", "me", "my", "am", "you", "your"};
        String[] mirroredResponses = {"you", "you", "your", "are", "I", "my"};
        System.out.print("How many rounds? ");
        int numRounds = input.nextInt();
        input.nextLine();
        System.out.println("Hi there! What's on your mind?");
        String transcript = "Hi there! What's on your mind?\n";
        int round = 1;
        while (round <= numRounds) {
            String userResponse = input.nextLine().toLowerCase();
            transcript += userResponse + "\n";
            String[] words = userResponse.split("\\s+");
            String Response = "";
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < mirroredWords.length; j++) {
                    if (words[i].equals(mirroredWords[j])) {
                        words[i] = mirroredResponses[j];
                        break;
                    }
                }
            }
            Response = String.join(" ", words);
            if (Response.equals(userResponse)) {
                Response = RandomResponses[rand.nextInt(RandomResponses.length)];
            }
            System.out.println(Response);
            transcript += Response + "\n";
            round++;
        }
        System.out.println("Thanks for chatting!");
        transcript += "Thanks for chatting!\n";
        System.out.println("\nTRANSCRIPT:");
        System.out.print(transcript);
    }
}