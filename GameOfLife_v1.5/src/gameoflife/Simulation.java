package gameoflife;

/**
 * Trida provadeici simulaci hry zivot.
 * 
 * @author Jirka Hauser
 */
public class Simulation {
    
    int height;
    int width;
    
    /**
     * inicializuji vysku a sirku hraci plochy
     */
    public Simulation(int hei, int wid) {
        this.height = hei;
        this.width = wid;
        
    }

    /**
     * Metoda ktera implementuje 4 zakladni podminky pro chovani bunky.
     * 
     *   Každá živá buňka s méně než dvěma živými sousedy zemře.
     *   Každá živá buňka se dvěma nebo třemi živými sousedy zůstává žít.
     *   Každá živá buňka s více než třemi živými sousedy zemře.
     *   Každá mrtvá buňka s právě třemi živými sousedy oživne.
     * @param i
     * @param j
     * @param currentMove
     * @param nextMove
     * @return
     */
    public boolean update(int i, int j, boolean[][] currentMove, boolean[][] nextMove){
        
        int sousede = numberOfNeighbours(i, j, currentMove);
        
        if(sousede < 2 || sousede > 3){
            return false;
        } else 
            if(sousede == 3) {
                return true;
            } else
                if((sousede == 2 || sousede == 3) && currentMove[i][j]){
                    return nextMove[i][j] = true;
                }
        return false;
    }
    /**
     * Metoda pocitajici pocet zivich sousedu bunky na pozici i,j.
     * Kontroluji taktez zasahy mimo hraci plochu.
     * @param i
     * @param j
     * @param currentMove
     * @return 
    */
    public int numberOfNeighbours(int i, int j, boolean[][] currentMove){
        int neighbor = 0;
        if(j>0){
            if(currentMove[i][j-1]) neighbor++;
            if(i>0) if(currentMove[i-1][j-1]) neighbor++;
            if(i<height-1) if(currentMove[i+1][j-1]) neighbor++;
        }
        if(j<width-1){
            if(currentMove[i][j+1]) neighbor++;
            if(i>0) if(currentMove[i-1][j+1]) neighbor++;
            if(i<height-1) if(currentMove[i+1][j+1]) neighbor++;
        }
        if(i>0) if(currentMove[i-1][j]) neighbor++;
        if(i<height-1) if(currentMove[i+1][j]) neighbor++;
        
        return neighbor;
    }
}
