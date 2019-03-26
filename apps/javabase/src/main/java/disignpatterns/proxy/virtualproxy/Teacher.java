package disignpatterns.proxy.virtualproxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MIHE on 3/22/2019.
 * 教师类：具体主题类，批改作业的具体实现者
 */
public class Teacher implements ICorrection {

  List<String> students;

  public Teacher(List<String> students) {
    this.students = students;
  }

  public void collect(String name) {
    this.students.add(name);
  }

  @Override
  public void correct() {
    for(int i = this.students.size() - 1; i >=0; i--) {
      System.out.println("Teacher has corrected " + this.students.get(i) + "'s task!");
      this.students.remove(i);
    }
  }
}
