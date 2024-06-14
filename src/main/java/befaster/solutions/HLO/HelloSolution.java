package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        return "Hello, " + friendName + "!";
    }

    public static void main(String[] args) {
        HelloSolution h = new HelloSolution();
        System.out.println(h.hello(args[0]));
    }
}



