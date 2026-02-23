import javax.swing.*;
import java.util.List;

public class TextAnalyserUI {

    public static void main(String[] args) {

        textAnalyser analyser = new textAnalyser();

        while (true) {
            String[] options = {
                    "Normalize Text",
                    "Word Frequency",
                    "Longest Substring",
                    "Anagram Check",
                    "Top-K Frequent Words",
                    "Exit"
            };

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose a Text Analysis Option",
                    "Text Analyser",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 5 || choice == -1) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;
            }

            switch (choice) {

                case 0: { // Normalize
                    String text = JOptionPane.showInputDialog("Enter text:");
                    if (text != null)
                        JOptionPane.showMessageDialog(null,
                                analyser.normaliseText(text));
                    break;
                }

                case 1: { // Word Frequency
                    String text = JOptionPane.showInputDialog("Enter text:");
                    if (text != null)
                        JOptionPane.showMessageDialog(null,
                                analyser.wordFrequency(text).toString());
                    break;
                }

                case 2: { // Longest Substring
                    String text = JOptionPane.showInputDialog("Enter string:");
                    if (text != null)
                        JOptionPane.showMessageDialog(null,
                                analyser.longest_substring(text));
                    break;
                }

                case 3: { // Anagram
                    String s1 = JOptionPane.showInputDialog("Enter first string:");
                    String s2 = JOptionPane.showInputDialog("Enter second string:");
                    if (s1 != null && s2 != null) {
                        boolean res = analyser.anagramCheck(s1, s2);
                        JOptionPane.showMessageDialog(null,
                                res ? "They are anagrams" : "They are NOT anagrams");
                    }
                    break;
                }

                case 4: { // Top-K
                    String text = JOptionPane.showInputDialog("Enter text:");
                    String kStr = JOptionPane.showInputDialog("Enter k:");
                    if (text != null && kStr != null) {
                        int k = Integer.parseInt(kStr);
                        List<String> result = analyser.freqWords(text, k);
                        JOptionPane.showMessageDialog(null, result.toString());
                    }
                    break;
                }
            }
        }
    }
}