import java.util.ArrayList;

/**
 *
 * @author Zach
 */
public class MyPriorityQueue {
    public CarClass[] CarPQ;
    public ArrayList<String> indirectionArray;
    public boolean isEmpty;
    public int size;
    
    public MyPriorityQueue(){
        CarPQ = new CarClass[100];
        indirectionArray = new ArrayList<String>();
        isEmpty = true;
        size = 0;
    }
    
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return isEmpty;
    }
 
    public void changeColor(String newColor, String VIN){       
        int index = indirectionArray.indexOf(VIN);
        if(index == -1){
            System.out.println("ERROR: VIN not found");
        } else {
            CarPQ[index].setColor(newColor);
        }
    }
    
    public void updatePrice(double newPrice, String VIN){        
        int index = indirectionArray.indexOf(VIN);
        if(index == -1){
            System.out.println("ERROR: VIN not found");
        }
        else{
            CarPQ[index].setPrice(newPrice);
            sink(index, 0);
            index = indirectionArray.indexOf(VIN);
            swim(index, 0);
        }
    }
    
    public void updateMilage(double newMilage, String VIN){
        int index = indirectionArray.indexOf(VIN);
        if(index == -1){
            System.out.println("ERROR: VIN not found");
        }
        else{
            CarPQ[index].setMilage(newMilage);
            sink(index, 0);
            index = indirectionArray.indexOf(VIN);
            swim(index, 0);
        }
    }
    
    public boolean addCarToPricePQ(CarClass car){
        CarPQ[size] = car;
        indirectionArray.add(size, car.getVIN());
        swim(size, 1);
        size ++;
        return true;
    }
    
    public boolean addCarToMileagePQ(CarClass car){
        CarPQ[size] = car;
        indirectionArray.add(size, car.getVIN());
        swim(size, 0);
        size ++;
        return true;
    }
    
    public String returnLowestPriceCar(){
        String carInfo;
        if(CarPQ[0] == null){
            carInfo = "There are no cars in the PQ!";
        } else {
            carInfo = "\n" + "VIN is " + CarPQ[0].getVIN() + "\n" + "Manufacturer is " + CarPQ[0].getManufacturer() + "\n" + "Model is " + CarPQ[0].getModel() + "\n" + "Color is " + CarPQ[0].getColor() + "\n" + "Price is $" + CarPQ[0].getPrice() + "\n" + "Milage is " + CarPQ[0].getMilage() + " miles \n";
        }
        return carInfo;
    }

    public String returnLowestPriceCarByManufacturerAndModel(String manufacturer, String model){
        String carInfo;
        CarClass[] tempArray = new CarClass[100];
        int tempIndex = 0;
        int counter = 0;
      
        if(CarPQ[0] == null){
            carInfo = "There are no cars in the PQ!";
        } else {
            while(CarPQ[counter] != null){
                if((CarPQ[counter].getManufacturer()).equalsIgnoreCase(manufacturer)){
                    if(CarPQ[counter].getModel().equalsIgnoreCase(model)){
                        tempArray[tempIndex] = CarPQ[counter];
                        tempIndex ++;
                    }
                }                
                counter++;
            }

            if(tempArray[0] == null){
                carInfo = "No car with the given manufacturer and model was found.";
            } else {
                tempIndex = 0;
                CarClass tempCar = tempArray[tempIndex];
                while(tempArray[tempIndex] != null){ 
                    if(tempArray[tempIndex].getPrice() < tempCar.getPrice()){
                        tempCar = tempArray[tempIndex];
                    }                 
                    tempIndex ++;
                }
                carInfo = "\n" + "VIN is " + tempCar.getVIN() + "\n" + "Manufacturer is " + tempCar.getManufacturer() + "\n" + "Model is " + tempCar.getModel() + "\n" + "Color is " + tempCar.getColor() + "\n" + "Price is $" + tempCar.getPrice() + "\n" + "Milage is " + tempCar.getMilage() + " miles \n";
            }
        }
        return carInfo;
    }
    
    public String returnLowestMilageCar(){
        String carInfo;
        if(CarPQ[0] == null){
            carInfo = "There are no cars in the PQ!";
        } else {
            carInfo = "\n" + "VIN is " + CarPQ[0].getVIN() + "\n" + "Manufacturer is " + CarPQ[0].getManufacturer() + "\n" + "Model is " + CarPQ[0].getModel() + "\n" + "Color is " + CarPQ[0].getColor() + "\n" + "Price is $" + CarPQ[0].getPrice() + "\n" + "Milage is " + CarPQ[0].getMilage() + " miles \n";
        }  
        return carInfo;
    }

    public String returnLowestMilageCarByManufacturerAndModel(String manufacturer, String model){
        String carInfo;
        CarClass[] tempArray = new CarClass[100];
        int counter = 0;
        int tempIndex = 0;
        
        if(CarPQ[0] == null){
            carInfo = "There are no cars in the PQ!";
        } else {
            while(CarPQ[counter] != null){
                if((CarPQ[counter].getManufacturer()).equalsIgnoreCase(manufacturer)){
                    if(CarPQ[counter].getModel().equalsIgnoreCase(model)){
                        tempArray[tempIndex] = CarPQ[counter];
                        tempIndex ++;
                    }
                }
                counter++;
            }
            if(tempArray[0] == null){
                carInfo = "No car with the given manufacturer and model was found.";
            } else {
                tempIndex = 0;
                CarClass tempCar = tempArray[tempIndex];
                while(tempArray[tempIndex] != null){
                    if(tempArray[tempIndex].getMilage() < tempCar.getMilage()){
                        tempCar = tempArray[tempIndex];
                    }
                    tempIndex ++;
                }
                carInfo = "\n" + "VIN is " + tempCar.getVIN() + "\n" + "Manufacturer is " + tempCar.getManufacturer() + "\n" + "Model is " + tempCar.getModel() + "\n" + "Color is " + tempCar.getColor() + "\n" + "Price is $" + tempCar.getPrice() + "\n" + "Milage is " + tempCar.getMilage() + " miles \n";
            }
        } 
        return carInfo;
    }
    
    public void remove(String VIN){
        int index = indirectionArray.indexOf(VIN);
        CarClass tempCar = CarPQ[index];
        int i = 0;
        while(CarPQ[i] != null){
            i ++;
        }
        i --;
        CarPQ[index] = CarPQ[i];
        CarPQ[i] = tempCar;
        CarPQ[i] = null;
        indirectionArray.remove(VIN);
        size --;
        sink(index, 0);
        sink(index, 1);
        swim(index, 0);
        swim(index, 1); 
    } 
    
    public void swim(int index, int PQ){
        if(PQ == 0){
            if(CarPQ[index + 1] != null){
                if(CarPQ[index].getMilage() > CarPQ[index + 1].getMilage()){
                    index += 1;
                }
            }
            while(index > 0 && (Math.floor(CarPQ[(index - 1)/2].getMilage())) > (CarPQ[index].getMilage())){
                if(CarPQ[index + 1] != null){
                    if(CarPQ[index].getMilage() > CarPQ[index + 1].getMilage()){
                        index += 1;
                    }
                }
                
                CarClass tempCar = CarPQ[(index - 1)/2];
                CarPQ[(index - 1)/2] = CarPQ[index]; 
                indirectionArray.set(((index - 1)/2), CarPQ[index].getVIN());
                CarPQ[index] = tempCar;
                indirectionArray.set(index, tempCar.getVIN());
                index = (index - 1)/2;
            }
        } else {
            if(CarPQ[index + 1] != null){
                if(CarPQ[index].getPrice() > CarPQ[index + 1].getPrice()){
                    index += 1;
                }
            }
            while(index > 0 && (Math.floor(CarPQ[(index - 1)/2].getPrice())) > (CarPQ[index].getPrice())){ 
                if(CarPQ[index + 1] != null){
                    if(CarPQ[index].getPrice() > CarPQ[index + 1].getPrice()){
                        index += 1;
                    }
                }
                
                CarClass tempCar = CarPQ[(index - 1)/2];
                CarPQ[(index - 1)/2] = CarPQ[index]; 
                indirectionArray.set(((index - 1)/2), CarPQ[index].getVIN());
                CarPQ[index] = tempCar;
                indirectionArray.set(index, tempCar.getVIN());
                
                index = (index - 1)/2;
            }
        }        
    }
    
    public void sink(int index, int PQ){
        if(PQ == 0){
            while(((2*index)+1) < size){
                int left = (2 * index) + 1;
                if(CarPQ[left + 1] != null){
                    if(left < size && (CarPQ[left].getMilage() > CarPQ[left + 1].getMilage())){
                        left += 1;
                    }
                }
                if((CarPQ[index].getMilage() < CarPQ[left].getMilage())){
                    break;
                }
                CarClass temp = CarPQ[index];
                CarPQ[index] = CarPQ[left];
                indirectionArray.set(index, CarPQ[left].getVIN());
                CarPQ[left] = temp;
                indirectionArray.set(left, temp.getVIN());
                index = left;
            }
        } else {
            while(((2*index)+1) < size){
                int left = (2 * index) + 1;
                if(CarPQ[left + 1] != null){
                    if(left < size && (CarPQ[left].getPrice() > CarPQ[left + 1].getPrice())){
                        left += 1;
                    }
                }
                if((CarPQ[index].getPrice() < CarPQ[left].getPrice())){
                    break;
                }
                CarClass temp = CarPQ[index];
                CarPQ[index] = CarPQ[left];
                indirectionArray.set(index, CarPQ[left].getVIN());
                CarPQ[left] = temp;
                indirectionArray.set(left, temp.getVIN());
                index = left;
            }
        }
    }
    
}
