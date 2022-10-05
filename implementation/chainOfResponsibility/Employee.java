package implementation.chainOfResponsibility;

//Abstract handler
public abstract class Employee implements LeaveApprover {

    private String role;
    private LeaveApprover successor;

    Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.successor = successor;
    }

    @Override
    public void processLeaveApplication(LeaveApplication application){
        if(!processRequest(application) && successor != null){
            successor.processLeaveApplication(application);
        }else{
            System.out.println("Your request got approved by " + getApproverRole());
        }
    }

    protected abstract boolean processRequest(LeaveApplication application);

    @Override
    public String getApproverRole() {
        return this.role;
    }
	
}