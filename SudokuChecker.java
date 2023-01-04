
/**
 * Prüfprogramm zum Ermitteln, ob ein zweidimensionales Array eine korrekte
 * Sudoku-Lösung darstellt.
 * <p>
 * <b>Falls Sie Sudoku nicht kennen:</b><br/> 
 * Das Spiel besteht aus 9x9 Feldern, wobei jedes Feld am Ende mit 
 * einer Zahl zwischen 1 und 9 gefüllt sein muss.
 * Zu Beginn des Spiels sind einige Felder mit Zahlen vorbelegt.
 * Die Aufgabe des Spielers ist es, die restlichen Felder mit Zahlen zu füllen und
 * dabei die Vorgaben des Spiels einzuhalten: 
 * <ol>
 * <li>In jeder <b>Zeile</b> dürfen die Ziffern 1 bis 9 nur jemals einmal vorkommen.
 * <li>In jeder <b>Spalte</b> dürfen die Ziffern 1 bis 9 nur jemals einmal vorkommen.
 * <li>In jedem <b>Quadranten</b> (siehe unten) dürfen die Ziffern 1 bis 9 nur jemals einmal vorkommen.
 * </ol>
 * Quadranten: Das 9x9-Feld in 9 3x3-Quadranten (oben rechts,
 * oben mitte, oben links, usw.) unterteilt, auch in diesen Quadranten dürfen die Zahlen 1-9 nur jeweils
 * einmal vorkommen. Also etwa wie folgt:
 * 
 * <pre>
 * xxx | xxx | xxx
 * xxx | xxx | xxx
 * xxx | xxx | xxx
 * ----+-----+----
 * xxx | xxx | xxx
 * xxx | xxx | xxx
 * xxx | xxx | xxx
 * ----+-----+----
 * xxx | xxx | xxx
 * xxx | xxx | xxx
 * xxx | xxx | xxx
 * </pre>
 * 
 * Jeder <b>Quadrant</b> darf bei einer Lösung die Zahlen <b>1-9 auch nur 
 * jemals einmal</b> enthalten.
 * <p>
 * Eine unfertige Lösung enthält noch <b>leere Felder, diese sind mit 0</b>
 * gekennzeichnet. Beispielsweise wäre eine leere Lösung bestehend aus 9x9 0 Werten
 * eine unfertige und damit falsche Lösung.<br/>
 * <b>Eine unfertige Lösung ist wie eine inkorrekte Lösung zu behandeln.</b>
 * <p>
 * Eine fertige Lösung wäre etwa
 * <pre>
 * 534 | 678 | 912
 * 672 | 195 | 348
 * 198 | 342 | 567
 * ----+-----+----
 * 859 | 761 | 423
 * 426 | 853 | 791
 * 713 | 924 | 856
 * ----+-----+----
 * 961 | 537 | 284
 * 287 | 419 | 635
 * 345 | 286 | 179
 * </pre>
 * (Die Quadranten sind zur besseren Lesbarkeit eingezeichnet.) 
 * <p>
 * Eine falsche Lösung wäre bspw.
 * <pre>
 * 134 | 678 | 912
 * 672 | 195 | 348
 * 198 | 342 | 567
 * ----+-----+----
 * 859 | 761 | 423
 * 426 | 853 | 791
 * 713 | 924 | 856
 * ----+-----+----
 * 961 | 537 | 284
 * 287 | 419 | 635
 * 345 | 286 | 179
 * </pre>
 * In der falschen Lösung kommt die Ziffer "1" sowohl
 * in der ersten Spalte, als auch in der obersten Zeile sowie im
 * oberen linken Quadranten jeweils zweimal vor. Die 5 fehlt (die falsche Lösung ist
 * identisch mit der richtigen, nur dass die 5 oben links mit einer 1 ausgetauscht
 * wurde).
 * <p>
 * Das eigentliche Spiel wird hier <b>nicht</b> durchgeführt. 
 * Es wird lediglich ein aktueller Spielstand überprüft.
 * Dies geschieht in der einzigen Methode dieser Klasse.
 * <p>
 * Beachten Sie, dass die Klasse keinen Zustand haben darf.
 * <p>
 * Für die Implementierung stehen 6 Tests bereits. 
 * Der Quellcode der Tests wird nicht mitgeliefert. 
 * Die Tests versuchen, Hinweise auf den Fehler zu geben, ohne zuviel zu verraten.
 * Es ist natürlich möglich, eigene Tests zu schreiben.
 * <p>
 * Bitte beachten: Die Implementierung muss {@code SudokuCheckerImpl} heißen.
 *
 * @author Jens von Pilgrim
 * @version BWI1-PTP WS19/20
 */
public interface SudokuChecker
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
    boolean check(int[][] matrix);
}
