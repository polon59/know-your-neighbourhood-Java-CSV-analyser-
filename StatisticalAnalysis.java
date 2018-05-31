import java.util.ArrayList;

public class StatisticalAnalysis {

    private ArrayList<Location> locations;

    public StatisticalAnalysis(ArrayList<Location> locations){
        this.locations = locations;
    }

    public void countLocationsByCategory(){
        String locationCategoryName;

        int województwoCounter = 0;
        int powiatCounter = 0;
        int gmCounter = 0;
        int gwCounter = 0;
        int gmwCounter = 0;
        int owCounter = 0;
        int miastoCounter = 0;
        int delegaturaCounter = 0;
        int mnppCounter = 0;


        System.out.println(locations.size() + "--SIZE");
        for (Location location : locations){
            locationCategoryName = location.getCategoryName();

            if (locationCategoryName.equals("województwo")){
                województwoCounter++;
            }
            else if (locationCategoryName.equals("powiat")||
                     locationCategoryName.equals("miasto na prawach powiatu")){
                powiatCounter++;
            }
            else if (locationCategoryName.equals("gmina miejska")){
                gmCounter++;
            }
            else if (locationCategoryName.equals("gmina wiejska")){
                gwCounter++;
            }
            else if (locationCategoryName.equals("gmina miejsko-wiejska")){
                gmwCounter++;
            }
            else if (locationCategoryName.equals("obszar wiejski")){
                owCounter++;
            }       
            else if (locationCategoryName.equals("miasto")){
                miastoCounter++;
            }
            else if (locationCategoryName.equals("delegatura")){
                delegaturaCounter++;
            }
            else if (locationCategoryName.equals("miasto na prawach powiatu")){
                mnppCounter++;
            }

        }

        System.out.println(województwoCounter + " " + powiatCounter + " " + gmCounter + " " + gwCounter);
    }
    
}