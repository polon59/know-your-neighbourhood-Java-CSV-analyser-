
public class Location {

    String name;
    String category;
    String belongingCountryID;

    public Location(String name, String category, String belongingCountryID){
        this.name = name;
        this.category = category;
        this.belongingCountryID = belongingCountryID;
    }

    public String getName(){
        return this.name;
    }

    public String getCategoryName(){
        return this.category;
    }

    public String getBelongingCountryID(){
        return this.belongingCountryID;
    }

    @Override
    public String toString(){
        return this.name +" " + this.category + " " + this.belongingCountryID;
    }
    
}