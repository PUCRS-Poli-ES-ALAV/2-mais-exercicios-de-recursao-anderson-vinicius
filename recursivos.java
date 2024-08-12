public static void main(String [] args){
    System.out.println("Fatorial de 10: " + fatorial(10));
}


/*
FATORIAL
Caso base |  N=1 -> 1
Caso de erro | N <= 0 
Caso recursivo | N > 1 -> N * fatorial(n-1)
*/
static public int fatorial(int n){
    if (n == 1){
        return 1;
    }
    else if (n <= 0){
        return -1;
    }

    return n * fatorial(n-1);
}

/*
 SOMATÓRIO
 Caso base | N = 
 */