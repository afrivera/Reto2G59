/* CONSUMO_W_BASE = ‘F’
PRECIO_BASE = 100.0
PESO_BASE = 1
DD_BASE = 250 (Gb)
MEMORIA_RAM_BASE = 1 (Gb)

Si el consumo energético (consumoW) del dispositivo es ‘A’, se adiciona $100, si es ‘B’ se adiciona $80, si es
‘C’ se adiciona $60, si es ‘D’ se adiciona $50, si es ‘E’ se adiciona $30 y si es ‘F’ se adiciona $10.
Del mismo modo, si el peso del dispositivo es mayor que 1 y menor o igual que 2 se adiciona $10, si el peso
es mayor a 2 y menor o igual a 3 se adiciona $50, si el peso es mayor que 3 y menor o igual a 4 se adiciona
$80 y si el peso es mayor a 4 se adiciona $100.

Si el duscoDuro es mayor a 250 y menor o igual a 500 Gb, se adiciona $10,
Si el duscoDuro es superior a 500 Gb y menor o igual a 1000 Gb, se adiciona $50,
Si el duscoDuro es superior a 1000 Gb, se adiciona $100,

Si la memoriaRam es superior a 1 Gb y menor o igual a 2 Gb, se adiciona $5,
Si la memoriaRam es superior a 2 Gb y menor o igual a 4 Gb, se adiciona $25,
Si la memoriaRam es superior a 4 Gb, se adiciona $50, */

public class App {
    public static void main(String[] args) throws Exception {
        Dispositivo dispositivos[]=new Dispositivo[5];
        dispositivos[0]=new Dispositivo(200.0, 3, 'C');//310-->base=200 + peso3 = 50 + consumo 'C'=60
        dispositivos[1]=new Tablet(150.0, 2);//170 --> base=150 + peso2=10 + consumo predet'F' =10
        dispositivos[2]=new Portatil(500.0, 3, 'E', 250);//560 en el documento--> para mí es -->580; base=500 + peso3=50 + consumo'E'=30, dD250=no suma
        dispositivos[3]=new Tablet();//-->110
        dispositivos[4]=new Dispositivo(600.0, 3, 'D');//-->700 base= 600 + peso 3 = 50 + consumo 'D' =50
        PrecioTotal solucion1 = new PrecioTotal(dispositivos);
        solucion1.mostrarTotales();
       /*Base 110 de cualquier dispositivo sin constructor; 
        La suma del precio de los Dispositivos es de 1870.0
        La suma del precio de los Computadores portátiles es de 580.0
        La suma del precio de las Tablets es de 280.0 */
                
        Dispositivo dispositivos2[]=new Dispositivo[10];
        dispositivos2[0]=new Dispositivo(200.0, 4, 'C');//base=200 + peso4= 80 + consumo 'C'=60 -->340
        dispositivos2[1]=new Tablet(150.0, 1);//base=150 + peso 1=0 + consumoPredet 'F'= 10 -->160
        dispositivos2[2]=new Portatil(500.0, 2,'E',500);//base=500 + peso 2=10 + consumo 'E'=30 + dD500= 10 --> 550,,
        dispositivos2[3]=new Dispositivo();//110 ya que trae valores por defecto
        dispositivos2[4]=new Dispositivo(600.0, 1, 'D');//base=600 + peso1=0 + consumo 'D'=50 -->650
        dispositivos2[5]=new Tablet(300.0, 1, 'Z', 3);//base=300 + peso1=0 + consumo 'Z' =0 + memoriaRam = 25 -->325 **pendiente validar si con consumo 'z' tendría que volverse 'F' y valer 10 y el total sería -->335
        dispositivos2[6]=new Portatil(250.0, 4);//base=250 + peso4=80 + consumopredet 'F'=10 -->40,, no suma dDuro 
        dispositivos2[7]=new Tablet(400.0, 3, 'A', 4);//base=400 + peso3=50 + consumo 'A'=100 + mRam= 25 --> 575
        dispositivos2[8]=new Portatil(200.0, 3, 'C', 500);////base=200 + peso3= 50 + consumo 'C'=60 + dDuro500=10 -->320,,
        dispositivos2[9]=new Dispositivo(50.0, 3);//base=50 + peso3=50 + consumopredet 'F'=10 -->110,,
        PrecioTotal solucion2 = new PrecioTotal(dispositivos2);
        solucion2.mostrarTotales(); 

        /* La suma del precio de los Dispositivos es de 3480.0
        La suma del precio de los Computadores portátiles es de 1210.0
        La suma del precio de las Tablets es de 1060.0 *sí se toma la prueba con z sumando por defecto daría 1070 */
    }
}
