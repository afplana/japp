package ao.jfpack.patterns.entity;

public class Country extends BaseEntity {

    public String name;

    public Country(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {
    }


    @Override
    public String toJson() {
        return "{ id: "+id+ ", name: '"+name+"' }";
    }
}
