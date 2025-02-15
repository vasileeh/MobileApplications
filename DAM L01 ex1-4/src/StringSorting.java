public class StringSorting {
    public static String Sort(String s) {
        char rez[] = new char[s.length()];
        int j=0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                rez[j++] = s.charAt(i);
            }

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                rez[j++] = s.charAt(i);
            }

        return new String(rez);
    }

    public static void main(String[] args) {
        String input = "hElLoWoRLd";
        String sorted = Sort(input);
        System.out.println("Output: " + sorted);
    }
}
