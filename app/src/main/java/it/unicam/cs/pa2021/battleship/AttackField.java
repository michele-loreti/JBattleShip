package it.unicam.cs.pa2021.battleship;

/**
 * Classe utilizzata per tenere traccia degli attacchi effettuati.
 */
public interface AttackField {

    /**
     * Registra il risultato dell'attacco nella data posizione.
     *
     * @param fieldPosition posizione del campo.
     * @param result risultato dell'attacco.
     */
    void set(FieldPosition fieldPosition, ShotResult result);


    /**
     * Restituisce il valore registrato nella data posizione.
     *
     * @param fieldPosition posizione nel campo.
     * @return  valore registrato nella data posizione, restistuice <code>null</code> se la posizione
     * non &egrave; stata usata.
     */
    ShotResult get(FieldPosition fieldPosition);

}
