package pradeepshah.SpringProject.demo.streamApi;

import java.util.Objects;

public class Department {
    int deptId;
    String deptName;
    public Department(int deptId, String deptName){
        this.deptId = deptId;
        this.deptName = deptName;
    }
    // ✅ equals & hashCode required for correct grouping in Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return deptId == that.deptId && Objects.equals(deptName, that.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName);
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + deptId + ", name='" + deptName + '\'' + '}';
    }
}
