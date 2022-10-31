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

    /*public void setHeadquarter(Headquarter h) {
        headquarter = h;
    }*/

    public Action getAction() {
        return action;
    }
}
