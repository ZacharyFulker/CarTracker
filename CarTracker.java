import java.util.Scanner;

/**
 *
 * @author Zach
 */
public class CarTracker {
    public static Scanner input;
    public static MyPriorityQueue pricePQ;
    public static MyPriorityQueue mileagePQ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarTracker carTracker = new CarTracker();
        pricePQ = new MyPriorityQueue();
        mileagePQ = new MyPriorityQueue();
        input = new Scanner(System.in);
        carTracker.getInput();
        
    }
    
    public void getInput(){
        System.out.println("Welcome: ");
        System.out.println("1. Add Car");
        System.out.println("2. Update Car");
        System.out.println("3. Remove Car");
        System.out.println("4. Return lowest price car");
        System.out.println("5. Return lowest mileage car");
        System.out.println("6. Return lowest price car by manufacturer and model"); 
        System.out.println("7. Return lowest mileage car by manufacturer and model"); 
        System.out.println("8. Exit\n"); 
        System.out.println("Enter the number corresponding to the desired operation: ");
        
        int operation = input.nextInt();
        while(operation < 1 || operation > 8){
            System.out.println("Invalid input: Enter the number corresponding to the desired operation.\n");
            operation = input.nextInt();
        }

        if(operation == 1){
            addCar();
        } else if (operation == 2){
            updateCar();
        } else if (operation == 3){
            removeCar();
        } else if (operation == 4){
            returnLowestPriceCar();
        } else if (operation == 5){
            returnLowestMileageCar();
        } else if (operation == 6){
            returnLowestPriceCarByMakeAndModel();
        } else if (operation == 7){
            returnLowestMileageCarByMakeAndModel();
        } else {
            System.exit(0);
        }
    }

    private void addCar() {
        System.out.println("\nPlease enter the following information:\n");
        System.out.println("Enter a VIN:");
        String VIN = input.next();
        
        System.out.println("Enter the manufacturer:");
        String manufacturer = input.next();
        
        System.out.println("Enter the model:");
        String model = input.next();
        
        System.out.println("Enter the color:");
        String color = input.next();
        
        System.out.println("Enter the price:");
        double price = input.nextDouble();
        
        System.out.println("Enter the milage:");
        double milage = input.nextDouble();
        
        CarClass newCar = new CarClass(VIN, manufacturer, model, color, price, milage);
        
        mileagePQ.addCarToMileagePQ(newCar);
        pricePQ.addCarToPricePQ(newCar);
        
        System.out.println("\nEnter 1 to add another car or 0 to return to the main menu: ");
        int userInput = input.nextInt();
        if(userInput == 1){
            addCar();
        } else {
            getInput();
        }
    }

    private void updateCar() {
        System.out.println("Enter the Vin of the Car you wish to update: ");
        String VIN =  input.next();
        
        System.out.println("Enter 1 to update the color, 2 to update the price, 3 to update the mileage, and 4 to return to the main menu: ");
        
        int changeNumber = input.nextInt();
        
        if(changeNumber == 1){
            System.out.println("Enter the updated Color: ");
            String color = input.next();
            mileagePQ.changeColor(VIN, color);
            pricePQ.changeColor(VIN, color);
        } else if(changeNumber == 2){
            System.out.println("Enter the updated Price: ");
            double price = Double.parseDouble(input.next());
            pricePQ.updatePrice(price, VIN);
            mileagePQ.updatePrice(price, VIN);
        } else if(changeNumber == 3){
            System.out.println("Enter the updated Mileage: ");
            double milage = input.nextDouble();
            pricePQ.updateMilage(milage, VIN);
            mileagePQ.updateMilage(milage, VIN);
        } 
        getInput();
    }

    private void removeCar() {
        System.out.println("Please Enter the VIN of the car to be removed: ");
        String VIN = input.next();
        pricePQ.remove(VIN);
        mileagePQ.remove(VIN);
        System.out.println("The car with VIN:" + VIN + " has been removed");
        getInput();
    }

    private void returnLowestPriceCar() {
        String carInfo = pricePQ.returnLowestPriceCar();
        System.out.println(carInfo);            
        getInput();
    }

    private void returnLowestMileageCar() {
        String carInfo = mileagePQ.returnLowestMilageCar();  
        System.out.println(carInfo);
        getInput();
    }

    private void returnLowestPriceCarByMakeAndModel() {
        System.out.println("Enter the manufacturer of the car:");
        String manufacturer = input.next();
        System.out.println("Enter the model of the car:");
        String model = input.next();
        String carInfo = pricePQ.returnLowestMilageCarByManufacturerAndModel(manufacturer.toLowerCase(), model.toLowerCase());
        System.out.println(carInfo);
        getInput();
}

    private void returnLowestMileageCarByMakeAndModel() {
        System.out.println("Enter the manufacturer of the car:");
        String manufacturer = input.next();
        System.out.println("Enter the model of the car:");
        String model = input.next();
        String carInfo = pricePQ.returnLowestPriceCarByManufacturerAndModel(manufacturer.toLowerCase(), model.toLowerCase());
        System.out.println(carInfo);
        getInput();
    }
}