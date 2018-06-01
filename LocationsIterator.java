import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class LocationsIterator implements Iterator {

    private ArrayList<Location> locationsList;
    private int index;

    public LocationsIterator(ArrayList<Location> locationsList){
        this.locationsList = locationsList;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return this.index < this.locationsList.size();
    }

    @Override
    public Location next(){
        if(hasNext()){
            return locationsList.get(this.index);
        }else return null;
    }
    
}