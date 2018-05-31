
public class StatisticalAnalysis {

    private ArrayList<Location> locations;

    public StatisticalAnalysis(ArrayList<Location> locations){
        this.locations = locations;
    }

    public void countLocationsByCategory(){
        String locationName;

        int województwoCounter = 0;
        int powiatCounter = 0;
        int gmCounter = 0;
        int gwCounter = 0;
        int gmwCounter = 0;
        int owCounter = 0;
        int miastoCounter = 0;
        int delegaturaCounter = 0;
        int mppCounter = 0;

        for (Location location : locations){
            locationName = location.getName();

            if (locationName.equals("województwo")){
                województwoCounter++;
            }
            else if (locationName.equals("powiat")){
                powiatCounter++;
            }
            else if (locationName.equals("gmina miejska")){
                gmCounter++;
            }
            else if (locationName.equals("gmina wiejska")){
                gwCounter++;
            }
            else if (locationName.equals("gmina miejsko-wiejska")){
                gmwCounter++;
            }
            else if (locationName.equals("obszar wiejski")){
                owCounter++;
            }       
            else if (locationName.equals("miasto")){
                miastoCounter++;
            }
            else if (locationName.equals("delegatura")){
                delegaturaCounter++;
                }
            else if (locationName.equals("miasto na prawach powiatu")){
                mppCounter++;
            }
        }

        System.out.println(województwoCounter + " " + powiatCounter + " " + gmCounter + " " + gwCounter);
    }
    
}