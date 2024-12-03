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
    public int getSumOfMultiplicationPredicate() {
        int sum = 0;
        for(String line: this.lines){
            sum += sumOfMultiplicationFromLine(line);
        }

        return sum;
    }

    private int sumOfMultiplicationFromLine(String line){
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern multiplyPredicate = Pattern.compile(regex);
        Matcher m = multiplyPredicate.matcher(line);
        int sumOfLine = 0;
        while(m.find()){
            MultiplicationNumbers ints = getIntegerFromRegexMatch(m);
            sumOfLine += ints.a * ints.b;
        }
        return sumOfLine;
    }

    private record MultiplicationNumbers(int a, int b){}

    private MultiplicationNumbers getIntegerFromRegexMatch(Matcher m) {
        int a = Integer.parseInt(m.group(1));
        int b = Integer.parseInt(m.group(2));
        return new MultiplicationNumbers(a,b);

    }

}
