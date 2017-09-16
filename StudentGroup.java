import java.util.Date;
import java.text.*;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		if(students.length!=0)
		return students;
		else
		return null;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
			if (students == null)
				throw new IllegalArgumentException("Number of students must not be null");
			else
				this.students = students;

	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here

			if (index == 0 | index >= students.length)
			throw new IllegalArgumentException("index should not be zero");
			if(students==null)
			return null;
			else
			return students[index-1];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here

			if (student == null | index == 0 | index >= students.length)
				throw new IllegalArgumentException("student should not be null (OR) index should not be zero");
			else
				students[index] = student;

	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here

		if(student==null)
			throw new IllegalArgumentException("student should not be null");

			Student temp[] = new Student[(students.length) + 1];
			temp[0] = student;
			if (students.length != 0) {
				for (int i = 0; i < students.length; i++) {
					temp[i + 1] = students[i];
				}
				students = temp;
			}

				else
					throw new IllegalArgumentException("student size is zero.");


	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		Student temp[] = new Student[students.length + 1];
		if(student==null)
			throw new IllegalArgumentException("student should not be null");
		else {


			for (int i = 0; i < students.length; i++) {
				temp[i] = students[i];
			}

		}
		students=temp;

	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here

		if(student==null | index==0 | index>=students.length)
			throw  new IllegalArgumentException(" Student must not be null or index must not be zero.");

			else
				students[index]=student;

	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		Student tempStud[]=new Student[students.length];

		if(index==0 | index>=students.length)
				throw  new IllegalArgumentException(" Student must not be null or index must not be zero.");

			else {
			students[index - 1] = null;
		}
		for(int i=0;i<students.length;i++) {
			if(students[i]!=null)
			tempStud[i]=students[i];
		}
		students=tempStud;

	}

	@Override
	public void remove(Student student) {
		Student tempStud[]=new Student[students.length];
		// Add your implementation here
		boolean flag=true;
		if(student==null)
			throw  new IllegalArgumentException(" Student must not be null.");
		else {
			for (int i = 0; i < students.length; i++) {

						if((students[i].compareTo(student))==0){
						students[i]=null;
							flag=false;
							break;

						}
			}
		}
		if(flag==true)
			throw new IllegalArgumentException("Student not exist.");

		for(int i=0;i<students.length;i++) {
			if(students[i]!=null)
				tempStud[i]=students[i];
		}
		students=tempStud;

	}

	@Override
	public void removeFromIndex(int index) {
		Student tempStud[]=new Student[students.length];
		// Add your implementation here
		if(index==0 | index>students.length)
			throw new IllegalArgumentException("index not exists.");
		else
			for(int i=index+1;i<students.length;i++)
				students[i]=null;

		for(int i=0;i<students.length;i++) {
			if(students[i]!=null)
				tempStud[i]=students[i];
		}
		students=tempStud;

	}

	@Override
	public void removeFromElement(Student student) {

		Student tempStud[]=new Student[students.length];
		// Add your implementation here
		int pos=0;
		if(student==null)
			throw new IllegalArgumentException("Student not exist.");
		else {
			for (int i = 0; i < students.length; i++) {

				if((students[i].compareTo(student))==0){
					pos = i;
					break;
				}
			}


			for (int j = pos + 1; j < students.length; j++) {
				students[j] = null;
			}
		}

		for(int i=0;i<students.length;i++) {
			if(students[i]!=null)
				tempStud[i]=students[i];
		}
		students=tempStud;
	}

	@Override
	public void removeToIndex(int index) {

		Student tempStud[]=new Student[students.length];
		// Add your implementation here

		if(index==0 | index>students.length)
			throw new IllegalArgumentException("index not exists.");
		else
			for(int i=0;i<index-1;i++){
				students[i]=null;
			}

		for(int i=0;i<students.length;i++) {
			if(students[i]!=null)
				tempStud[i]=students[i];
		}
		students=tempStud;
	}

	@Override
	public void removeToElement(Student student) {

		Student tempStud[]=new Student[students.length];
		// Add your implementation here

		int pos=0;
		if(student==null)
			throw new IllegalArgumentException("Student not exist.");
		else {
			for (int i = 0; i < students.length; i++) {

				if((students[i].compareTo(student))==0){
					pos = i;
					break;
				}
			}

			for (int j = 0; j < pos-1; j++) {
				students[j] = null;
			}
		}

		for(int i=0;i<students.length;i++) {
			if(students[i]!=null)
				tempStud[i]=students[i];
		}
		students=tempStud;
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int n=students.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if ((students[j].compareTo(students[j+1]))>0)
				{
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here

		String dateString=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sdf.format(date);
		String sdate=null;

		Student studTemp[]=new Student[students.length];
		if(date==null)
			throw new IllegalArgumentException("date is not valid.");
		else
		{
			for(int i=0;i<students.length;i++)
			{
				sdate=sdf.format(students[i].getBirthDate());
				if(sdate.equals(date1)) {
					studTemp[i] = students[i];
				}
			}
		}
		return studTemp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student tempStud[] = new Student[students.length];
		try {
			String dateString = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String begRange = sdf.format(firstDate);
			String endRange = sdf.format(lastDate);


			Date begRangee = sdf.parse(begRange);
			Date endRangee = sdf.parse(endRange);

			String stdate = null;
			Date sdate = null;

			if (firstDate == null | lastDate == null)
				throw new IllegalArgumentException("date is not valid.");
			else {
				for (int i = 0; i < students.length; i++) {

					sdate = students[i].getBirthDate();
					stdate = sdf.format(sdate);
					sdate = sdf.parse(stdate);

					if (sdate.before(endRangee) & sdate.after(begRangee))
						tempStud[i] = students[i];
				}
			}
			//return tempStud;
		}
		catch(Exception e){
			System.out.println("error is:"+e);
		}
		return tempStud;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Student studTemp[]=new Student[students.length];
		Date sdate=null;

		if(date==null)
			throw new IllegalArgumentException("date is not valid.");
		else
		{

			for(int i=0;i<students.length;i++)
			{
				sdate=students[i].getBirthDate();
				if(sdate.before(date)){

						studTemp[i] = students[i];
				}
			}

		}
		return studTemp;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		Student student=students[indexOfStudent];
		Date date=student.getBirthDate();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");

		Date today=new Date();
		String todayy=sdf.format(today);
		String birth=sdf.format(date);

		int diff=Integer.parseInt(todayy)-Integer.parseInt(birth);

		return diff;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student temp[]=new Student[students.length];

		for(int i=0;i<students.length;i++) {
			//temp=getCurrentAgeByDate(i);

		}

		return temp;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
