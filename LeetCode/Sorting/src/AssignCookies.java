import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            // compare child's greed with size of cookie
            if (g[i] <= s[j]) {
                i++;
                j++;
            }
            // increase cookie size array pointer if current child's greed is greater than size of cookie
            else {
                j++;
            }
        }
        // return pointer at children's greed array, as it will give the number of children content
        return i;
    }
}
