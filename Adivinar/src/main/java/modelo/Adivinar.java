package modelo;

import java.util.Random;

public class Adivinar {
  private final int numerosecreto;
  private int intentos;
  private boolean conocido;
  private final Random random = new Random();
  
  public Adivinar() {
    this.numerosecreto = random.nextInt(1001);
    this.intentos = 0;
    this.conocido = false;   
  } 
  
  public int getIntentos() {
    return intentos;
  }
  
  public boolean isConocido() {
    return conocido;
  }
  
  public String verificar(int v) {
    int ns = this.numerosecreto;
    this.intentos++;
    String ms;
    if (v < ns) {
        ms = "El número es mayor. Sigue intentando";
    } else if (v > ns) {
        ms = "El número es menor. Sigue intentando";
    } else {
        ms = "¡Felicidades! Has adivinado el número " + ns + " en " + this.intentos + " intentos.";
        this.conocido = true;
    }  
    return ms;
  }
}