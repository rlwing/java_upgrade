package interfaces;

public class CompanyEmployee implements Company, Employee {
    private String first;
    private String last;

    public CompanyEmployee(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String getName() {
        return Employee.super.getName() + " works for " + Company.super.getName();
    }

    @Override
    public String getFirst() {
        return first;
    }

    @Override
    public String getLast() {
        return last;
    }

    @Override
    public void doWork() {
        System.out.println("Converting caffine into work");
    }
}
