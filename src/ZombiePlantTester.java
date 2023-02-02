import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZombiePlantTester {

    private ZombiePlant ZombiePlant;

    public void setUp() {
        ZombiePlant = new ZombiePlant(10,3);
    }

    public void tearDown() {
        ZombiePlant = null;
    }

    @Test
    public void TestConstructor() {
        setUp();
        assertEquals("Ensure that your constructor is implemented correctly!", ZombiePlant.getPotencyRequired(), 10);
        assertEquals("Ensure that your constructor is implemented correctly!", ZombiePlant.treatmentsNeeded(), 3);
        tearDown();
    }

    @Test
    public void TestIsDangerous() {
        setUp();
        assertEquals("Ensure that your isDangerous method is implemented correctly!", ZombiePlant.isDangerous(), true);
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterTreatments() {
        setUp();
        ZombiePlant.treat(7);
        ZombiePlant.treat(8);
        ZombiePlant.treat(9);
        assertEquals("Ensure that your treatment and isDangerous methods are implemented correctly!", ZombiePlant.isDangerous(), false);
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterTreatmentsNotAllSuccessful() {
        setUp();
        ZombiePlant.treat(7);
        ZombiePlant.treat(8);
        ZombiePlant.treat(10);
        assertEquals("Ensure that your treatment and isDangerous methods are implemented correctly!", ZombiePlant.isDangerous(), false);
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterSuccessfulAndUnsuccessfulTreatments() {
        setUp();
        ZombiePlant.treat(7);
        ZombiePlant.treat(8);
        ZombiePlant.treat(11);
        assertEquals("Ensure that your treatment and isDangerous methods are implemented correctly!", ZombiePlant.isDangerous(), true);
        tearDown();
    }

    @Test
    public void TestSuccessfulTreatment() {
        setUp();
        ZombiePlant.treat(7);
        assertEquals("Ensure that your treat method is implemented correctly!", ZombiePlant.treatmentsNeeded(), 2);
        tearDown();
    }

    @Test
    public void TestUnsuccessfulTreatment() {
        setUp();
        ZombiePlant.treat(11);
        assertEquals("Ensure that your treat method is implemented correctly!", ZombiePlant.treatmentsNeeded(), 4);
        tearDown();
    }

    @Test
    public void TestTreatmentOfPotencyZeroHasNoEffect() {
        setUp();
        ZombiePlant.treat(0);
        assertEquals("Ensure that a treatment of 0 potency is neither successful or unsuccessful!", ZombiePlant.treatmentsNeeded(), 3);
        tearDown();
    }

    @Test
    public void TestTreatmentOfPotencyLessThanZeroHasNoEffect() {
        setUp();
        for (int i = -100; i < 0; i++) {
            ZombiePlant.treat(i);
        }
        assertEquals("Ensure that a treatment of negative potency is neither successful or unsuccessful.", ZombiePlant.treatmentsNeeded(), 3);
        tearDown();
    }

    @Test
    public void TestSuccessfulTreatmentWhenTreatmentRequiredIsZero() {
        setUp();
        ZombiePlant.treat(10);
        ZombiePlant.treat(9);
        ZombiePlant.treat(8);
        ZombiePlant.treat(7);
        assertEquals("When the treatments required is equal to 0, any successful treatment should not decrement the treatments required.", ZombiePlant.treatmentsNeeded(), 0);
        tearDown();
    }

    @Test
    public void TestUnSuccessfulTreatmentWhenTreatmentRequiredIsZero() {
        setUp();
        ZombiePlant.treat(10);
        ZombiePlant.treat(9);
        ZombiePlant.treat(8);
        ZombiePlant.treat(11);
        assertEquals("When the treatments required is equal to 0, any unsuccessful treatment should increment the treatments required to 1.", ZombiePlant.treatmentsNeeded(), 1);
        tearDown();
    }

}