import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor {
    private final List<String> lines;

    FileProcessor(String inputFile)  {
        try {
            this.lines = Files.readAllLines(Paths.get(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("ERROR when reading file\n", e);
        }
    }


    /**
     * Computes the total sum of all multiplication predicates found in the input file.
     * The multiplication predicate is defined as an expression in the form `mul(a,b)`,
     * where a and b are integers.
     *
     * @return the sum of all identified multiplication predicates.
     */
    public int getSumOfMultiplicationPredicate_Part1() {
        String input = String.join(":", this.lines);
        int sum = sumOfMultiplicationFromLine(input);
        return sum;
    }

    private int sumOfMultiplicationFromLine(String line){
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern multiplyPredicate = Pattern.compile(regex);
        Matcher m = multiplyPredicate.matcher(line);
        int sumOfLine = 0;
        while(m.find()){
            MultiplicationNumbers ints = getIntegerFromRegexMatch(m);
            sumOfLine += ints.a * ints.b;
        }
        return sumOfLine;
    }

    private MultiplicationNumbers getIntegerFromRegexMatch(Matcher m) {
        int a = Integer.parseInt(m.group(1));
        int b = Integer.parseInt(m.group(2));
        return new MultiplicationNumbers(a,b);
    }

    private record MultiplicationNumbers(int a, int b){}

    private String parseInputPart2(){
        String file = String.join(":", this.lines) + "do()";

        String multRegex = "mul\\((\\d{1,3}),\\d{1,3}\\)";
        String doRegex = "do\\(\\)";
        String dontRegex = "don't\\(\\)";

        String regEx = multRegex + "|" + doRegex + "|" + dontRegex;

        Pattern multiplyPredicate = Pattern.compile(regEx);
        Matcher m = multiplyPredicate.matcher(file);
        StringBuilder filteredFile = new StringBuilder();
        while (m.find()) {
            filteredFile.append(m.group()).append("");
        }

        if (filteredFile.length() > 0) {
            filteredFile.setLength(filteredFile.length() - 1);
        }
        return String.valueOf(filteredFile);
    }


    public int getSumOfMultiplicationPredicate_Part2(){
        String parsedInput = parseInputPart2();
        String result = parsedInput.replaceAll("(?s)don't\\(\\).*?do\\(\\)", "");
        result = result.replaceAll("do\\(\\)", "");
        return sumOfMultiplicationFromLine(result);

    }


}
