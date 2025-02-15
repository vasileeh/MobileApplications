public class NumericConverters {
    public static void Converter(String hex){
        int decimal = Integer.parseInt(hex, 16);
        System.out.println("Numarul decimal: " + decimal);
        }

    public static void main(String[] args) {
        String hex="1A3";
        Converter(hex);
    }
}
