
public class LocationCreator {

    public void evaluateLocationType(String[] locationInfo){
        String locationName = locationInfo[5];

        switch(locationInfo){
            case "województwo":
                createNewProduct();
                break;
            case "powiat":
                addProductToBasket();
                break;
            case "gmina miejska":
                displayProductsInBasket();
                break;
            case "gmina wiejska":
                displayProductsInBasket();
                break;
            case "gmina miejsko-wiejska":
                displayProductsInBasket();
                break;
            case "obszar wiejski":
                displayProductsInBasket();
                break;
            case "miasto":
                
                break;
            case "delegatura":

                break;
            case "miasto na prawach powiatu":
                displayProductsInBasket();
                break;
        }
    }
}