package implementation.chainOfResponsibility;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
	   LeaveApplication application1 = LeaveApplication.getBuilder()
			   .withType(LeaveApplication.Type.Sick)
			   .from(LocalDate.now())
			   .to(LocalDate.now().plusDays(2))
			   .build();
	   LeaveApprover approver = createChain();

	   System.out.println("++++++++++++++++++++++++++++++++++++++");
	   approver.processLeaveApplication(application1);
	   System.out.println(application1);

		LeaveApplication application2 = LeaveApplication.getBuilder()
				.withType(LeaveApplication.Type.Sick)
				.from(LocalDate.now())
				.to(LocalDate.now().plusDays(5))
				.build();
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		approver.processLeaveApplication(application2);
		System.out.println(application2);

		LeaveApplication application3 = LeaveApplication.getBuilder()
				.withType(LeaveApplication.Type.PTO)
				.from(LocalDate.now())
				.to(LocalDate.now().plusDays(4))
				.build();
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		approver.processLeaveApplication(application3);
		System.out.println(application3);

		LeaveApplication application4 = LeaveApplication.getBuilder()
				.withType(LeaveApplication.Type.PTO)
				.from(LocalDate.now())
				.to(LocalDate.now().plusDays(10))
				.build();
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		approver.processLeaveApplication(application4);
		System.out.println(application4);
	}

	private static LeaveApprover createChain() {
		Director director = new Director(null);
		Manager manager = new Manager(director);
		ProjectLead lead = new ProjectLead(manager);
		return lead;
	}
}
