package space.bum.junit.pyram_p2.airport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;

@Getter
public class Flight {
  private String flightNumber;
  private int seats;
  private int passengers;
  private String origin;
  private String destination;
  private boolean flying;
  private boolean takenOff;
  private boolean landed;

  private String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
  private Pattern pattern = Pattern.compile(flightNumberRegex);

  public Flight(String flightNumber, int seats) {
    Matcher matcher = pattern.matcher(flightNumber);
    if (!matcher.matches()) {
      throw new RuntimeException("항공편 번호 오류");
    }
    this.flightNumber = flightNumber;
    this.seats = seats;
    this.passengers = 0;
    this.flying = false;
    this.takenOff = false;
    this.landed = false;
  }

  public void setSeats(int seats) {
    if (passengers > seats) {
      throw new RuntimeException("기존 승객 수 보다 좌석 수를 줄일 수 없다!");
    }

    this.seats = seats;
  }

  public void setOrigin(String origin) {
    if (takenOff) {
      throw new RuntimeException("이륙한 항공편의 출발지점은 변경될 수 없다!");
    }

    this.origin = origin;
  }

  public void setDestination(String destination) {
    if (landed) {
      throw new RuntimeException("착륙한 항공편의 출발지점은 변경될 수 없다!");
    }
    this.destination = destination;
  }

  @Override
  public String toString() {
    return "항공편 번호: " + getFlightNumber() +
        ", 출발: " + getOrigin() + ", 도착: " + getDestination();
  }

  public void addPassenger() {
    if (passengers >= seats) {
      throw new RuntimeException("좌석 부족!");
    }
    passengers++;
  }

  public void takeOff() {
    System.out.println(this + " 이륙 중");
    flying = true;
    takenOff = true;
  }

  public void land() {
    System.out.println(this + " 착륙 중");
    flying = false;
    landed = true;
  }
}
