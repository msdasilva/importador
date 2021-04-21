package Enuns;

public enum ProcedureEnum {
    MANUAL("manual"), AUTO("auto");

    private String method;
    ProcedureEnum(String procedureMethod){
        method = procedureMethod;
    }
}
