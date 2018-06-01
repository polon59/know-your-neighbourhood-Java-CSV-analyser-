import java.util.ArrayList;
import java.util.HashMap;

public class StatisticalAnalysis {

    private ArrayList<Location> locations;
    private  HashMap<String, Integer> locationsCounters;

    public StatisticalAnalysis(ArrayList<Location> locations){
        this.locations = locations;
        this.locationsCounters= new HashMap<String, Integer>();
    }

    private void incrementLocationCounter(String location){
        locationsCounters.put(location, locationsCounters.getOrDefault(location, 1) + 1);
    }

    public void countLocationsByCategory(){
        String locationCategoryName;
        
        // int województwoCounter = 0;
        // int powiatCounter = 0;
        // int gmCounter = 0;
        // int gwCounter = 0;
        // int gmwCounter = 0;
        // int owCounter = 0;
        // int miastoCounter = 0;
        // int delegaturaCounter = 0;
        // int mnppCounter = 0;

        for (Location location : locations){
            locationCategoryName = location.getCategoryName();

            if (locationCategoryName.equals("województwo")){
                incrementLocationCounter("województwo");            
            }
            else if (locationCategoryName.equals("powiat")||
                     locationCategoryName.equals("miasto na prawach powiatu")){
                incrementLocationCounter("powiat");
            }
            else if (locationCategoryName.equals("gmina miejska")){
                incrementLocationCounter("gmina miejska");
            }
            else if (locationCategoryName.equals("gmina wiejska")){
                incrementLocationCounter("gmina wiejska");
            }
            else if (locationCategoryName.equals("gmina miejsko-wiejska")){
                incrementLocationCounter("gmina miejsko-wiejska");
            }
            else if (locationCategoryName.equals("obszar wiejski")){
                incrementLocationCounter("obszar wiejski");
            }       
            else if (locationCategoryName.equals("miasto")){
                incrementLocationCounter("miasto");
            }
            else if (locationCategoryName.equals("delegatura")){
                incrementLocationCounter("delegatura");
            }
            else if (locationCategoryName.equals("miasto na prawach powiatu")){
                incrementLocationCounter("miasto na prawach powiatu");
            }

        }
    }
}