public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
//        Model randomTestedModel = new Model();
//        int firstLimit = 0, secondLimit = 100;
//        randomTestedModel.setCustomLimits(firstLimit, secondLimit);
//        int amountOfIterations = 100_000;
//        double averageDividing = (double) amountOfIterations / Math.abs(randomTestedModel.getEnd() - randomTestedModel.getStart() + 1);
//        double error = averageDividing * 0.3;
//        int[] allNums = new int[randomTestedModel.getEnd() - randomTestedModel.getStart() + 1];
//        for (int i = 0; i < amountOfIterations; i++) {
//            randomTestedModel.guessTheNumber();
//            int num = randomTestedModel.getAnswer();
//            if (randomTestedModel.getStart() < 0) num += Math.abs(randomTestedModel.getStart());
//            allNums[num]++;
//        }
//        for (int allNum : allNums) Assert.assertTrue(Math.abs(allNum - averageDividing) < error);
//        int sum = 0;
//        for (int i : allNums) sum += i;
//        double average = 0.3 * (double) sum / allNums.length;
//        int t = 0, f = 0;
//        for (int i : allNums) {
//            if (i < average) t++;
//            else f++;
//        }
//        System.out.println(t);
//        System.out.println(f);
    }
}
