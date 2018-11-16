import java.util.ArrayList;
import java.util.List;

public class MaximumPathSumI {
    private static String[] data() {
        var str = "75\n" + "95 64\n" + "17 47 82\n" + "18 35 87 10\n" + "20 04 82 47 65\n" + "19 01 23 75 03 34\n"
                + "88 02 77 73 07 63 67\n" + "99 65 04 28 06 16 70 92\n" + "41 41 26 56 83 40 80 70 33\n"
                + "41 48 72 33 47 32 37 16 94 29\n" + "53 71 44 65 25 43 91 52 97 51 14\n"
                + "70 11 33 28 77 73 17 78 39 68 17 57\n" + "91 71 52 38 17 14 91 43 58 50 27 29 48\n"
                + "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" + "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
        return str.split("\n");
    }

    private static List<List<Integer>> listList(String[] array) {
        var list = new ArrayList<List<Integer>>();
        var temp = new ArrayList<Integer>();

        temp.add(Integer.parseInt(array[0]));
        list.add(temp);

        for (var index = 1; index < array.length; index++) {
            var splitArray = array[index].split(" ");
            temp = new ArrayList<>();
            for (var len = 0; len < splitArray.length; len++) {
                temp.add(Integer.parseInt(splitArray[len]));
            }
            list.add(temp);
        }
        return list;
    }

    private static int maximumPathSolution(List<List<Integer>> list) {
        for (var index = list.size() - 2; index >= 0; index--) {
            for (var len = 0; len < list.get(index).size(); len++) {
                list.get(index).set(len, list.get(index).get(len) + Math.max(list.get(index + 1).get(len), list.get(index + 1).get(len + 1)));
            }
        }
        return list.get(0).get(0);
    }

    public static void main(String... args) {
        var array = data();
        var list = listList(array);
        System.out.println(maximumPathSolution(list));
    }
}
