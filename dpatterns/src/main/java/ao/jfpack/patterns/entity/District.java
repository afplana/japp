package ao.jfpack.patterns.entity;

public class District extends BaseEntity {

    public String name;
    public String zip;
    public Country country;

    public District(long id, String name, String zip, Country country){
        this.id = id;
        this.name = name;
        this.zip = zip;
        this.country = country;
    }

    public District(long id, String name, String zip){
        this(id, name, zip, null);
    }
    public District(){}

    @Override
    public String toJson() {
        return "{ id: " +id+ ", name: '" +name+ "', zip: '" +zip+ "', " +country.toJson()+ " }";
    }
}
