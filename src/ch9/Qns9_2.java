package ch9;

public class Qns9_2 {
  /*
  Algorithm design

  Step 1 Ask questions
` How big is the user base, a few million?
  Will there be constant updates to the system? (unfriending and friending happening)
  Must the updates to the system be instant? (change profile and instantly obtain the answer on all the node's neighbours)
  Will I need to handle the posts, messaging and comments on posts?
  What's the maximum amount of data I can store on the machine?

  Step 2 Make believe
  Graph based solution (undirected).
  DB to store the posts and comments of the user. (Hashmap)

  Algo => bidirectional BFS (will cause queue to be very long) (modified, start from src and dst)

  Step 3 Get real
  Preprocess? Updates every few minutes, asynchronously.
  Do a distributed lookup table that possibly converge to the right ans
   * the neighbours will have a look up table to the number of hops to the target u want
  Trust that neighbours number of hops to the target is updated and go wth the lowest hop.

  Step 4 Solve problems
  Updates not instant.... Maybe we can group certain nodes together as a strong connected component?
  Then we just focus on the strong connected component using bidirectional BFS
   */
}
