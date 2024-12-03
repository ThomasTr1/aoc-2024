public class Day3 {


    public static void main(String[] args) {
        String inputFile = "src/input";
        FileProcessor input = new FileProcessor(inputFile);
        int result = input.getSumOfMultiplicationPredicate_Part1();
        System.out.printf("Solution part 1: %d\n", result);
        result = input.getSumOfMultiplicationPredicate_Part2();
        System.out.printf("Solution part 2: %d\n", result);
    }
}