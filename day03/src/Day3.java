public class Day3 {


    public static void main(String[] args) {
        String inputFile = "src/input";
        FileProcessor input = new FileProcessor(inputFile);
        int result = input.getSumOfMultiplicationPredicate();
        System.out.printf("The total sum of all the multiplication is: %d", result);

    }
}