package dk.rigqx.battlepass.listener;

public enum Plans {
    P1("Plan 1", 14), P2("Plan 2",30), P3("Plan 3", 90);

    public String plan;
    public int period;

    Plans(String plan, int period) {
        this.plan = plan;
        this.period = period;
    }
}
