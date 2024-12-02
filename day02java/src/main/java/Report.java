import java.util.List;

public class Report {
    private final List<Integer> report;

    public Report(List<Integer> report){
        this.report = report;
    }



    boolean isValid(){
        boolean reportIsAscending = reportIsAscending();
        for(int i = 1; i< report.size(); i++){
            int prev = report.get(i-1);
            int curr = report.get(i);

            int difference = prev - curr;
            if(outOfBound(difference) || orderChanged(reportIsAscending, prev, curr)){
                return false;
            }

        }
        return true;
    }

    private boolean reportIsAscending() {
        int prev = report.get(0);
        int curr = report.get(1);
        return  prev < curr;
    }

    private boolean orderChanged(boolean reportIsAscending, int prev, int current){
        return (reportIsAscending && current < prev) || (!reportIsAscending && current > prev);
    }

    private boolean outOfBound(int difference) {
        int abs = Math.abs(difference);
        return  abs < 1 || abs > 3;
    }
}
