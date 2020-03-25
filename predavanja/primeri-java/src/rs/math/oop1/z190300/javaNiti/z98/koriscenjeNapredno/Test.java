package rs.math.oop1.z190300.javaNiti.z98.koriscenjeNapredno;

import java.util.concurrent.ForkJoinPool;

public class Test {

	public static void main(String[] args) {
		Problem test = new Problem();
		// Check the number of available processors
		int nThreads = Runtime.getRuntime().availableProcessors();
		System.out.println(nThreads);
		Solver mfj = new Solver(test.getList());
		ForkJoinPool pool = new ForkJoinPool(nThreads);
		pool.invoke(mfj);
		long result = mfj.getResult();
		System.out.println("Done. Result: " + result);
		long sum = 0;
		// Check if the result was ok
		for (int i = 0; i < test.getList().length; i++) {
			sum += test.getList()[i];
		}
		System.out.println("Done. Result: " + sum);
	}
} 
