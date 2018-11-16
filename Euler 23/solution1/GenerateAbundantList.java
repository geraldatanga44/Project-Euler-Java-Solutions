import java.util.ArrayList;
import java.util.List;

public class GenerateAbundantList implements Runnable {
    private int start;
    private int end;
    private List<Integer> list;

    public GenerateAbundantList(int start, int end){
        this.start = start;
        this.end   = end;
        list = new ArrayList<>();
    }

    @Override
    public void run() {
        for(var s = start; s <= end; s++){
            if(AbundantNumbers.isAbuntant(s))
                list.add(s);
        }
    }

    public List<Integer> getList() {
        return list;
    }
}
