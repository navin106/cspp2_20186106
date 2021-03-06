import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted SortedSet.
 */
class SortedSet extends Set {
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == adtlist[i]) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception    { exception_description }
     */
    public int[] subSet(final int fromElement,
                        final int toElement) throws Exception {
        int index = 0;
        if (fromElement > toElement) {
            throw new Exception("Invalid Arguments to Subset Exception");
        }
        if (toElement < 0) {
            int[] a = new int[0];
            return a;
        }
        int[] empt = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (adtlist[i] >= fromElement && adtlist[i] < toElement) {
                empt[count++] = adtlist[i];
            }
        }
        int[] subSet = new int[count];
        for (int i = 0; i < count; i++) {
            subSet[i] = empt[i];
        }
        return subSet;
    }
    /**
     * { function_description }.
     *
     * @param      toElement  To element
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public int[] headSet(final int toElement) throws Exception {
        if (toElement == adtlist[0] || toElement < 0) {
            throw new Exception("Set Empty Exception");
        } else {

            int[] empt = new int[size];
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (adtlist[i] < toElement) {
                    empt[count++] = adtlist[i];
                }
            }
            int[] headSet =  new int[count];
            for (int i = 0; i < count; i++) {
                headSet[i] = empt[i];
            }
            /*int index = Arrays.asList(adtlist).indexOf(toElement);
            int k = 0;
            for (int i = 0; i < index; i++) {
                headSet[k++] = adtlist[i];
            }*/
            return headSet;
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public int last() throws Exception {
        if (size == 0) {
            throw new Exception("Set Empty Exception");
        }
        return adtlist[size - 1];
    }
    /**
     * Adds all.
     *
     * @param      d     { parameter_description }
     */
    public void addAll(final int[] d) {

        // Set k = new Set();
        if (d.length > 0) {
            for (int a : d) {
                add(a);
            }
        }
        adtlist = Arrays.copyOf(adtlist, size);
        Arrays.sort(adtlist);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    private static final int NUM = 3;
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int[] intArray(final String[] a) {
        int[] c = new int[a.length];
        int i = 0;
        if (a[1].length() >= 1) {
            for (String e : a) {
                c[i++] = Integer.parseInt(e.trim());
            }
        }
        return c;
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static String str(final int[] a) {
        String str = "{";
        for (int i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[a.length - 1] + "}";
        return str;
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedSet b = new SortedSet();
        Solution k = new Solution();
        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
            case "subSet":
                try {
                    String[] a = token[1].split(",");
                    if (b.subSet(Integer.parseInt(a[0]),
                                 Integer.parseInt(a[1])) != null) {
                        if (b.subSet(Integer.parseInt(a[0]),
                                     Integer.parseInt(a[1])).length == 0) {
                            System.out.println("{}");
                            break;
                        }
                        if (a.length == 2) {
                            int[] k1 = b.subSet(Integer.parseInt(a[0]),
                                                Integer.parseInt(a[1]));

                            System.out.println(str(k1));
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "headSet":
                int m = Integer.parseInt(token[1]);
                try {
                    if (b.headSet(m) != null) {
                        if (b.headSet(m).length == 0) {
                            System.out.println("{}");
                            break;
                        }
                        int[] k2 = b.headSet(m);
                        if (token[1].length() > 0) {
                            System.out.println(str(k2));
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {

                    System.out.println(b.last());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "addAll":

                int[] c = k.intArray(token[1].split(","));
                b.addAll(c);
                break;
            case "print":
                System.out.println(b);
                break;
            case "intersection":
                SortedSet s = new SortedSet();
                SortedSet t = new SortedSet();
                try {
                    int[] intArray = new int[token[1].length() / NUM];
                    if (token[1].length() > NUM) {
                        intArray = intArray((((
                                    token[1].replace("[", "")).replace(
                                    "]", "")).split(",")));
                    } else if (token[1].length() == NUM) {
                        intArray[0] = Integer.parseInt((
                        token[1].replace("[", "")).replace("]", ""));
                    }
                    s.addAll(intArray);
                    intArray = new int[token[2].length() / NUM];
                    if (token[2].length() > NUM) {
                        intArray = intArray((((
                                    token[2].replace("[", "")).replace(
                                    "]", "")).split(",")));

                    } else if (token[2].length() == NUM) {
                        intArray[0] = Integer.parseInt((
                            token[2].replace("[", "")).replace("]", ""));
                    }
                    t.addAll(intArray);
                    int[] z = (s.intersection(t)).adtlist;
                    int ksize = (s.intersection(t)).size;
                    String str = "{";
                    if (ksize == 1) {
                        System.out.println("{" + z[0] + "}");
                    } else {
                        for (int i = 0; i < ksize - 1; i++) {
                            str += z[i] + ", ";
                        }
                        str += z[ksize - 1] + "}";
                        System.out.println(str);
                    }
                } catch (Exception e) {
                    System.out.println("{}");
                }
                break;
            case "retainAll":
                s = new SortedSet();
                t = new SortedSet();
                try {
                    int[] intArray = new int[token[1].length() / NUM];
                    if (token[1].length() > NUM) {
                        intArray = intArray((((
                                        token[1].replace("[", "")).replace(
                                        "]", "")).split(",")));
                    } else if (token[1].length() == NUM) {
                        intArray[0] = Integer.parseInt((
                        token[1].replace("[", "")).replace("]", ""));
                    }
                    s.addAll(intArray);
                    intArray = new int[token[2].length() / NUM];
                    if (token[2].length() > NUM) {
                        intArray = intArray((((
                                        token[2].replace("[", "")).replace(
                                        "]", "")).split(",")));

                    } else if (token[2].length() == NUM) {
                        intArray[0] = Integer.parseInt((
                        token[2].replace("[", "")).replace("]", ""));
                    }
                    int[] z = (s.retainAll(intArray)).adtlist;
                    int ksize = (s.retainAll(intArray)).size;
                    String str = "{";
                    if (ksize == 1) {
                        System.out.println("{" + z[0] + "}");
                    } else {
                        for (int i = 0; i < ksize - 1; i++) {
                            str += z[i] + ", ";
                        }
                        str += z[ksize - 1] + "}";
                        System.out.println(str);
                    }
                } catch (Exception e) {
                    System.out.println("{}");
                }
                break;
            default:
                break;
            }
        }
    }
}
