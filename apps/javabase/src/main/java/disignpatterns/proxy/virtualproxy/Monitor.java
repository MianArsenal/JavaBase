package disignpatterns.proxy.virtualproxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MIHE on 3/22/2019.
 * 班长类：代理教师收集作业，虚拟代理教师批改作业（实际为收集作业后交由教师批改）
 */
public class Monitor implements ICorrection{

  List<String> students;
  Teacher teacher;

  public Monitor() {
    this.students = new ArrayList<>();
  }

  public void collect(String name) {
    if (null == this.teacher) {
      this.students.add(name);
    } else {
      this.teacher.collect(name);
    }
  }

  @Override
  public void correct() {
    if(null == this.teacher) {
      synchronized (this) {
        this.teacher = new Teacher(this.students);
      }
    }
    this.teacher.correct();
  }
}
