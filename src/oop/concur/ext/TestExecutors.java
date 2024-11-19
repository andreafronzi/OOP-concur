package oop.concur.ext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutors {

	public static void main(String[] args) throws Exception {

		int size = 1000;
		int n = size; 
		int k = size; 
		int m = size; 
		
		System.out.println("Testing A[" + n + "," + k + "]*B[" + k + "," + m + "]");

		System.out.println("Initialising...");

		Mat matA = new Mat(n,m);
		Mat matB = new Mat(m,k);

		matA.initRandom(10);
		matB.initRandom(10);
		
		System.out.println("Initialising done.");
		System.out.println("Computing matmul...");

		long t0 = System.currentTimeMillis();
		
		Mat matC = new Mat(matA.getNRows(), matB.getNColumns());
	
		int threadPoolSize = Runtime.getRuntime().availableProcessors() + 1;
		ExecutorService exec = Executors.newFixedThreadPool(threadPoolSize);		
			for (int i = 0; i < matA.getNRows(); i++){
				for (int j = 0; j < matB.getNColumns(); j++){
					
					Runnable task = new ComputeElemTask(i,j,matA,matB,matC);

					/* execute task, asynchronously */
					exec.execute(task);
					
					// Alternative: using a lambda expression to specify the task
					/* 					
					exec.execute(() -> {
						double sum = 0;
						for (int k = 0; k < matA.getNColumns(); k++){
							sum += matA.get(i, k)*matB.get(k, j);
						}
						matC.set(i,j,sum);
					});
					*/
				}
			}
		exec.shutdown();
		exec.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS);
		
		long t1 = System.currentTimeMillis();
		
		System.out.println("Computing matmul done.");
		System.out.println("Time elapsed: " + (t1 - t0) + "ms.");
		
	}

}
