public class InfoAction {
    private Action action;
    private Headquarter headquarter;
    private int numMembers;
    private int numNonMembers;
    private boolean pressCoverage;

    public InfoAction(Action a, Headquarter h, int nm, int nnm, boolean pc) {
        action = a;
        headquarter = h;
        numMembers = nm;
        numNonMembers = nnm;
        pressCoverage = pc;
    }

    public Action getAction() {
        return action;
    }

    public Headquarter getHeadquarter() {
        return headquarter;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public int getNumNonMembers() {
        return numNonMembers;
    }

    public boolean getPressCoverage() {
        return pressCoverage;
    }
}
