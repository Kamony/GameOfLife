package gameoflife;

import java.util.Random;

/**
 * Trida, ktera pridava specialni objekty objekty do hraci plochy 
 * @author Jirka Hauser
 */
public class Pattern {

    private Random random;
    
    /**
     * inicializuji referencni promenou random jako objekt typu Random
     */
    public Pattern() {
        random = new Random();
    }
    
    /**
     * Metoda vyplni hraci plochu nahodne vygenerovanymi bunkami 
     * @param hei
     * @param wid
     * @param currentMove
     */
    public void randomize(int hei, int wid, boolean[][] currentMove){
        
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < wid; j++) {
                    currentMove[i][j] = random.nextBoolean();
            }
        }
    }
    
    /**
     * umisti na pozici x, y objekt Block - staticky vzor ctverec
     * @param x - predavam jako x souradnici kliknuti leveho mysitka
     * @param y - predavam jako y souradnici kliknuti leveho mysitka
     * @param currentMove
     * @param umisteni
     */
    public void enterSquare(int x,int y,boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x] = true;
            currentMove[y][x+1] = true;
            currentMove[y-1][x] = true;
            currentMove[y-1][x+1] = true;
            
        }
    }
    
    /**
     * umisti na pozici x, y objekt Glider - posunovaci vzor kridlo
     * @param x
     * @param y
     * @param currentMove
     */
    public void enterGlider(int x,int y,boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x+2]= true;
            currentMove[y-1][x]= true;
            currentMove[y-1][x+2]= true;
            currentMove[y-2][x+1]= true;
            currentMove[y-2][x+2]= true;
        }
    }
    
    /**
     * umisti na pozici x, y objekt Beehive - staticky objekt vcelin
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterBeehive(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x+1]= true;
            currentMove[y][x+2]= true;
            currentMove[y+1][x]= true;
            currentMove[y+1][x+3]= true;
            currentMove[y+2][x+1]= true;
            currentMove[y+2][x+2]= true;
        }
    }

    /**
     * umisti na pozici x, y objekt Loaf - staticky objekt bochnik
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterLoaf(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x+1]= true;
            currentMove[y][x+2]= true;
            currentMove[y+1][x]= true;
            currentMove[y+1][x+3]= true;
            currentMove[y+2][x+1]= true;
            currentMove[y+2][x+3]= true;
            currentMove[y+3][x+2]= true;
        }
    }

    /**
     * umisti na pozici x, y objekt Boat - staticky objekt lod
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterBoat(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x]= true;
            currentMove[y][x+1]= true;
            currentMove[y+1][x]= true;
            currentMove[y+1][x+2]= true;
            currentMove[y+2][x+1]= true;
        }
    }
    
    /**
     * umisti na pozici x, y objekt LightWeightStarShip - posunovaci objekt
     * vesmirna lod.
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterLWSS(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x]= true;
            currentMove[y][x+3]= true;
            currentMove[y+1][x+4]= true;
            currentMove[y+2][x]= true;
            currentMove[y+2][x+4]= true;
            currentMove[y+3][x+1]= true;
            currentMove[y+3][x+2]= true;
            currentMove[y+3][x+3]= true;
            currentMove[y+3][x+4]= true;
        }
    } 

    /**
     * umisti na pozici x, y objekt Blinker - oscilator blikac (perioda 2)
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterBlinker(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x]= true;
            currentMove[y][x+1]= true;
            currentMove[y][x+2]= true;
        }
    }

    /**
     * umisti na pozici x, y objekt Toad - oscilator zaba (perioda 2)
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterToad(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x]= true;
            currentMove[y+1][x]= true;
            currentMove[y+1][x+1]= true;
            currentMove[y+2][x]= true;
            currentMove[y+2][x+1]= true;
            currentMove[y+3][x+1]= true;
        }
    }

    /**
     * umisti na pozici x, y objekt Beacon - oscilator majak (perioda 2)
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterBeacon(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x]= true;
            currentMove[y][x+1]= true;
            currentMove[y-1][x]= true;
            currentMove[y-1][x+1]= true;
            currentMove[y-2][x+2]= true;
            currentMove[y-2][x+3]= true;
            currentMove[y-3][x+2]= true;
            currentMove[y-3][x+3]= true;
        }
    }

    /**
     * umisti na pozici x, y objekt Pulsar - oscilator pulzar (perioda 3)
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterPulsar(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x+2]= true;
            currentMove[y][x+3]= true;
            currentMove[y][x+4]= true;
            currentMove[y][x+8]= true;
            currentMove[y][x+9]= true;
            currentMove[y][x+10]= true;
            currentMove[y+2][x]= true;
            currentMove[y+2][x+5]= true;
            currentMove[y+2][x+7]= true;
            currentMove[y+2][x+12]= true;
            currentMove[y+3][x]= true;
            currentMove[y+3][x+5]= true;
            currentMove[y+3][x+7]= true;
            currentMove[y+3][x+12]= true;
            currentMove[y+4][x]= true;
            currentMove[y+4][x+5]= true;
            currentMove[y+4][x+7]= true;
            currentMove[y+4][x+12]= true;
            currentMove[y+5][x+2]= true;
            currentMove[y+5][x+3]= true;
            currentMove[y+5][x+4]= true;
            currentMove[y+5][x+8]= true;
            currentMove[y+5][x+9]= true;
            currentMove[y+5][x+10]= true;
            
            currentMove[y+7][x+2]= true;
            currentMove[y+7][x+3]= true;
            currentMove[y+7][x+4]= true;
            currentMove[y+7][x+8]= true;
            currentMove[y+7][x+9]= true;
            currentMove[y+7][x+10]= true;
            currentMove[y+8][x]= true;
            currentMove[y+8][x+5]= true;
            currentMove[y+8][x+7]= true;
            currentMove[y+8][x+12]= true;
            currentMove[y+9][x]= true;
            currentMove[y+9][x+5]= true;
            currentMove[y+9][x+7]= true;
            currentMove[y+9][x+12]= true;
            currentMove[y+10][x]= true;
            currentMove[y+10][x+5]= true;
            currentMove[y+10][x+7]= true;
            currentMove[y+10][x+12]= true;
            currentMove[y+12][x+2]= true;
            currentMove[y+12][x+3]= true;
            currentMove[y+12][x+4]= true;
            currentMove[y+12][x+8]= true;
            currentMove[y+12][x+9]= true;
            currentMove[y+12][x+10]= true;
        }
    }

    /**
     * umisti na pozici x, y objekt pentadecathlon - oscilator  (perioda 15)
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterPentadecathlon(int x, int y, boolean[][] currentMove, boolean umisteni){
        if(umisteni){
            currentMove[y][x+1]= true;
            currentMove[y+1][x+1]= true;
            currentMove[y+2][x]= true;
            currentMove[y+2][x+2]= true;
            currentMove[y+3][x+1]= true;
            currentMove[y+4][x+1]= true;
            currentMove[y+5][x+1]= true;
            currentMove[y+6][x+1]= true;
            currentMove[y+7][x]= true;
            currentMove[y+7][x+2]= true;
            currentMove[y+8][x+1]= true;
            currentMove[y+9][x+1]= true;
        }
    }

    /**
     *  Metoda vytvori specialni objekt glider gun, coz e vzor, ktery samostatne
     *  tvori glidery
     * @param x
     * @param y
     * @param currentMove
     * @param umisteni
     */
    public void enterCanon(int x, int y, boolean[][] currentMove, boolean umisteni){
       if(umisteni){
            enterSquare(x, y, currentMove, umisteni);
            enterSquare(x+34, y-2, currentMove, umisteni);
            
            currentMove[y][x+10]= true;
            currentMove[y+1][x+10]= true;
            currentMove[y-1][x+10]= true;
            currentMove[y-2][x+11]= true;
            currentMove[y+2][x+11]= true;
            currentMove[y+3][x+12]= true;
            currentMove[y+3][x+13]= true;
            currentMove[y-3][x+12]= true;
            currentMove[y-3][x+13]= true;
            currentMove[y][x+14]= true;
            currentMove[y+2][x+15]= true;
            currentMove[y-2][x+15]= true;
            currentMove[y][x+16]= true;
            currentMove[y+1][x+16]= true;
            currentMove[y-1][x+16]= true;
            currentMove[y][x+17]= true;
            currentMove[y-1][x+20]= true;
            currentMove[y-2][x+20]= true;
            currentMove[y-3][x+20]= true;
            currentMove[y-1][x+21]= true;
            currentMove[y-2][x+21]= true;
            currentMove[y-3][x+21]= true;
            currentMove[y][x+22]= true;
            currentMove[y-4][x+22]= true;
            currentMove[y][x+24]= true;
            currentMove[y+1][x+24]= true;
            currentMove[y-4][x+24]= true;
            currentMove[y-5][x+24]= true;
       }
    }    
}
