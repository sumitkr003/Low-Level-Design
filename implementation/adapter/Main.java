package implementation.adapter;

public class Main {

	public static void main(String[] args) {
		// Using Class/Two-way adapter
		EmployeeClassAdapter classAdapter = new EmployeeClassAdapter();
		populateEmployeeData(classAdapter);
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String cardDesignUsingClassAdapter = designer.designCard(classAdapter);
		System.out.println(cardDesignUsingClassAdapter);

		System.out.println("++++++++++++++++++++++++++++++++++++++++");

		// Using Object Adapter
		Employee employee = new Employee();
		populateEmployeeData(employee);
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
		String cardDesignUsingObjectAdapter = designer.designCard(objectAdapter);
		System.out.println(cardDesignUsingObjectAdapter);
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}
