package ch6;

public class Qns6_2 {
  // Game 1 is p
  // Game 2 is p^3 + 3*p^2(1-p) => p^3 + 3p^2 - 3p^3 = 3p^2 - 2p^3
  // To pick 1, P(Game 1) > P(Game 2)
  // p > 3p^2 - 2p^3
  // 1 > 3p - 2p^2
  // 2p^2 -3p + 1 > 0
  // (2p - 1)(p - 1) > 0, since p < 1
  // (2p - 1)(p - 1) < 0
  // p = 0.5
  // Pick 1 is p < 0.5, pick 2 if p > 0.5
}
