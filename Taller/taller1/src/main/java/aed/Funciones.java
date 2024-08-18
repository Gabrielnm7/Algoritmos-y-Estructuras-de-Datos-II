package aed;

class Funciones {
    // Ejercicio 1
    int cuadrado(int x) {
        int res = x * x;
        return res;
    }
    
    // Ejericio 2
    double distancia(double x, double y) {
        double res = Math.sqrt((x*x)+(y*y));
        return res;
    }

    // Ejercicio 3
    boolean divideA(int d, int n){
        boolean res = (n%d == 0);
        return res;
    }

    boolean esPar(int n) {
        return (divideA(2, n));
    }

    // Ejercicio 4
    boolean esBisiesto(int n) {
        // if ((divideA(4, n) && !divideA(100, n) || divideA(400, n))) {
        //     return true;
        // }
        // else{
        //     return false;}
        return ((divideA(4, n) && !divideA(100, n)) || divideA(400, n));
    }

    // Ejercicio 5
    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n==0){
            return 1;
        }
        else{
            return n * factorialIterativo(n-1);
        }
    }

    // Ejercicio 6
    boolean esPrimo(int n) {
        int res = 0;
        for (int i=1; i<=n;i++){
            if (divideA(i, n)){
                res = res + 1;
            }
        }
        return (res == 2);
    }

    // Ejercicio 7
    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i=0; i <= (numeros.length - 1); i++){
            res = res + numeros[i];
        }
        return res;
    }

    // Ejercicio 8
    int busqueda(int[] numeros, int buscado) {
        int res = -1;
        for (int i=0; i<=(numeros.length - 1); i++){
            if (numeros[i] == buscado){
                res = i;
            }
        }
        return res;
    }

    // Ejercicio 9
    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i =0; i <= (numeros.length-1); i++){
            if (esPrimo(numeros[i])){
                return true;
            }
        }
        return res;
    }

    // Ejercicio 10
    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i < (numeros.length); i++){
            if (!esPar(numeros[i])){
                return false;
            }
        }
        return res;
    }

    // Ejercicio 11
    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int res = 0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i) == s2.charAt(i)){
            res = res + 1;    
            } 
        }
        return (res == s1.length());
    }

    // Ejercicio 12
    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        if (esPrefijo(s1,s2)){
            return true;
        }
        else{
            return esSufijo(s1, s2.substring(1));
        }
    }
}
