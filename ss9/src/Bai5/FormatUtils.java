package Bai5;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtils {
    private static final Locale VI_LOCALE = new Locale("vi", "VN");
    private static final NumberFormat NF = NumberFormat.getInstance(VI_LOCALE);

    public static String money(long value) {
        return NF.format(value);
    }
}

