
public class Location {

    String name;
    String category;
    String belongingCountyID;

    public Location(String name, String category, String belongingCountyID){
        this.name = name;
        this.category = category;
        this.belongingCountyID = belongingCountyID;
    }

    public String getName(){
        return this.name;
    }

    public String getCategoryName(){
        return this.category;
    }

    public String getBelongingCountyID(){
        return this.belongingCountyID;
    }

    @Override
    public String toString(){
        return this.name +" " + this.category + " " + this.belongingCountyID;
    }
    
}