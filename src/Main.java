//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        textAnalyser ta= new textAnalyser();
        System.out.println(ta.anagramCheck("a gentleman","elegant man"));
        System.out.println(ta.freqWords("good good good food food now", 2));
    }
}