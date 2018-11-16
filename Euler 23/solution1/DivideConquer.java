
public class DivideConquer implements Runnable {
    private int start;
    private int end;
    private int[] list;
    private int sum;

    public DivideConquer(int[] list, int start, int end){
        this.list = list;
        this.start = start;
        this.end = end;
        sum = 0;
    }

    @Override
    public void run() {
        try {
            sum = AbundantNumbers.sum(list, start, end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getSum() {
        return sum;
    }
}
