package it.unicam.cs.pa2021.battleship;

/**
 * Interfaccia utilizzata per rappresentare le navi sul campo di battaglia.
 */
public interface Ship {

    /**
     * Restituisce la dimensione della nave
     *
     * @return la dimensione della nave
     */
    int size();

    /**
     * Restituisce il numero dei colpi ricevuti dalla nave.
     *
     * @return il numero dei colpi ricevuti dalla name.
     */
    int shots();

    /**
     * Restituisce i punti vita della nave.
     *
     * @return i punti vita della nave.
     */
    int strenght();

    /**
     * Restituisce true se la nave &egrave; stata distrutta. False, altrimenti.
     *
     * @return true se la nave &egrave; stata distrutta. False, altrimenti.
     */
    boolean isDestroyed();

    /**
     * Restituisce il nome della nave.
     *
     * @return il nome della nave.
     */
    String getName();

    /**
     * Restituisce il risultato di un colpo ricevuto alla data posizione.
     *
     * @param fieldPosition posizione del colpo.
     * @return risultato del colpo.
     */
    ShotResult shotAt(FieldPosition fieldPosition);

    /**
     * Restituisce lo stato della nave nella posizione data.
     *
     * @param fieldPosition posizione nel campo.
     * @return stato della nave nella posizione data.
     */
    ShotResult status(FieldPosition fieldPosition);
}
