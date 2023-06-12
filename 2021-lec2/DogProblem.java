public class DogProblem {

    public static Dog[] largerThanFourNeighbours(Dog[] dogs) {
        /** we don't know how many dogs will be, so we have to initialized with max capacity with array
         * The problem is when the array is not filled with every entry, there will be null
         * The fix would be keeping a count of largerDog we found during the process
         * */

        Dog[] resultDogs = new Dog[dogs.length];
        int count = 0;

        for(int i = 0; i < dogs.length; i++) {
            if (isLargerDog(dogs, i)) {
                resultDogs[count] = dogs[i];
                count++;
            }
        }

        Dog[] noNullDogs = removeNullFromArrayDogs(resultDogs, count);

        return noNullDogs;
    }

    private static boolean isLargerDog(Dog[] dogs, int i) {
        boolean result = true;
        for(int j = -2; j <= 2; j++) {

            int compareIdx = i + j;

            if (isValidIdx(dogs, compareIdx)
                    && dogs[compareIdx].weightInPounds > dogs[i].weightInPounds) {
                return false;
            }
        }
        return result;
    }

    private static boolean isValidIdx(Dog[] dogs, int compareIdx) {
        boolean result = false;

        if (compareIdx >= 0 && compareIdx < dogs.length) {
            result = true;
        }

        return result;
    }

    private static Dog[] removeNullFromArrayDogs(Dog[] dogs, int count) {
        Dog[] result = new Dog[count];
        for(int i = 0; i < count; i++) {
                result[i] = dogs[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Dog[] dogs1 = new Dog[] {
                new Dog(10),
                new Dog(20),
                new Dog(30),
                new Dog(25),
                new Dog(20),
                new Dog(40),
                new Dog(10)
        };

        Dog[] largerDogs1 = largerThanFourNeighbours(dogs1);
        for(int i = 0; i < largerDogs1.length; i++) {
            System.out.print(largerDogs1[i].weightInPounds + " ");
        }
        System.out.println("expect: [30, 40]");

        Dog[] dogs2 = new Dog[] {
                new Dog(10),
                new Dog(15),
                new Dog(20),
                new Dog(10),
                new Dog(5),
                new Dog(10),
                new Dog(15),
                new Dog(22),
                new Dog(20)
        };
        Dog[] largerDogs2 = largerThanFourNeighbours(dogs2);
        for(int i=0; i< largerDogs2.length; i++) {
            System.out.print(largerDogs2[i].weightInPounds + " ");
        }
        System.out.println(" expect: [20, 22]");
    }
}
