public class BestStudent implements Comparable<BestStudent> {
    private String name;
    private int level;

    public BestStudent() {
    }

    public BestStudent(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int compareTo(BestStudent o) {
        return this.getLevel() - o.getLevel();
    }

    @Override
    public String toString() {
        return "BestStudent{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}