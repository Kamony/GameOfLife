package gameoflife;

/**
 *
 * @author Jirka Hauser
 * Trida na analyzovani simulatoru a vraceni urcitych statistik
 */
public class GameAnalyzer {
    int height;
    int width;

    /**
     * Konstruktor inicializuje vysku a sirku hraci plochy, kde probiha simulace
     * hry zivot
     */
    public GameAnalyzer(int hei, int wid) {
        this.height = hei;
        this.width = wid;
    }
    
    /**
     * metoda vraci pocet zivych bunek, ktere v realnem case zobrazuje simulator
     * @param currentMove
     * @return
     */
    public int getNumberOfCells(boolean[][] currentMove){
        int cells = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(currentMove[i][j])
                    cells++;
            }
        }
        return cells;
    }
    
    /**
     * Metoda vraci pocet oscilatoru - blikacu.
     * Prohlizim vzdy bunku a jeji sousedy ktere predtim specifikuji jako 
     * prislusne Area Fields.
     * Tedy LA odpovida Left Area, UA odpovida Upper Area ap.
     * 
     * @param currentMove
     * @return
     */
    public int getNumberOfBlinkers(boolean[][] currentMove){
        int oscilators = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                int LA = j - 1;
                if (LA < 0) {
                    LA = width - 1;
                }
                int LLA = j - 2;
                if (LLA < 0) {
                    LLA = width - 2;
                }
                int DA = i - 1;
                if (DA < 0) {
                    DA = height - 1;
                }
                
                int DDA = i - 2;
                if (DDA < 0) {
                    DDA = height - 2;
                }
                int DDDA = i - 3;
                if (DDDA < 0) {
                    DDDA = height - 3;
                }
                int RA = (j + 1) % width;
                int RRA = (j + 2) % width;
                int RRRA = (j + 3) % width;
                int RRRRA = (j + 4) % width;
                
                int UA = (i + 1) % height;
                int UUA = (i + 2) % height;
                
                // blinker vertical
                if(currentMove[i][j] &&
                   currentMove[UA][j] &&
                   currentMove[DA][j] &&
                   !currentMove[DDA][j] &&
                   !currentMove[UUA][j] &&
                   !currentMove[UUA][LA] &&
                   !currentMove[UA][LA] &&
                   !currentMove[i][LA] &&
                   !currentMove[DA][LA] &&
                   !currentMove[DDA][LA] &&
                   !currentMove[UUA][RA] &&
                   !currentMove[UA][RA] &&
                   !currentMove[i][RA] &&
                   !currentMove[DA][RA] &&
                   !currentMove[DDA][RA]) oscilators++;
                //blinker horizontal
                if(currentMove[i][j]&&
                   currentMove[i][LA]&&
                   currentMove[i][RA]&&
                   !currentMove[i][RRA]&&
                   !currentMove[i][LLA]&&
                   !currentMove[UA][LLA]&&
                   !currentMove[UA][LA]&&
                   !currentMove[UA][j]&&
                   !currentMove[UA][RA]&&
                   !currentMove[UA][RRA]&&
                   !currentMove[DA][LLA]&&
                   !currentMove[DA][LA]&&
                   !currentMove[DA][j]&&
                   !currentMove[DA][RA]&&
                   !currentMove[DA][RRA]) oscilators++;
              
            }
        }
        return oscilators;
     }
    
    /**
     * Metoda vraci pocet vsech specifikovanych statickych objektu, ktere jsou
     * znamy v simulatoru hry zivot.
     * Prohlizim vzdy bunku a jeji sousedy ktere predtim specifikuji jako 
     * prislusne Area Fields.
     * Tedy LA odpovida Left Area, UA odpovida Upper Area ap.
     * 
     * @param currentMove
     * @return
     */
    public int getNumberOfStatics(boolean[][] currentMove){
        int statics = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                int LA = j - 1;
                if (LA < 0) {
                    LA = width - 1;
                }
                int LLA = j - 2;
                if (LLA < 0) {
                    LLA = width - 2;
                }
                int DA = i - 1;
                if (DA < 0) {
                    DA = height - 1;
                }
                
                int DDA = i - 2;
                if (DDA < 0) {
                    DDA = height - 2;
                }
                int DDDA = i - 3;
                if (DDDA < 0) {
                    DDDA = height - 3;
                }
                int RA = (j + 1) % width;
                int RRA = (j + 2) % width;
                int RRRA = (j + 3) % width;
                int RRRRA = (j + 4) % width;
                
                int UA = (i + 1) % height;
                int UUA = (i + 2) % height;
                        //block
                        if( currentMove[i][j] &&
                            currentMove[i][RA] && 
                            currentMove[DA][j] && 
                            currentMove[DA][RA] && 
                            !currentMove[UA][j] &&
                            !currentMove[UA][RA] &&
                            !currentMove[UA][LA] &&
                            !currentMove[i][LA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDA][j] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[DA][LA]) statics++;
                        //beehive horizontal
                        if( currentMove[i][j] &&
                            currentMove[UA][RA] &&
                            currentMove[UA][RRA] &&
                            currentMove[DA][RA] &&
                            currentMove[DA][RRA] &&
                            currentMove[i][RRRA] &&
                            !currentMove[i][RA] &&    
                            !currentMove[i][RRA] &&    
                            !currentMove[UA][j] &&    
                            !currentMove[UUA][j] &&    
                            !currentMove[DA][j] &&    
                            !currentMove[DDA][j] &&    
                            !currentMove[i][LA] &&    
                            !currentMove[UA][LA] &&    
                            !currentMove[DA][LA] &&    
                            !currentMove[UUA][RA] &&    
                            !currentMove[UUA][RRA] &&    
                            !currentMove[UUA][RRRA] &&    
                            !currentMove[UA][RRRA] &&    
                            !currentMove[DA][RRRA] &&    
                            !currentMove[DDA][RRRA] &&    
                            !currentMove[DDA][RRA] &&    
                            !currentMove[DDA][RA] &&    
                            !currentMove[UA][RRRRA] &&    
                            !currentMove[i][RRRRA] &&    
                            !currentMove[DA][RRRRA]    
                                ) statics++;
                        //beehive vertical
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            currentMove[DDA][j] &&
                            !currentMove[DA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[DDDA][j] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[DDA][LLA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDDA][LA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[UA][RA] &&
                            currentMove[i][RA] &&
                            currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DDDA][RA]) statics++;   
                        // boat vrchol 1. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            currentMove[i][RA] &&
                            currentMove[UA][RA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[UUA][RRA] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            !currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA]) statics++;
                        // boat vrchol 2. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            currentMove[i][RA] &&
                            !currentMove[UA][RA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[UUA][LA] &&
                            currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            !currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UUA][LLA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[i][LLA]) statics++;
                        // boat vrchol 3. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            currentMove[i][RA] &&
                            !currentMove[UA][RA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDA][LLA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[i][LLA]) statics++;
                        // boat vrchol 4. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            currentMove[i][RA] &&
                            !currentMove[UA][RA] &&
                            !currentMove[UUA][RA] &&
                            currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            !currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA]) statics++;
                        // loaf vrchol 1. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            !currentMove[DDDA][j] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            !currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[UUA][RA] &&
                            currentMove[UA][RA] &&
                            !currentMove[i][RA] &&
                            !currentMove[DA][RA] &&
                            currentMove[DDA][RA] &&
                            !currentMove[DDDA][RA] &&
                            !currentMove[UUA][RRA] &&
                            !currentMove[UA][RRA] &&
                            currentMove[i][RRA] &&
                            currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[DDDA][RRA] &&
                            !currentMove[UA][RRRA] &&
                            !currentMove[i][RRRA] &&
                            !currentMove[DA][RRRA] &&
                            !currentMove[DDA][RRRA]) statics++;
                        // loaf vrchol 4. kvadrant
                        if( currentMove[i][j] &&
                            !currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[DA][j] &&
                            currentMove[DDA][j] &&
                            !currentMove[DDDA][j] &&
                            !currentMove[DDDA][LA] &&
                            !currentMove[UA][LA] &&
                            !currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[UUA][RA] &&
                            currentMove[UA][RA] &&
                            !currentMove[i][RA] &&
                            !currentMove[DA][RA] &&
                            currentMove[DDA][RA] &&
                            !currentMove[DDDA][RA] &&
                            !currentMove[UUA][RRA] &&
                            !currentMove[UA][RRA] &&
                            currentMove[i][RRA] &&
                            currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[DDDA][RRA] &&
                            !currentMove[UA][RRRA] &&
                            !currentMove[i][RRRA] &&
                            !currentMove[DA][RRRA] &&
                            !currentMove[DDA][RRRA]) statics++;
                        // loaf vrchol 3. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[DA][j] &&
                            currentMove[DDA][j] &&
                            !currentMove[DDDA][j] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[DDA][LLA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[UA][RA] &&
                            currentMove[i][RA] &&
                            !currentMove[DA][RA] &&
                            currentMove[DDA][RA] &&
                            !currentMove[DDDA][RA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[i][RRA] &&
                            currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[DDDA][RRA] &&
                            !currentMove[i][RRRA] &&
                            !currentMove[DA][RRRA] &&
                            !currentMove[DDA][RRRA]) statics++;
                        // loaf vrchol 2. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[DA][j] &&
                            currentMove[DDA][j] &&
                            !currentMove[DDDA][j] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[DDA][LLA] &&
                            !currentMove[UUA][RA] &&
                            currentMove[UA][RA] &&
                            !currentMove[i][RA] &&
                            currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[DDDA][RA] &&
                            !currentMove[UA][RRA] &&
                            currentMove[i][RRA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[UUA][RRA] &&
                            !currentMove[i][RRRA] &&
                            !currentMove[DA][RRRA] &&
                            !currentMove[UA][RRRA]) statics++;
                        // bow-tie vrcholy 2.-4. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[UUA][LA] &&
                            currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            !currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UUA][LLA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[UA][RA] &&
                            currentMove[i][RA] &&
                            currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] ) statics++;
                        // bow-tie vrcholy 1.-3. kvadrant
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDA][LLA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[UUA][RA] &&
                            currentMove[UA][RA] &&
                            currentMove[i][RA] &&
                            !currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[DA][RRA] &&
                            !currentMove[UUA][RRA] ) statics++;
                        // cross
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            currentMove[DA][j] &&
                            !currentMove[DDA][j] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            !currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[UUA][RA] &&
                            !currentMove[UA][RA] &&
                            currentMove[i][RA] &&
                            !currentMove[DA][RA] &&
                            !currentMove[DDA][RA] &&
                            !currentMove[UA][RRA] &&
                            !currentMove[i][RRA] &&
                            !currentMove[DA][RRA]) statics++;
                        // squared ball 
                        if( !currentMove[i][j] &&
                            currentMove[UA][j] &&
                            !currentMove[UUA][j] &&
                            !currentMove[DA][j] &&
                            currentMove[DDA][j] &&
                            !currentMove[DDDA][j] &&
                            !currentMove[UUA][LA] &&
                            !currentMove[UA][LA] &&
                            currentMove[i][LA] &&
                            currentMove[DA][LA] &&
                            !currentMove[DDA][LA] &&
                            !currentMove[DDDA][LA] &&
                            !currentMove[UA][LLA] &&
                            !currentMove[i][LLA] &&
                            !currentMove[DA][LLA] &&
                            !currentMove[DDA][LLA] &&
                            !currentMove[UUA][RRA] &&
                            !currentMove[UA][RRA] &&
                            currentMove[i][RRA] &&
                            currentMove[DA][RRA] &&
                            !currentMove[DDA][RRA] &&
                            !currentMove[DDDA][RRA] &&
                            !currentMove[UUA][RA] &&
                            currentMove[UA][RA] &&
                            !currentMove[i][RA] &&
                            !currentMove[DA][RA] &&
                            currentMove[DDA][RA] &&
                            !currentMove[DDDA][RA] &&
                            !currentMove[UA][RRRA] &&
                            !currentMove[i][RRRA] &&
                            !currentMove[DA][RRRA] &&
                            !currentMove[DDA][RRRA])statics++;
            }
        }
        
        return statics;
    }
     
}
