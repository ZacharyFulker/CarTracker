
/**
 *
 * @author Zach
 */
public class CarClass { 
    
    private String VIN;
    private String manufacturer;
    private String model;
    private String color;
    private double price;
    private double milage;
    public CarClass rightChild;
    public CarClass leftChild;
    
    public CarClass(String VIN, String manufacturer, String model, String color, double price, double milage){        
        this.VIN = VIN;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color; 
        this.price = price;
        this.milage = milage;    
    }
    
    // setters & getters
    public String getVIN(){
        return this.VIN;
    }
    
    public void setVIN(String newVIN){
         this.VIN = newVIN;
     }
    public String getManufacturer(){
        return this.manufacturer;
    }
    
    public void setMake(String newMake){
        this.manufacturer = newMake;
    }
    
    public String getModel(){
        return this.model;
    }
    
    public void setModel(String newModel){
        this.model = newModel;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setColor(String newColor){
        this.color = newColor;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    
    public double getMilage(){
        return this.milage;
    }
    
    public void setMilage(double newMilage){
        this.milage = newMilage;
    }
}