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
        if (this.index < this.locationsList.size()){
            return true;
        }
        else{
            resetIteratorIndex();
            return false;
        }
    }

    @Override
    public Location next(){
        if(hasNext()){
            index ++;
            return locationsList.get(this.index-1);
        }else return null;
    }

    public void resetIteratorIndex(){
        //this method resets index to 0, which allows to use the same iterator once again
        this.index = 0;
    }
    
}