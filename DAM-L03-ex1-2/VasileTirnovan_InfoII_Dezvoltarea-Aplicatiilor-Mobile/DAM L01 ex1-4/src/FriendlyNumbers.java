public class FriendlyNumbers {
    public static void Friends(int a, int b){
        int s1=0, s2=0;
        for(int i=1;i<=a/2;i++)
            if(a%i==0)
                s1+=i;

        for(int i=1;i<=b/2;i++)
            if(b%i==0)
                s2+=i;

        if(s1==b && s2==a)
            System.out.println("Numerele sunt prietene");
        else
            System.out.println("Numerele NU sunt prietene");
    }

    public static void main(String[] args) {
        int a=220, b=284;
        Friends(a,b);
    }
}
