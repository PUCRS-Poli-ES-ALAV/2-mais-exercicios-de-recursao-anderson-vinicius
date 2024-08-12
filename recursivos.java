public static void main(String [] args){
    System.out.println("Fatorial de 10: " + fatorial(10));
    System.out.println("Somatorio de 10: " + somatorio(-10));
    System.out.println("Sétimo elemento da sequencia de fibonacci: " + fibonacci(7));
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
 Caso base | N == 0 -> 0
 Caso recursivo | N > 0 -> N + somatorio (n-1)
 */

 static public int somatorio (int n){
    if (n == 0){
        return 0;
    }else if (n<0) return n + somatorio (n+1);
    return n + somatorio (n-1);
 }

/*
 FIBONACCI
Este método é válido para o seguinte formato da lista: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987...
Caso base | N < 2 -> N
Caso de erro | N < 0
Caso recursivo 

 */

 static public int fibonacci(int n){
    if (n < 2){
        return n;
    }else if (n < 0){
        return -1;
    }
    return fibonacci(n-1) + fibonacci (n-2);
    
 }
/*
 SOMATORIO INTERVALO
 Caso base | Se um número maior que outro apenas uma unidade, retorna 0, o mesmo se forem iguais.
 Cas
 */
 static public int intervalo(int x, int y){

 }
 