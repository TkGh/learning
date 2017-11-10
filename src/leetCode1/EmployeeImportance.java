package leetCode1;

import java.util.*;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        int sum = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee curr = queue.poll();
            sum += curr.importance;
            for (int sub : curr.subordinates) {
                queue.offer(map.get(sub));
            }
        }

        return sum;
    }

}
