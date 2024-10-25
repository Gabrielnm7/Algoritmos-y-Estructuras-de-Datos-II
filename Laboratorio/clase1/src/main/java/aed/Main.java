package aed;

class Main {
    int fibonacci(int n) {
        int res;

        if (n == 0) {
            res = 0;
        } else if (n == 1) {
            res = 1;
        // Se podria hacer if ( (n==0) || (n==1) ){
        // res = n; }
        } else {
            res = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return res;
    }

    int fibonacciReturn(int n) {
        // Se pueden unificar estos if?
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciReturn(n - 1) + fibonacciReturn(n - 2);
        // Unificado seria asi, y luego la recursividad
        // if ((n == 0) || (n == 1)) {
        //    return n;
    }

    // Revisar, no pasa los tests: es por que res estaba como res=0, si tengo numeros negativos no va a funcionar
    double maximo(double[] xs) {
        // double res = 0;
        double res = xs[0]; // tomando el primer elemento como el "mayor" arreglamos el problema de los negativos

        for (double x : xs) {
            // Si encuentro un elemento mayor al que tenía guardado, me lo guardo
            if (x > res) {
                res = x;
            }
        }

        return res;
    }

    int[] sumarArreglos(int[] seq1, int[] seq2) {
        int[] res = new int[seq1.length];

        for (int i = 0; i < seq1.length; i++) {
            res[i] = seq1[i] + seq2[i];
        }

        return res;
    }

    String iniciales(String texto) {
        String res = "";
        for (int i = 0; i < texto.length(); i++) {
            if (i == 0 || (texto.charAt(i-1) == ' ' && texto.charAt(i) != ' ')) {
                res += texto.charAt(i);
            }
        }
        return res;
    }
}