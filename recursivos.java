/**
 * @author Anderson Sprenger, Vinicius Dias
 * @since JDK 22 (Este codigo usa a feature de Unnamed classes)
 */

 import java.util.ArrayList;

 void main(){
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
 
     ArrayList<Integer> lista2 = new ArrayList<>();
     lista2.add(50);
     lista2.add(5);
     lista2.add(94);
     lista2.add(500);
     lista2.add(945938);

     System.out.println("abracadabra contem dab? " + (findSubStr("abracadabra", "dab")));
     System.out.println("abracadabra contem z? " + (findSubStr("abracadabra", "z")));
 }
 
 /**
  * 1. FATORIAL
  * 
  * Caso base |  N=1 -> 1
  * Caso de erro | N <= 0 
  * Caso recursivo | N > 1 -> N * fatorial(n-1)
  */
 int fatorial(int n){
     if (n == 1){
         return 1;
     }
     else if (n <= 0){
         throw new IllegalArgumentException("O número não pode ser negativo nem zero.");
     }
 
     return n * fatorial(n-1);
 }
 
 /**
  * 2. SOMATÓRIO
  * 
  * Caso base | N == 0 -> 0
  * Caso recursivo | N > 0 -> N + somatorio (n-1)
  */

  int somatorio (int n){
     if (n == 0){
         return 0;
     }else if (n<0) return n + somatorio (n+1);
     return n + somatorio (n-1);
  }
 
 /*
  * 3. FIBONACCI
  * 
  * Este método é válido para o seguinte formato da lista: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987...
  * 
  * > Caso base | N < 2 -> N
  * > Caso de erro | N < 0
  * > Caso recursivo 
  */
 
  int fibonacci(int n){
     if (n < 2){
         return n;
     }else if (n < 0){
         throw new IllegalArgumentException("O número não pode ser negativo.");
     }
     return fibonacci(n-1) + fibonacci (n-2);
     
  }

 /*
  * 4. SOMATORIO INTERVALO
  * Caso base | X == Y -> X
  */

  int intervalo(int x, int y){
     if (x == y) return x;
     if (x < y) return y + intervalo(x-1, y);
     return x + intervalo(x-1, y);
  }
 
 
 /*
  * 5. PALINDROMO
  * 
  * > Caso base | Apenas um caractere ou nenhum caractere
  */
 
  boolean palindromo (String palavra){
     palavra = palavra.toLowerCase();
     int nCaracteres = palavra.length();
     if (nCaracteres == 1 || nCaracteres == 0) return true;
     else if (palavra.charAt(0) == palavra.charAt(nCaracteres-1)){
             return palindromo (palavra.substring(1, nCaracteres-1));
         }
     return false;
  }
 
 /*
  * 6. BINARIO
  * 
  * > Caso base | N == 0 -> 0 ou N == 1 -> 1
  * > Caso de erro | N < 0
 */
 
 String binario (int n){
     if (n < 0) throw new IllegalArgumentException("O número não pode ser negativo.");
     if (n==0) return "0";
     if (n==1) return "1";
     return binario (n / 2) + (n % 2);
 
 }
 
 /*
  * 7. SOMATORIO LISTA
  * 
  * > Caso base | tamanho da lista == 1 -> 1 ou tamanho da lista == 0 -> 0
  */

 int somatorioLista(ArrayList<Integer> numeros){
     int tamanho = numeros.size();
     if (tamanho == 1) return numeros.get(0);
     else if (tamanho == 0) return 0;
 
     numeros.add(numeros.get(0) + numeros.get(1));
     numeros.remove(0);
     numeros.remove(0);
     return somatorioLista(numeros);
 }
 
 /*
  * 8. ACHAR MAIOR
  * 
  * > Caso base | tamanho da lista == 1 -> retorna o único número
  */
 
 int acharMaior(ArrayList<Integer> numeros){
     int tamanho = numeros.size();
     if (tamanho == 1) return numeros.get(0);
     else if (numeros.get(0) > numeros.get(1)) numeros.remove(1);
         else numeros.remove(0); 
 
         return acharMaior(numeros);
 }
 
 /**
  * 9. Implemente um método recursivo para determinar se um string ocorre dentro de outro.
  * 
  * @param str - a string em que sera feita a busca
  * @param match - a substring a ser buscada
  * 
  * @return true se encontrar match dentro de string, false caso contrario.
  * 
  */
 boolean findSubStr(String str, String match) {
     // caso erro
     if (str == null || match == null) {
         return false;
     }
 
     // caso base
     if (match.length() == 0) { // se match for vazio entao
         return true; // str contem vazio
     }
 
     if (str.length() == 0) { // se match não for vazia, e str for vazia
         return false; // então str não contem o match
     }
 
     if (str.length() < match.length()) { // se o tamanho de str for menor que de match
         return false; // então não tem como str conter match
     }
     
     //casos recursivos
     for (int i = 0; i < match.length(); i++) {
         if (str.charAt(i) != match.charAt(i)) { // se os caracteres são diferentes, não deu match
             return findSubStr(str.substring(1), match); // então é chamada a função recursivamente removendo o primeiro caractere de str
         }
     }
 
     return true;
 
 }
 
 /*
  * 10. NUMERO DIGITOS
  * 
  * > Caso base | N / 10 < 1 -> 1 (NDigitos)
  */
 int numeroDigitos(int n){
     int nDigitos = 1;
     if ((n / 10) < 1) return nDigitos;
     else{
         n = n / 10;
         return nDigitos = nDigitos + numeroDigitos (n);
     }
 }
 