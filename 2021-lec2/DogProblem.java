public class DogProblem {

    public static Dog[] largerThanFourNeighbours(Dog[] dogs) {
        return dogs;
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[] {
                new Dog(10),
                new Dog(20),
                new Dog(30),
                new Dog(25),
                new Dog(20),
                new Dog(40),
                new Dog(10)
        };

        Dog[] largerDogs = largerThanFourNeighbours(dogs);
        for(int i = 0; i < largerDogs.length; i++) {
            System.out.print(largerDogs[i].weightInPounds + " ");
        }
    }
}
