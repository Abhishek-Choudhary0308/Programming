public class Problem21_StringRotation {
    public static void main(String[] args) {
        String a = "ABCD";
        String b = "CDAB";

        System.out.println("Rotation: " + isRotation(a, b));
    }

    static boolean isRotation(String a, String b) {
        return a != null && b != null
                && a.length() == b.length()
                && (a + a).contains(b);
    }
}