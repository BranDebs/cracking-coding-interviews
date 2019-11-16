package codility;

public class LuckyDay {
  public int solutionNaive(int N, int K) {
    int minRnds = 0;
    while (N > 1) {
      if (K > 0) {
        if (N % 2 == 0) {
          N /= 2;
          K--;
          minRnds++;
          continue;
        }
      }
      N--;
      minRnds++;
    }
    return minRnds;
  }

  public int solution(int N, int K) {
    if (K == 0) {
      return  N-1;
    }
    double sqrtN = Math.sqrt(N);
    if (sqrtN >= K){
      return K + (int)Math.pow(N,1.0/(K));
    }
    return (int)Math.floor(sqrtN) - 1;
  }

  public static void main(String[] args) {
    LuckyDay ld = new LuckyDay();
    System.out.println("Print naive soln\n");
    System.out.println(ld.solutionNaive(8,0));
    System.out.println(ld.solutionNaive(18,2));
    System.out.println(ld.solutionNaive(10,10));
    System.out.println(ld.solutionNaive(1,10));
    System.out.println(ld.solutionNaive(1,0));
    System.out.println(ld.solutionNaive(4,20));
    System.out.println(ld.solutionNaive(1000000,100));
    System.out.println("\nPrint soln\n");
    System.out.println(ld.solution(8,0));
    System.out.println(ld.solution(18,2));
    System.out.println(ld.solution(10,10));
    System.out.println(ld.solution(1,10));
    System.out.println(ld.solution(1,0));
    System.out.println(ld.solution(4,20));
    System.out.println(ld.solution(1000000,100));
  }
}
