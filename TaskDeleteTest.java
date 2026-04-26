// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskDeleteTest {
   private TaskDelete taskDelete;

   public TaskDeleteTest() {
   }

   @BeforeEach
   void setUp() {
      this.taskDelete = new TaskDelete();
      this.taskDelete.addTask("Task One");
      this.taskDelete.addTask("Task Two");
      this.taskDelete.addTask("Task Three");
   }

   @Test
   void testDeleteExistingTask() {
      boolean var1 = this.taskDelete.deleteTask("Task Two");
      Assertions.assertTrue(var1);
      Assertions.assertEquals(2, this.taskDelete.getTaskCount());
   }

   @Test
   void testDeleteNonExistingTask() {
      boolean var1 = this.taskDelete.deleteTask("Task Four");
      Assertions.assertFalse(var1);
      Assertions.assertEquals(3, this.taskDelete.getTaskCount());
   }

   @Test
   void testDeleteAllTasks() {
      this.taskDelete.deleteTask("Task One");
      this.taskDelete.deleteTask("Task Two");
      this.taskDelete.deleteTask("Task Three");
      Assertions.assertEquals(0, this.taskDelete.getTaskCount());
   }

   @Test
   void testDeleteFromEmptyList() {
      TaskDelete var1 = new TaskDelete();
      boolean var2 = var1.deleteTask("Task One");
      Assertions.assertFalse(var2);
   }

   @Test
   void testDeleteFirstTask() {
      boolean var1 = this.taskDelete.deleteTask("Task One");
      Assertions.assertTrue(var1);
      Assertions.assertEquals(2, this.taskDelete.getTaskCount());
   }

   @Test
   void testDeleteLastTask() {
      boolean var1 = this.taskDelete.deleteTask("Task Three");
      Assertions.assertTrue(var1);
      Assertions.assertEquals(2, this.taskDelete.getTaskCount());
   }

   @Test
   void testDeleteSameTaskTwice() {
      this.taskDelete.deleteTask("Task Two");
      boolean var1 = this.taskDelete.deleteTask("Task Two");
      Assertions.assertFalse(var1);
   }

   @Test
   void testDeleteEmptyStringTask() {
      boolean var1 = this.taskDelete.deleteTask("");
      Assertions.assertFalse(var1);
   }

   @Test
   void testDeleteSingleTask() {
      TaskDelete var1 = new TaskDelete();
      var1.addTask("Single Task");
      boolean var2 = var1.deleteTask("Single Task");
      Assertions.assertTrue(var2);
      Assertions.assertEquals(0, var1.getTaskCount());
   }

   @Test
   void testTaskListAfterDeletion() {
      this.taskDelete.deleteTask("Task Two");
      Assertions.assertFalse(this.taskDelete.getTasks().contains("Task Two"));
   }
}