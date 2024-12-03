public class Day3 {


    public static void main(String[] args) {
        String inputFile = "/home/thomas/Documents/aoc-2024/day03/src/input";
        FileProcessor input = new FileProcessor(inputFile);
        int result = input.getSumOfMultiplicationPredicate();
        System.out.println(result);

    }
}