
import org.junit.jupiter.api.Assertions;

import com.example.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.*;

public class StateCensusAnalyserTest {
    public static final String STATECODES_CSVFILE = "D:\\Ge_Assignments\\censusAnalyser\\state_census_analyzer\\src\\main\\resources\\StateCode.csv";
    public static final String STATECENSUS_CSVFILE = "state_census_analyzer\\src\\main\\resources\\StateCensusData.csv";
    public static final String WRONG_FILE = "/useless.txt";

    @Test
    public void CheckNumberOfRecords() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
            System.out.println(count);
            assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

}