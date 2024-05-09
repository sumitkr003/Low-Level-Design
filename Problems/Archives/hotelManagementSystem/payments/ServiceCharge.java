package hotelManagementSystem.payments;

public class ServiceCharge {
    private ServiceType serviceType;
    private Double charge;
    private Double gst;
    private Double vat;

    public ServiceType getServiceType() {
        return serviceType;
    }
    public Double getAmount() {
        return this.charge + this.gst + this.vat;
    }
}
