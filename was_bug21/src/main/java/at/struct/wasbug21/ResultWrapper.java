package at.struct.wasbug21;

public class ResultWrapper {

    private final Long id;
    private final String name;


    public ResultWrapper(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
