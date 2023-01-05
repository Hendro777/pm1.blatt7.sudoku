// Java program to implement
// the above approach
import java.io.*;
import java.util.*;
import java.util.Arrays;

/**
 * Eine Klasse mit einer Dienstleister-Methode.
 * Der Rumpf ist sinnvoll zu fuellen!
 * 
 * @author Hendrik Lind
 * @version 22.1.2020
 */
public class SudokuCheckerImpl implements SudokuChecker
{
    /**
     * Prüft, ob die übergeben Matrix eine korrekte Sudoko-Lösung ist oder nicht. 
     * <p>
     * Eine Sudoko-Lösung besteht aus eine 9x9 Matrix.
     * Dabei kommen in <b>jeder Zeile</b>, in </b>jeder Spalte</b> und in jedem
     * Quadranten (siehe oben) die Zahlen <b>1-9 nur jeweils einmal</b> vor.
     * <p>
     * Beispiele zu falschen und korrekten Lösungen siehe oben.
     * 
     * @param matrix zweidimensionales Array mit dem aktuellen Spielstand.
     * @return true wenn die Lösung korrekt ist;<br/> 
     *         false, wenn die Lösung fehlerhaft (oder unvollständig) ist.       
     * @throws IllegalArgumentExeption wenn die Matrix nicht 9x9 Felder groß ist oder
     *          Werte außerhalb des Intervalls [0..9] enthält.            
     */
    @Override
    public boolean check(int[][] board) {
        if(board.length < 9) {
            throw new IllegalArgumentException("Übergebenes Sudokufeld enthält zu wenig Zeilen");
        }
        
        for(int[] zeile: board)
        {
            if(zeile.length < 9)
            {
                throw new IllegalArgumentException("Übergebenes Sudokufeld enthält zu wenig Spalten");
            }
            
            for(int val: zeile)
            {
                if(val > 9)
                {
                    throw new IllegalArgumentException("Übergebenes Sudokufeld enthält Felder mit unzulässigen Werten (> 9)");
                }
            }
        }
        return checkeAlleZeilen(board) && checkeAlleSpalten(board) && checkeAlleQuadranten(board);
    }
    
    /**
     * Überprüft, ob Zeilen in einem 9x9 Sudokufeld doppelte Werte oder leere Felder
     * enthalten.
     * Gibt true zurück, wenn keine Zeile doppelte Werte oder leere Felder enthält.
     * Ansonsten false;
     * 
     * @param board
     * Zweidimensionaler int-Array zur Darstellung eines 9x9 Sudokuspielfelds
     * 
    * @return 
     * True, wenn keine Zeile doppelte Werte oder leere Felder enthält.
     * Ansonsten false.
     */
    public boolean checkeAlleZeilen(int[][] board)
    {   
        for(int[] zeile: board)
        {
            if(checkeZeile(zeile) == false)
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * Überprüft, ob die Zeile eines 9x9 Sudokufelds doppelte Werte oder 
     * leere Felder enthält.
     * Gibt true zurück, wenn die Zeile keine doppelten Werte oder leere
     * Felder enthält. Ansonsten false.
     * 
     * @param zeile
     * Integer-Array der Länge 9 aus einem Sudokufeld
     */
    private boolean checkeZeile(int[] zeile)
    {
        for(int y = 0; y < zeile.length; y++)
        {
            int aktuellesFeld = zeile[y];
            
            // Feld ist leer
            if(isNullField(aktuellesFeld))
            {
                return false;
            }
            
            for(int x = y + 1; x < zeile.length; x++)
            {
                int vergleichsFeld = zeile[x];
                
                // Feldwert doppelt oder Vergleichsfeldleer
                if(aktuellesFeld == vergleichsFeld || isNullField(vergleichsFeld))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Überprüft, ob Spalten in einem 9x9 Sudokufeld doppelte Werte oder leere Felder
     * enthalten.
     * Gibt true zurück, wenn keine Spalte doppelte Werte oder leere Felder enthält.
     * Ansonsten false.
     * 
     * @param board
     * Zweidimensionaler int-Array zur Darstellung eines 9x9 Sudokuspielfelds
     * 
     * @return 
     * True, wenn keine Spalte doppelte Werte oder leere Felder enthält.
     * Ansonsten false.
     */
    public boolean checkeAlleSpalten(int[][] board)
    {
        for(int spalte = 0; spalte < 9; spalte++)
        {
            for(int zeile = 0; zeile < 9; zeile++)
            {
                int aktuellesFeld = board[zeile][spalte];
                // Feld ist leer
                if(isNullField(aktuellesFeld))
                {
                    return false;
                }
                
                for(int zeileVergleich = zeile + 1; zeileVergleich < 9; zeileVergleich++)
                {
                    int vergleichsFeld = board[zeileVergleich][spalte];
                    
                    // Feldwert doppelt oder Vergleichsfeldleer
                    if(aktuellesFeld == vergleichsFeld || isNullField(vergleichsFeld))
                    {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    /**
     * Überprüft, ob die ein 3x3 Quadrant eines 9x9 Sudokufelds doppelte Werte oder 
     * leere Felder enthält.
     * Gibt true zurück, wenn kein Quadrant doppelte Werte oder leere
     * Felder enthält. Ansonsten false.
     * 
     * @param board
     * Zweidimensionaler int-Array zur Darstellung eines 9x9 Sudokuspielfelds
     * 
     * @return 
     * True, wenn kein Quadrant doppelte Werte oder leere Felder enthält.
     * Ansonsten false.
     */
    public boolean checkeAlleQuadranten(int[][] board)
    {
        int ersteZeile = 0;
        for(int q = 0; q < 9; q++)
        {
            if(q > 0 && q % 3 == 0)
            {
                ersteZeile = ersteZeile + 3;
            }
            int ersteSpalte = (q % 3) * 3;
            int[] quadrant = new int[9];
            
            for(int zeile = ersteZeile; zeile < ersteZeile + 3; zeile++)
            {
                for(int spalte = ersteSpalte; spalte < ersteSpalte + 3; spalte++)
                {
                    int aktuellesFeld = board[zeile][spalte];
                    
                    // Feld ist Leer
                    if(isNullField(aktuellesFeld))
                    {
                        return false;
                    }
                    
                    for(int i = 0; i < 9; i++)
                    {
                        if(quadrant[i] == 0)
                        {
                           quadrant[i] = aktuellesFeld; 
                           break;
                        }
                        // Feldwert doppelt
                        else if(quadrant[i] == aktuellesFeld)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean isNullField(int field)
    {
        if(field == 0)
        {
            return true;
        }
        return false;
    }
}