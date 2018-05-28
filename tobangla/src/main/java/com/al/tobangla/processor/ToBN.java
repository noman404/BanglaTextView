package com.al.tobangla.processor;

import android.annotation.SuppressLint;

import com.al.tobangla.utils.ProcessType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Noman on 15/6/2015.
 *
 * @author al.noman.uap@gmail.com
 *
 * Converter class that provide conversion methods to achieve the BN data
 */
public class ToBN {

    private static final String DD_MM_YYYY = "dd/MM/yyyy";
    private static final String HH_MM_SS = "HH:mm:ss";
    private static final String invalidFormat = "Invalid Format";

    private static volatile ToBN mInstance = null;

    //initializing vars
    private ToBN() {
    }

    //instantiating with thread safe mechanism
    public static ToBN getInstance() {
        if (mInstance == null) {
            synchronized (ToBN.class) {
                if (mInstance == null) {
                    mInstance = new ToBN();
                }
            }
        }
        return mInstance;
    }

    /*
    * Provides the converted number as String in BANGLA (UTF-8)
    * @param text formatted String EN-US
    * @throws NumberFormatException
    * @return date in BN UTF-8
    */
    private String changeByChar(final String text) throws NumberFormatException {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            //convert each numeric character to bangla
            formatted.append(numberConverter(text.charAt(i)));
        }
        return formatted.toString();
    }

    /*
    * Convert EN-US Days to BN
    * @param day in String EN-US
    * @return day in String UTF-8
    */
    public String getDay(final String day) {

        switch (day.toLowerCase().trim()) {
            case "sunday":
                return "রবিবার";
            case "monday":
                return "সোমবার";
            case "tuesday":
                return "মঙ্গলবার";
            case "wednesday":
                return "বুধবার";
            case "thursday":
                return "বৃহস্পতিবার";
            case "friday":
                return "শুক্রবার";
            case "saturday":
                return "শনিবার";
            default:
                return day;
        }
    }

    /*
    * Convert EN-US number characters to Bangla
    * @param character EN-US
    * @return BN numeric character
    */
    private char numberConverter(final char en) {

        switch (en) {
            case '1':
                return '১';
            case '2':
                return '২';
            case '3':
                return '৩';
            case '4':
                return '৪';
            case '5':
                return '৫';
            case '6':
                return '৬';
            case '7':
                return '৭';
            case '8':
                return '৮';
            case '9':
                return '৯';
            case '0':
                return '০';
            default:
                return en;
        }
    }

    /*
    * get todays' date in bangla
    * @return date in String UTF-8
    */
    public String getTodayDate() {
        return changeByChar(new SimpleDateFormat(DD_MM_YYYY, Locale.getDefault()).format(Calendar.getInstance().getTime()));
    }

    /*
    * get today's name in bangla
    * @return day in String UTF-8
    */
    public String getToday() {
        return getDay(new SimpleDateFormat("EEEE", Locale.getDefault()).format(Calendar.getInstance().getTime()));
    }

    /*
    * get any timestamp in bangla
    * @param time in String EN-US
    * @return time in String UTF-8
    */
    public String getTime(final String time) {
        return changeByChar(time);
    }

    /*
    * get any date in bangla
    * @param date in String EN-US
    * @return date in String UTF-8
    */
    public String getDate(final String time) {
        return changeByChar(time);
    }

    /*
    * get current time in bangla
    * @return time in String UTF-8
    */
    @SuppressLint("SimpleDateFormat")
    public String getCurrentTime() {
        return changeByChar(new SimpleDateFormat(HH_MM_SS).format(Calendar.getInstance().getTime()));
    }


    /*
    * Ordinal Indicators corresponds to the suffixes -st, -nd, -rd, -th
    * @param the targer number pattern with those suffixes
    * @param calendar type | normal type
    * @return in BN
    */
    public String getOrdinalIndicator(final String text, final ProcessType mode) {

        switch (mode) {
            case ORDINAL_INDICATOR_FOR_DATE:
                return processForDateTypeOrdinalIndicator(text);
            case ORDINAL_INDICATOR_FOR_NUMERIC_ORDER:
                return processForNumericOrdinalIndicator(text);
            default:
                return invalidFormat;
        }
    }

    /*
    * @param Month name as String or From System in MMMM pattern
    * @return Month in BN
    */
    public String getMonth(final String month) {

        switch (month.toLowerCase().trim()) {

            case "january":
            case "jan":
                return "জানুয়ারী";

            case "february":
            case "feb":
                return "ফেব্রুয়ারি";

            case "march":
            case "mar":
                return "মার্চ";

            case "april":
            case "apr":
                return "এপ্রিল";

            case "may":
                return "মে";

            case "june":
            case "jun":
                return "জুন";

            case "july":
            case "jul":
                return "জুলাই";

            case "august":
            case "aug":
                return "অগাস্ট";

            case "september":
            case "sep":
                return "সেপ্টেম্বর";

            case "october":
            case "oct":
                return "অক্টোবর";

            case "november":
            case "nov":
                return "নভেম্বর";

            case "december":
            case "dec":
                return "ডিসেম্বর";
            default:
                return invalidFormat;
        }
    }

    /*
    * @param Month name as String or From System in MMMM pattern
    * @return Month in BN
    */
    public String getMonthByNumber(final String month) {

        switch (Integer.parseInt(month)) {
            case 1:
                return "জানুয়ারী";
            case 2:
                return "ফেব্রুয়ারি";
            case 3:
                return "মার্চ";
            case 4:
                return "এপ্রিল";
            case 5:
                return "মে";
            case 6:
                return "জুন";
            case 7:
                return "জুলাই";
            case 8:
                return "অগাস্ট";
            case 9:
                return "সেপ্টেম্বর";
            case 10:
                return "অক্টোবর";
            case 11:
                return "নভেম্বর";
            case 12:
                return "ডিসেম্বর";
            default:
                return invalidFormat;
        }
    }

    /*
    * @param Targer number in [0-9]+  -st, -nd, rd, -th
    * @return in BN format normal format
    */
    private String processForNumericOrdinalIndicator(String text) {

        int number = Integer.parseInt(text.replaceAll("\\D+", ""));

        if (number == 0 || number > 10) {
            return changeByChar("" + number) + "তম";
        } else if (number == 1 || number == 5 || number == 7 || number == 8 || number == 9 || number == 10) {
            return changeByChar("" + number) + "ম";
        } else if (number == 2 || number == 3) {
            return changeByChar("" + number) + "য়";
        } else if (number == 4) {
            return changeByChar("" + number) + "র্থ";
        } else if (number == 6) {
            return changeByChar("" + number) + "ষ্ঠ";
        } else {
            return invalidFormat;
        }
    }

    /*
    * @param Targer number in [0-9]+  -st, -nd, rd, -th
    * @return in BN format normal format
    */
    public String getNumericOrderIndicator(String digit) {

        int number = Integer.parseInt(digit);

        if (number == 0 || number > 10) {
            return changeByChar("" + number) + "তম";
        } else if (number == 1 || number == 5 || number == 7 || number == 8 || number == 9 || number == 10) {
            return changeByChar("" + number) + "ম";
        } else if (number == 2 || number == 3) {
            return changeByChar("" + number) + "য়";
        } else if (number == 4) {
            return changeByChar("" + number) + "র্থ";
        } else if (number == 6) {
            return changeByChar("" + number) + "ষ্ঠ";
        } else {
            return invalidFormat;
        }
    }

    /*
    * @param Targer number in [0-9]+  -st, -nd, rd, -th
    * @return in BN format
    * @throws NumberFormatError
    */
    private String processForDateTypeOrdinalIndicator(String text) throws NumberFormatException {

        int number = Integer.parseInt(text.replaceAll("\\D+", ""));

        if (number == 0) {
            return changeByChar("" + number) + "তম";
        } else if (number == 1) {
            return changeByChar("" + number) + "লা";
        } else if (number >= 5 && number <= 18) {
            return changeByChar("" + number) + "ই";
        } else if (number == 2 || number == 3) {
            return changeByChar("" + number) + "রা";
        } else if (number == 4) {
            return changeByChar("" + number) + "ঠা";
        } else if (number >= 19 && number <= 31) {
            return changeByChar("" + number) + "শে";
        } else {
            return invalidFormat;
        }
    }

    /*
        * @param Target number in [0-9]+  -st, -nd, rd, -th
        * @return in BN format
        * @throws NumberFormatError
        */
    public String getNumericCalendarIndicator(String digit) throws NumberFormatException {

        int number = Integer.parseInt(digit);

        if (number == 0) {
            return changeByChar("" + number) + "তম";
        } else if (number == 1) {
            return changeByChar("" + number) + "লা";
        } else if (number >= 5 && number <= 18) {
            return changeByChar("" + number) + "ই";
        } else if (number == 2 || number == 3) {
            return changeByChar("" + number) + "রা";
        } else if (number == 4) {
            return changeByChar("" + number) + "ঠা";
        } else if (number >= 19 && number <= 31) {
            return changeByChar("" + number) + "শে";
        } else {
            return invalidFormat;
        }
    }

    /*
      * @param date in String
      * @return Ordinal bangla String
      * @return Error Message
      */
    public String getBanglaOrdinalDate(String date) {

        try {
            String[] dates = date.split("-");

            return getNumericCalendarIndicator(dates[2]) + " " + getMonthByNumber(dates[1]) + ", " + getNumber(dates[0]);
        } catch (IndexOutOfBoundsException iobe) {
            throw new IndexOutOfBoundsException(invalidFormat);
        }
    }

    /*
    * @param number as string EN-US
    * @return number as BN
    */
    public String getNumber(final String number) {
        return changeByChar(number);
    }

    /*
    * @param EN format of weight as string EN-US
    * @return in BN format
    */
    public String getWeight(String text) {
        try {
            text = text.replace(" ", "");
            String[] part = text.split("(?<=[0-9])(?=[a-zA-Z])");
            StringBuilder converted = new StringBuilder("");

            if (part[0].trim().matches("[0-9.]*")) {
                converted.append(getNumber(part[0])).append(" ");
            } else {
                return text;
            }

            if (!part[1].trim().matches("[0-9.]*")) {
                converted.append(convertWeightUnit(part[1]));
            } else {
                return text;
            }

            return converted.toString();

        } catch (Exception error) {
           return text;
        }
    }

    /*
    * @param EN format of weight unit as string EN-US
    * @return in BN format's unit
    */
    public String convertWeightUnit(String weight) {

        switch (weight.toLowerCase()) {

            case "g":
            case "gram":
            case "gm":
            case "g.m.":
                return "গ্রাম";

            case "mg":
            case "milligram":
            case "m.g.":
                return "মি:গ্রা:";


            case "kg":
            case "k.g.":
                return "কেজি";

            case "kilogram":
                return "কিলোগ্রাম";

            case "l":
            case "litre":
                return "লিটার";

            default:
                return weight;

        }
    }

    /*
    * @param EN format of distance as string EN-US
    * @return in BN format
    */
    public String getDistance(String text) {
        try {
            text = text.replace(" ", "");
            String[] part = text.split("(?<=[0-9])(?=[a-zA-Z])");
            StringBuilder converted = new StringBuilder("");

            if (part[0].matches("[0-9.]*")) {
                converted.append(getNumber(part[0])).append(" ");
            } else {
                return text;
            }

            if (!part[1].matches("[0-9.]*")) {
                converted.append(convertDistanceUnit(part[1]));
            } else {
                return text;
            }

            return converted.toString();

        } catch (Exception error) {
            return text;
        }
    }

    /*
   * @param EN format of distance unit as string EN-US
   * @return in BN format's unit
   */
    public String convertDistanceUnit(String weight) {

        switch (weight.toLowerCase()) {

            case "metre":
            case "m":
                return "মিটার";

            case "km":
            case "k.m.":
                return "কি:মি:";

            case "Kilometer":
                return "কিলোমিটার";

            case "cm":
            case "c.m.":
                return "সে:মি:";

            case "centimeter":
                return "সেন্টিমিটার";

            default:
                return weight;

        }
    }

}
