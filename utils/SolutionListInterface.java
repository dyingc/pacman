package pacman.utils;

import java.util.List;

public interface SolutionListInterface extends List {
  public SolutionInterface getSolution(PuzzleInterface puzzle);
  public SolutionListInterface split(int splitSeq);
  public SolutionListInterface[] ramdomMerge(SolutionListInterface[] solutionLists);
}
