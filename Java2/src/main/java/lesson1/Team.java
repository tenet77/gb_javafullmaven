package lesson1;


public class Team {
    private final IMember[] members;
    private final String name;
    private StringBuffer log;

    public Team(String name, IMember[] initMembers) {
        this.name = name;
        this.members = new IMember[initMembers.length];
        System.arraycopy(initMembers, 0, this.members, 0, initMembers.length);
        initCourseLog();
    }

    public void initCourseLog() {
        this.log = new StringBuffer();
        addLog("Team: " + this.name);
    }

    private void addLog(String record) {
        this.log.append(record).append("\n");
    }

    public void onStart() {
        for (IMember i : members) {
            i.onStart();
        }
    }

    public void showResults() {
        System.out.println(log);
    }

    public void passCourse(IObstacle obstacle) {
        for (IMember i : members) {
            if (i.isOnCourse()) {
                if (obstacle instanceof Treadmill) {
                    addLog(i.run(obstacle));
                } else if (obstacle instanceof Wall) {
                    addLog(i.jump(obstacle));
                }
            }
        }
    }
}
