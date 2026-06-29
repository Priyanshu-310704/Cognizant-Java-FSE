public class TaskLinkedList {
    private Node head;

    private static class Node {
        private Task task;
        private Node next;

        private Node(Task task) {
            this.task = task;
        }
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public Task searchTask(int taskId) {
        Node current = head;

        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }

        return null;
    }

    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void traverseTasks() {
        Node current = head;

        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskLinkedList tasks = new TaskLinkedList();

        tasks.addTask(new Task(401, "Prepare resume", "Pending"));
        tasks.addTask(new Task(402, "Practice Java", "In Progress"));
        tasks.addTask(new Task(403, "Apply for job", "Pending"));

        System.out.println("All tasks:");
        tasks.traverseTasks();

        System.out.println("\nSearch task 402:");
        System.out.println(tasks.searchTask(402));

        tasks.deleteTask(401);
        System.out.println("\nAfter deleting task 401:");
        tasks.traverseTasks();
    }
}
