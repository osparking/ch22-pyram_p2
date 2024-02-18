package space.bum.junit.pyram_p2.airport.producers;

import java.io.IOException;

import javax.enterprise.inject.Produces;

import space.bum.junit.pyram_p2.airport.Flight;
import space.bum.junit.pyram_p2.airport.FlightBuilderUtil;

public class FlightProducer {
  @Produces
  public Flight createFlignt() throws IOException {
    return FlightBuilderUtil.buildFlightFromCsv();
  }
}
