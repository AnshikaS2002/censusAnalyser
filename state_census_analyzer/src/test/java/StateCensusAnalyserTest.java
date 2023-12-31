
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

    @Test
    public void TestWhenFileNotExists() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(WRONG_FILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void TestIncorrectFileExtension()
            throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }

}