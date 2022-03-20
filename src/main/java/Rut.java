import java.util.ArrayList;

public class Rut {
    public static void main(String[] args) {
        rut();
    }
    public static void rut(){
        int rut = 11111111;
        String rutInvertido = invertir(Integer.toString(rut));
        ArrayList<Integer> multiplicaciones = multiplicar(rutInvertido);
        int suma = sumar(multiplicaciones);
        int division = dividir(suma);
        int num = division*11;
        num = Math.abs(num - suma);
        String digitoVerificador = digitoVerificador(num);
        System.out.println("Rut: " + rut);
        System.out.println("Codigo Verificador: " + digitoVerificador);
    }
    public static String invertir(String a){
        StringBuilder invertir = new StringBuilder(a);
        a = invertir.reverse().toString();
        return a;
    }
    public static ArrayList<Integer> multiplicar(String a){
        ArrayList<Integer> resultados = new ArrayList<Integer>();
        int multiplo = 1;
        int resultado;
        for(int i=0;i<a.length();i++){
            multiplo++;
            resultado = Integer.parseInt(String.valueOf(a.charAt(i))) * multiplo;
            resultados.add(resultado);
            if(multiplo==7){
                multiplo = 1;
            }
        }
        return resultados;
    }
    private static int sumar(ArrayList<Integer> a) {
        int sum = 0;
        for(int i=0;i<a.size();i++){
            sum = sum + a.get(i);
        }
        return sum;
    }
    private static int dividir(double a){
        double num = a/11;
        int parteEntera = (int)num;
        return parteEntera;
    }
    private static String digitoVerificador(int a){
        String digitoVerificador = String.valueOf(11 - a);
        switch(digitoVerificador){
            case "10":
                digitoVerificador = "k";
                break;
            case "11":
                digitoVerificador = "0";
                break;
            default:
                break;
        }
        return digitoVerificador;
    }
}
