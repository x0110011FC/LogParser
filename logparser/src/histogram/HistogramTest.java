package histogram;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {

    private Map<Integer, Long> aggregatedData = new HashMap<>();

    @Before
    public void init(){
        aggregatedData.put(1, 1L);
        aggregatedData.put(2, 2L);
        aggregatedData.put(3, 3L);
    }


    @Test
    void displayHistogram(Map<Integer, Long> aggregatedData) {
        Histogram histogram = new Histogram();
    }
}
