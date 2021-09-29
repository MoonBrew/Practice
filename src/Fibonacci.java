
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Function to return list containing first n fibonacci numbers.
    public static long[] print(int n)
    {
        long prev1 = 1; //immediate previous
        long prev2 = 1; //second previous
        long [] output = new long[n];
        output [0] = 1;
        if(n == 1)
            return output;
        else if (n == 2){
            output [1] = 1;
            return output;
        }
        else{
            output [1] = 1;
            for(int i = 2; i < n; i++){
                output[i] = prev1 + prev2;
                prev2 = prev1;
                prev1 = output[i];
            }
        }
        return output;
    }
}
