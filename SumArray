//package ForkJoinSum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumArray extends RecursiveTask<Double>  {
	 static int SEQUENTIAL_THRESHOLD = 1000;
	 int lo;
	 int hi;
	 Tree[] arr;
	 
	 SumArray(Tree[] a, int l, int h){lo =l; hi= h ;arr =a;}
	 
	 public Double compute() {
		 if(hi-lo <= SEQUENTIAL_THRESHOLD) {
			 double ans = 0;
			 for(int i=lo; i<hi;i++) {
				 float num = Parallel.canopySum(arr[i]);
				 arr[i].setTotal(num);
				 ans+= num;
			 }
			 return ans;
		 }else {
			 SumArray left = new SumArray(arr,lo,(hi+lo)/2);
			 SumArray right = new SumArray(arr,(hi+lo)/2,hi);
			 left.fork();
			 double rightAns = right.compute();
			 double leftAns = left.join();
			 return (leftAns + rightAns);
		 }//end else
	 }//end compute
}
