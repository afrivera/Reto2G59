
public class PrecioTotal {
    // Atributos
    public Double totalDispositivos;
    public double totalPortatiles;
    public Double totalTablets;
    public Dispositivo[] listaDispositivos;

    // Constructores
    PrecioTotal(Dispositivo[] pDispositivos) {
        this.listaDispositivos = pDispositivos;
        this.totalDispositivos=0.;
        this.totalPortatiles=0.;
        this.totalTablets=0.;
        //for(int i =0;i<pDispositivos.length;i++){
        for(Dispositivo i :pDispositivos){
            //System.out.println(pDispositivos[i].calcularPrecio());
            //this.totalDispositivos += pDispositivos[i].calcularPrecio();
            System.out.println(i.calcularPrecio());
            this.totalDispositivos += i.calcularPrecio();
           if(i instanceof Tablet){
                //System.out.println(("clase Table:\n"+i.getClass())+" " + (i.calcularPrecio()));
                this.totalTablets +=i.calcularPrecio();
            }
            if(i instanceof Portatil){
                //System.out.println(("clase Portatil:\n"+i.getClass())+" " + (i.calcularPrecio()));
                this.totalPortatiles +=i.calcularPrecio();
            }         
        }                
    }
   
    // Metodos
    public void mostrarTotales(){
    // Calculo de totales
    System.out.println("La suma del precio de los Dispositivos es de " + totalDispositivos);
    System.out.println("La suma del precio de los Computadores portatiles es de " + totalPortatiles);
    System.out.println("La suma del precio de las Tablets es de " + totalTablets);
    }    
}

class Dispositivo {
    //Constantes y atributos
    public static final Integer PESO_BASE = 1;
    public static final char CONSUMO_W_BASE = 'F';
    public static final Double PRECIO_BASE = 100.0;
    public Integer peso;
    public char consumoW;
    public Double precioBase;

    //Constructores
    public Dispositivo(){
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W_BASE;
        this.precioBase = PRECIO_BASE;
    }
    public Dispositivo(Double precioBase, Integer peso){
        //codigo
        this.peso = peso;
        this.consumoW = CONSUMO_W_BASE;
        this.precioBase = precioBase;
        
    }
    public Dispositivo(Double precioBase, Integer peso, char consumoW){
        //codigo
        this.peso = peso;
        this.consumoW = consumoW;
        this.precioBase = precioBase;        
        //comprobarconsumoW(consumoW);
    }
    // Metodos
    //este metodo realiza validación y también la sumatoria de la adición en los diferentes dispositivos
    public Integer comprobarconsumoW(char consumoW){

        Integer adicion =0;
        if(consumoW =='A'){
            adicion+=100;
        }else if(consumoW =='B'){
            adicion+=80;
        }else if(consumoW =='C'){
            adicion+=60;
        }else if(consumoW =='D'){
            adicion+=50;
        }else if(consumoW =='E'){
            adicion+=30;
        }else if(consumoW =='F'){
            adicion+=10;
        }  

        if(adicion>10){
        this.consumoW=consumoW;
        }else{
        this.consumoW= CONSUMO_W_BASE;
        }

        if(peso>1 && peso<=2){
            adicion+= 10;
        }else if(peso>2 && peso<=3){
            adicion+= 50;
        }else if(peso>3 && peso<=4){
            adicion+= 80;
        }else if(peso>4){
            adicion+= 100;
        }else{
            adicion +=0;
        }

        return adicion;
        
    }
    public Double calcularPrecio(){        
        // Código
        Integer adicion =0;              
        adicion = comprobarconsumoW(consumoW);
        
        return precioBase + adicion;
    }
}

class Tablet extends Dispositivo{
    //Constantes y atributos
    public static final Integer MEMORIA_RAM_BASE = 1;
    public Integer memoriaRam;

    //Constructor     
    public Tablet(){
        //codigo
        super();
        this.memoriaRam = MEMORIA_RAM_BASE;
    }
    public Tablet(Double precioBase, Integer peso){
        //codigo
        super(precioBase, peso);
        this.memoriaRam = MEMORIA_RAM_BASE;
    }
    public Tablet(Double precioBase, Integer peso, char consumoW, Integer memoriaRam){
        //codigo
        super(precioBase, peso, consumoW);
        this.memoriaRam = memoriaRam;
    }    
    
    // Métodos
    public Double calcularPrecio(){
        //codigo        
        Integer adicion =0;        
        adicion = comprobarconsumoW(consumoW);

        if(this.memoriaRam>1 && this.memoriaRam<=2){
            adicion +=5;            
        }else if(this.memoriaRam>2 && this.memoriaRam<=4){
            adicion +=25;            
        }else if(this.memoriaRam>4){
            adicion +=50;            
        }else{
            adicion +=0;
        }

        return precioBase + adicion;

    }
}
class Portatil extends Dispositivo{
    //Constantes y atributos
    public static final Integer DISCO_DURO_BASE =250;
    public Integer discoDuro;
    //Constructor    

    public Portatil (){
        //codigo
        super();
        this.discoDuro = DISCO_DURO_BASE;
    }
    public Portatil(Double precioBase, Integer peso){
        //codigo
        super(precioBase, peso);
        this.discoDuro = DISCO_DURO_BASE;
    }
    public Portatil(Double precioBase, Integer peso, char consumoW, Integer discoDuro){
        //codigo
        super(precioBase, peso, consumoW);      
        this.discoDuro = discoDuro;
    }
        // Métodos
    public Double calcularPrecio(){
        //codigo
        Integer adicion = 0;
        adicion = comprobarconsumoW(consumoW);

        if(this.discoDuro>250 && this.discoDuro<=500){
            adicion +=10;            
        }else if(this.discoDuro>500 && this.discoDuro<=1000){
            adicion +=50;            
        }else if(this.discoDuro>1000){
            adicion +=100;            
        }else{
            adicion +=0;
        }

        return precioBase + adicion;
    }
}