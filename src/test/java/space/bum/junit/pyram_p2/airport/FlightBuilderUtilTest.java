package space.bum.junit.pyram_p2.airport;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class FlightBuilderUtilTest {

  @Test
  void test() throws FileNotFoundException, IOException {
    FlightBuilderUtil.buildFlightFromCsv();
  }

}
