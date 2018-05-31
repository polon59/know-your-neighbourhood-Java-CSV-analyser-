
public class LocationCreator {

    public LocationCreator(){

    }

    public void evaluateLocationType(String[] locationInfo){
        String locationName = locationInfo[5];

            if (locationName.equals("województwo")){
                System.out.println("województwo");
            }
            else if (locationName.equals("powiat")){
                System.out.println("powiat");
            }
            else if (locationName.equals("gmina miejska")){
                System.out.println("gmina miejska");
            }
            else if (locationName.equals("gmina wiejska")){
                System.out.println("gmina wiejska");
            }
            else if (locationName.equals("gmina miejsko-wiejska")){
                System.out.println("gmina miejsko-wiejska");
            }
            else if (locationName.equals("obszar wiejski")){
                System.out.println("obszar wiejski");
            }       
            else if (locationName.equals("miasto")){
                System.out.println("miasto");
            }
            else if (locationName.equals("delegatura")){
                System.out.println("delegatura");
                }
            else if (locationName.equals("miasto na prawach powiatu")){
                System.out.println("miasto na prawach powiatu");
            }
    }
}