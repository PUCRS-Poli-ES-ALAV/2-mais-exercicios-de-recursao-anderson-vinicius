import java.util.ArrayList;
public static void main(String [] args){
    System.out.println("Fatorial de 10: " + fatorial(10));
    System.out.println("Somatorio de 10: " + somatorio(10));
    System.out.println("Sétimo elemento da sequencia de fibonacci: " + fibonacci(7));
    System.out.println("Soma intervalo entre 15 e 10: "+ intervalo(15, 10));
    System.out.println("A palavra Renner é palíndromo?: "+ palindromo("Renner"));
    System.out.println("A conversão do número 8 para binário: " + binario(8));

    ArrayList<Integer> lista = new ArrayList<>();
    lista.add(10);
    lista.add(93);
    lista.add(4);
    lista.add(78);
    lista.add(1400);
    lista.add(643);

    System.out.println("Somatorio da lista: " + somatorioLista(lista));
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
        throw new IllegalArgumentException("O número não pode ser negativo nem zero.");
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
        throw new IllegalArgumentException("O número não pode ser negativo.");
    }
    return fibonacci(n-1) + fibonacci (n-2);
    
 }
/*
 SOMATORIO INTERVALO
 Caso base | X == Y -> X
 */
 static public int intervalo(int x, int y){
    if (x == y) return x;
    if (x < y) return y + intervalo(x-1, y);
    return x + intervalo(x-1, y);
 }


/*
 PALINDROMO
 Caso base | Apenas um caractere ou nenhum caractere
 */

 static public boolean palindromo (String palavra){
    palavra = palavra.toLowerCase();
    int nCaracteres = palavra.length();
    if (nCaracteres == 1 || nCaracteres == 0) return true;
    else if (palavra.charAt(0) == palavra.charAt(nCaracteres-1)){
            return palindromo (palavra.substring(1, nCaracteres-1));
        }
    return false;
 }

/*
BINARIO
Caso base | N == 0 -> 0 ou N == 1 -> 1
Caso de erro | N < 0
*/

static public String binario (int n){
    if (n < 0) throw new IllegalArgumentException("O número não pode ser negativo.");
    if (n==0) return "0";
    if (n==1) return "1";
    return binario (n / 2) + (n % 2);

}

/*
 Caso base | tamanho da lista == 1 -> 1 ou tamanho da lista == 0 -> 0
 */
static public int somatorioLista(ArrayList<Integer> numeros){
    int tamanho = numeros.size();
    if (tamanho == 1) return numeros.get(0);
    else if (tamanho == 0) return 0;

    numeros.add(numeros.get(0) + numeros.get(1));
    numeros.remove(0);
    numeros.remove(0);
    return somatorioLista(numeros);
}
 