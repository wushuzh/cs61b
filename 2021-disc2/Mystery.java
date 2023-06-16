import java.util.Arrays;

public class Mystery {

    public static int mystery(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while (index < inputArray.length) {
            if (inputArray[index] < x) {
                x = inputArray[index];
                answer = index;
            }
            index = index + 1;
        }
        return answer;
    }

    public static void mystery2(int[] inputArray) {
        int index = 0;
        while (index < inputArray.length) {
            int targetIndex = mystery(inputArray, index);
            int temp = inputArray[targetIndex];
            inputArray[targetIndex] = inputArray[index];
            inputArray[index] = temp;
            index = index + 1;
        }
    }


    /* It's selection sort:
       from the beginning of the array,
       find the min element after this index to the end of the array,
       then swap this min to current index until the end
     */
    public static void main(String[] args) {
        int[] inputs = {3, 0, 4, 6, 3};
        int k = 2;

        int ans = mystery(inputs, k);
        System.out.println("The answer should be 4, running it gets: " + ans);

        mystery2(inputs);
        System.out.println("The array is changed to [0, 3, 3, 4, 6], running it gets: " + Arrays.toString(inputs));
    }
}
