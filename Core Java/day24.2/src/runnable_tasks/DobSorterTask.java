package runnable_tasks;
import static java.lang.Thread.currentThread;
import static utils.IOUtils.writeData;
import static utils.StudentCollectionUtils.*;

import java.util.Map;

import com.app.core.Student;

public class DobSorterTask implements Runnable{
	private Map<String, Student> map;
	private String fileName;	

	public DobSorterTask(Map<String, Student> map, String fileName) {
		super();
		this.map = map;
		this.fileName = fileName;
		System.out.println("in constr of "+getClass().getName()+" invoked by "+currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName()+" strted");
		try {
			//B.L 
			writeData(sortStudentsByDob(map),fileName);
		}catch (Exception e) {
			System.out.println(currentThread().getName()+" got error "+e);
		}
		System.out.println(currentThread().getName()+" over");
	}

}
