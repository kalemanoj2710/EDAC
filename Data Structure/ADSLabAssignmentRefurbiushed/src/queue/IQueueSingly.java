package queue;

public interface IQueueSingly {
void addElement(String num);
void deleteElement(String num);
String firstElement();
String lastElement();
void printQueue();
boolean isFull();
boolean isEmpty();
}
