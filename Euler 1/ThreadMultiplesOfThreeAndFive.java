import java.util.ArrayList;
import java.util.List;

public class ThreadMultiplesOfThreeAndFive implements Runnable{
    private int value;  // < value to generate multiples of > 
    private int limit; //  < limit to stop generating multiples >
    private List<Integer> multiples; // < list of hold all multiples of value less than limit >

   //< Constructor(value, limit) >
    public ThreadMultiplesOfThreeAndFive(int value, int limit){
        this.value = value;
        this.limit = limit;
        multiples  = new ArrayList<>();
    }
    @Override
    public void run() {
        // < generate multiples and store in list >
        multiples = MultiplesOfThreeAndFive.singly(value, limit);
    }
    // < return list of multiples > 
    public List<Integer> getMultiples() {
        return multiples;
    }
}
