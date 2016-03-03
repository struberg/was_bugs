package at.struct.wasbug19;

public class Report {


    private final Long id;

    private final String name;

    private final Integer theInteger;


    public Report(Long id, String name, Integer theInteger) {
        this.id = id;
        this.name = name;
        this.theInteger = theInteger;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTheInteger() {
        return theInteger;
    }
}
