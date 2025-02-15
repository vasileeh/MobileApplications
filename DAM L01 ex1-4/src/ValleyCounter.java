public class ValleyCounter {
    public static void Counter(String s){
        int level=0, nr=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='U')
                level++;
            else
                if(s.charAt(i)=='D')
                    level--;


            if(i<s.length()-1)
                if(level==0 && s.charAt(i+1)=='U')
                    nr++;
            else
                if(level==0)
                    nr++;
        }
        System.out.println("Numarul de vai este: "+nr);
    }

    public static void main(String[] args) {
        String input="UDDDUDUU";
        Counter(input);
    }
}
