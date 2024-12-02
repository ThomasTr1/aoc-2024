import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    private final List<Report> listOfReports = new ArrayList<>();

    public Day2(String inputFile) {

        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = inputReader.readLine()) != null) {
                Report report = getReportFromLine(line);
                this.listOfReports.add(report);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR: went wrong while reading the input file");
        }
    }

    private Report getReportFromLine(String line) {
        String[] intsAsString = line.split(" ");
        List<Integer> currentReport = new ArrayList<>();

        for (String token : intsAsString) {
            currentReport.add(Integer.parseInt(token));
        }
        return new Report( currentReport);
    }


    public static void main(String[] args) {
        Day2 inputData = new Day2("src/main/resources/input");

        int solution1 = inputData.part_one();
        System.out.printf("Solution for Part 1: %d", solution1);
    }

    public int part_one() {
        int nbValidReports = 0;
        for(Report report : this.listOfReports){
            if(report.isValid()){
                nbValidReports++;
            }
        }
        return nbValidReports;
    }
}