public class ZombiePlant {
    int potency;
    int treatments;

    public ZombiePlant(int potency, int treatments) {
        this.potency = potency;
        this.treatments = treatments;
    }

    public int getPotencyRequired(){
        return potency;
    }

    public int treatmentsNeeded(){
        return treatments;
    }

    public boolean isDangerous(){
        if(treatments > 0){
            return true;
        }
        return false;
    }

    public void treat(int potency){
        if(isDangerous()) {
            if (potency <= 10 && potency > 0) {
                treatments--;
            }
        }
        if (potency > 10) {
            treatments++;
        }

    }


}
