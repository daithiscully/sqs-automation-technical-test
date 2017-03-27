package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatter {

    public static double formatNumberToTwoDecimalPlaces(String numberToFormat) throws ParseException {
        // Deal with the comma separated digits
        NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
        Number number = format.parse(numberToFormat);
        double actualConvertedValue = number.doubleValue();

        // format to 2 decimal places
        DecimalFormat df=new DecimalFormat("0.00");
        String formattedNumber = df.format(actualConvertedValue);
        return (double) df.parse(formattedNumber);
    }

    public static double formatNumberToTwoDecimalPlaces(double numberToFormat) throws ParseException {
        // Deal with the comma separated digits
        NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
        Number number = format.parse(String.valueOf(numberToFormat));
        double actualConvertedValue = number.doubleValue();

        // format to 2 decimal places
        DecimalFormat df=new DecimalFormat("0.00");
        String formattedNumber = df.format(actualConvertedValue);
        return (double) df.parse(formattedNumber);
    }


}
