package it.scuola.realgoal.models.utils;

/**
 * Created by donadev on 02/06/16.
 */
//enum che rappresenta il tipo di evento del match
public enum EventType {
    //evento di tipo: goal, cartellino giallo, cartellino rosso, sostituzione, autogol
    GOAL("goal"), YCARD("yellow_card"), RCARD("red_card"), SUBSTITUTION("substitution"), AUTOGOL("autogol");

    private String _raw;

    EventType(String raw) {
        _raw = raw;
    }

    @Override
    public String toString() {
        return _raw;
    }

    //metodo che a partire da una stringa ritorna l'enumerazione corrispondente (serve per la serializzazione)
    public static EventType from(String raw) {
        if(raw.equals(GOAL.toString())) return GOAL;
        if(raw.equals(YCARD.toString())) return YCARD;
        if(raw.equals(RCARD.toString())) return RCARD;
        if(raw.equals(SUBSTITUTION.toString())) return SUBSTITUTION;
        if(raw.equals(AUTOGOL.toString())) return AUTOGOL;

        return null;
    }
}
