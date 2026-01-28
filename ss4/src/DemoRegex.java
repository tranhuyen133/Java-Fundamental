import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegex {
    public static void main(String[] args) {

        // Ví dụ 1: [0-9]+A
        Pattern pattern1 = Pattern.compile("[0-9]+A");
        String checkRegex = "123A";
        Matcher matcher1 = pattern1.matcher(checkRegex);
        boolean result1 = matcher1.matches();
        System.out.println(result1);

        // Ví dụ 2: regex email basic
        // \w+@\w+\.\w{2,4}
        Pattern pattern2 = Pattern.compile("\\w+@\\w+\\.\\w{2,4}");
        String email = "phamthaison@gmail.com";
        Matcher matcher2 = pattern2.matcher(email);
        boolean result2 = matcher2.matches();

        System.out.println("Result: " + result2);
    }
}
