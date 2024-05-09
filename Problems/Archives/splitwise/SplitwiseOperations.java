package splitwise;

public enum SplitwiseOperations {
    EXPENSE("EXPENSE"),
    SHOW("SHOW");

    String operation;
    SplitwiseOperations(String op) {
        this.operation = op;
    }
    public static SplitwiseOperations getSplitwiseOperation(String splitwiseOperation) {
        for(SplitwiseOperations curr : SplitwiseOperations.values()) {
            if(curr.operation.equals(splitwiseOperation)) {
                return curr;
            }
        }
        return null;
    }
}
