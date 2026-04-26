// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.ArrayList;
import java.util.List;

public class TaskDelete {
   private List<String> tasks = new ArrayList();

   public TaskDelete() {
   }

   public void addTask(String var1) {
      this.tasks.add(var1);
   }

   public boolean deleteTask(String var1) {
      return this.tasks.remove(var1);
   }

   public List<String> getTasks() {
      return this.tasks;
   }

   public int getTaskCount() {
      return this.tasks.size();
   }
}