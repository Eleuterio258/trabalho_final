package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utel {

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static Date stringToDate(String date) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return fecha;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static String formatDate(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fecha);
    }

    public static int objectToInt(Object obj) {
        int numInt = Integer.parseInt(objectToString(obj));
        return numInt;
    }

    public static double objectTodouble(Object obj) {
        String str = obj.toString();
        double numDouble = Double.valueOf(str).doubleValue();
        return numDouble;
    }

    public static boolean objectToBoolean(Object obj) {
        String str = objectToString(obj);
        Boolean booleano = new Boolean(str);
        return booleano;
    }

    public static String objectToString(Object obj) {
        String str = "";
        if (obj != null) {
            str = obj.toString();
        }
        return str;
    }

    //le pasas el string y luego indicas y la cantidad de ceros 
    //que quieres que te complete
    public static String agregarCeros(String string, int largo) {

        String ceros = "";
        int cantidad = largo - string.length();
        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += "0";
            }
            return (ceros + string);
        } else {
            return string;
        }
    }
}
