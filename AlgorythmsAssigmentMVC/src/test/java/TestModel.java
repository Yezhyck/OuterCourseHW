import org.junit.*;

public class TestModel {
    private Model generalModel;

    @Before
    public void initializeModel() {
        generalModel = new Model();
    }

    @Test
    public void testSetDefaultLimits() {
        generalModel.setDefaultLimits();
        Assert.assertEquals(Model.ZERO, generalModel.getStart());
        Assert.assertEquals(Model.ONE_HUNDRED, generalModel.getEnd());
    }

    @Test
    public void testSetCustomLimits() {
        int firstLimit = -11324, secondLimit = 5791;
        Assert.assertFalse(generalModel.setCustomLimits(secondLimit, firstLimit));
        Assert.assertTrue(generalModel.setCustomLimits(firstLimit, secondLimit));
        Assert.assertEquals(firstLimit, generalModel.getStart());
        Assert.assertEquals(secondLimit, generalModel.getEnd());
    }

    @Test
    public void testGuessTheNumber() {
        int firstLimit = -100, secondLimit = 100;
        generalModel.setCustomLimits(firstLimit, secondLimit);
        int amountOfIterations = 100_000;
        double averageDividing = (double) amountOfIterations / Math.abs(generalModel.getEnd() - generalModel.getStart() + 1);
        double error = averageDividing * 0.2;
        int[] allNums = new int[generalModel.getEnd() - generalModel.getStart() + 1];
        for (int i = 0; i < amountOfIterations; i++) {
            generalModel.guessTheNumber();
            int num = generalModel.getAnswer();
            if (generalModel.getStart() < 0) num += Math.abs(generalModel.getStart());
            allNums[num]++;
        }
        for (int allNum : allNums) Assert.assertTrue(Math.abs(allNum - averageDividing) < error);
    }

    @Test
    public void testCheckNumber() {
        generalModel.setCustomLimits(-100, 100);
        Assert.assertTrue(generalModel.checkNumber(-100));
        Assert.assertTrue(generalModel.checkNumber(-33));
        Assert.assertTrue(generalModel.checkNumber(-17));
        Assert.assertTrue(generalModel.checkNumber(50));
        Assert.assertTrue(generalModel.checkNumber(79));
        Assert.assertTrue(generalModel.checkNumber(100));
        Assert.assertFalse(generalModel.checkNumber(-300));
        Assert.assertFalse(generalModel.checkNumber(-218));
        Assert.assertFalse(generalModel.checkNumber(-101));
        Assert.assertFalse(generalModel.checkNumber(11065));
        Assert.assertFalse(generalModel.checkNumber(101));
        Assert.assertFalse(generalModel.checkNumber(246));
    }

    @Test
    public void testUpdateModel() {
        generalModel.setDefaultLimits();
        Assert.assertEquals(Model.EQUALS, generalModel.updateModel(generalModel.getAnswer()));
        Assert.assertEquals(Model.ZERO, generalModel.getStart());
        Assert.assertEquals(Model.ONE_HUNDRED, generalModel.getEnd());
    }

    @Test
    public void testConfigureLimits() {
        generalModel.setDefaultLimits();
        int i = 0;
        String answer = generalModel.updateModel(i);
        while (!answer.equals(Model.EQUALS)) {
            generalModel.configurePlayer(i, answer);
            answer = generalModel.updateModel(i);
            i++;
        }
        Assert.assertEquals(i, generalModel.getAttempts().size());
        Assert.assertEquals(i, generalModel.getResultOfAttempts().size());
    }

    @After
    public void destroyModel() {
        generalModel = null;
    }
}
