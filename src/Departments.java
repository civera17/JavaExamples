import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Departments {

    public static StringBuilder resolveDepartments(ArrayList<String []> departments,
                                                   String [] currentDep , StringBuilder sb) {

        if (departments.size() > 0) {

            // identify first shift
            if (currentDep == null) {
                for (int i = 0; i < departments.size(); i++) {
                    if (departments.get(i)[0].isEmpty()) {
                        currentDep = departments.remove(i);
                        sb.append("\nDepartment: ").append(currentDep[1]);
                        break;
                    }
                }
            }

            // check if this is last shift
            if (currentDep != null) {
                if (currentDep.length < 3 || currentDep[2].isEmpty()) {
                    departments.remove(currentDep);
                    currentDep = null;
                } else {
                    // identify next shift
                    for (int i = 0; i < departments.size(); i++) {
                        if (currentDep[2].equals(departments.get(i)[0])) {
                            sb.append(" ").append(departments.get(i)[1]);
                            currentDep = departments.remove(i);
                            break;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(departments.stream().toArray()));
            resolveDepartments(departments, currentDep, sb);
        }
        return sb;
    }

    public void scan() {
        System.out.println("Insert line:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String [] deps = line.split(";");

        ArrayList<String []> departments = new ArrayList<>();

        for (String dep: deps) {
            departments.add(dep.split(","));
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(resolveDepartments(departments,null,sb));
    }
}
