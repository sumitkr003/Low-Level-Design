package implementation.chainOfResponsibility;

//A concrete handler
public class ProjectLead extends Employee {

    ProjectLead(LeaveApprover nextApprover){
        super("Project Lead", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        // If type of leave is sick leave and less than or equal to 2 days
        if(application.getType() == LeaveApplication.Type.Sick && application.getNoOfDays() <= 2){
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }
}
