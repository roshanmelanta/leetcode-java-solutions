import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchingRule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of items: ");
        int rows = input.nextInt();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter elements at row " + (i+1) + ": ");
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                temp.add(input.next());
            }
            list.add(temp);
        }
        System.out.print("Enter rule key: ");
        String ruleKey = input.next();
        System.out.print("Enter rule value: ");
        String ruleValue = input.next();
        System.out.println("Number of items matching given rule: "+ countMatches(list, ruleKey, ruleValue));

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // Solution 1
/*      int checker;
        int count = 0;
        if(ruleKey.equals("type")) {
            checker = 0;
        }
        else if(ruleKey.equals("color")) {
            checker = 1;
        }
        else {
            checker = 2;
        }

        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).get(checker).equals(ruleValue)) {
                count += 1;
            }
        }
        return count;       */

        //Solution 2
        int res = 0;
        for (int i = 0; i < items.size(); i++) {
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) res++;
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) res++;
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) res++;
        }
        return res;
    }
}
