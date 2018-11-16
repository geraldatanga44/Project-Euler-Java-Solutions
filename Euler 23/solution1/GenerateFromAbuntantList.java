
import java.util.List;

public class GenerateFromAbuntantList  implements Runnable{
    private List<Integer> list;
    private List<List<Integer>> abuntantList;
    private static final int LIMIT = 28123;
    private static final int[] combo = new int[LIMIT + 1];
    public GenerateFromAbuntantList(List<Integer> list, List<List<Integer>> abuntantList){
        this.list = list;
        this.abuntantList = abuntantList;
    }

    @Override
    public void run() {
        for(var value : list){
            for(var collection : abuntantList){
                for(var num : collection){
                   var sum = value + num;
                   if(sum <= LIMIT){
                       combo[sum] = sum;
                   }
                }
            }
        }
    }

    public static int[] getCombo() {
        return combo;
    }
}
