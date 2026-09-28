package com.hotel.util;

import java.text.NumberFormat;
import java.util.Locale;

public class PriceUtil {

    public static String format(double price) {

        NumberFormat format =
                NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        return format.format(price);

    }

}