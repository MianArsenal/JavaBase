package premain;

/**
 * Created by MIHE on 1/21/2019.
 */

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class Transformer implements ClassFileTransformer {

  private String mainClassName;
  private String mainClassMethod;
  private String monitorClassName;
  private String monitorClassMethoed;

  public Transformer(String[] args) {
    super();
    this.mainClassName = args[0];
    this.mainClassMethod = args[1];
    this.monitorClassName = args[2];
    this.monitorClassMethoed = args[3];
  }

  @Override
  public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
      ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
    System.out.print("Transformer.transform()->className:");
    System.out.println(className);
    if (className.equals(mainClassName) || className.equals(monitorClassName)) {
      return modifyMethod(className, className.equals(mainClassName) ? mainClassMethod : monitorClassMethoed);
    }
    return null;
  }

  private byte[] modifyMethod(String className, String m1) {
    ClassPool classPool = ClassPool.getDefault();
    try {
      CtClass mainClass = classPool.get(className.replaceAll("/", "."));
      CtMethod mainMethod = mainClass.getDeclaredMethod(m1);
      if (!mainMethod.isEmpty()) {
        if (className.equals(mainClassName)) {
          calculateRunTime(mainMethod);
        }
        mainMethod.insertBefore("System.out.println(\"before " + className + "!\");");
        mainMethod.insertAfter("System.out.println(\"after " + className + "!\");");
      }
      return mainClass.toBytecode();
    } catch (NotFoundException | CannotCompileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void calculateRunTime(CtMethod mainMethod) throws CannotCompileException {
    mainMethod.instrument(new ExprEditor() {
      @Override
      public void edit(MethodCall m) throws CannotCompileException {
        if (m.getMethodName().equals(monitorClassMethoed) && m.getClassName().replaceAll("\\.", "/").equals(monitorClassName)) {
          m.replace("long startTime = System.currentTimeMillis(); "
              + "System.out.println(\"startTime:\" + startTime);"
              + "$_ = $proceed($$);"
              + "long endTime = System.currentTimeMillis();"
              + "System.out.println(\"endTime:\" + endTime);"
              + "System.out.println(\"TotalCost:\" + (endTime - startTime) + \"ms\");");
        }
      }
    });
  }

  public String getMainClassName() {
    return mainClassName;
  }

  public void setMainClassName(String mainClassName) {
    this.mainClassName = mainClassName;
  }

  public String getMainClassMethod() {
    return mainClassMethod;
  }

  public void setMainClassMethod(String mainClassMethod) {
    this.mainClassMethod = mainClassMethod;
  }

  public String getMonitorClassName() {
    return monitorClassName;
  }

  public void setMonitorClassName(String monitorClassName) {
    this.monitorClassName = monitorClassName;
  }

  public String getMonitorClassMethoed() {
    return monitorClassMethoed;
  }

  public void setMonitorClassMethoed(String monitorClassMethoed) {
    this.monitorClassMethoed = monitorClassMethoed;
  }
}
