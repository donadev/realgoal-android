package it.scuola.realgoal.models.utils;

/**
 * Created by donadev on 01/06/16.
 */
//enum che rappresenta lo stato del match
public enum MatchState {
    //da giocare, in gioco, giocato
     SCHEDULED("scheduled"), PENDING("pending"), FINISHED("finished");

    private String _raw;

    MatchState(String raw) {
        _raw = raw;
    }

    @Override
    public String toString() {
        return _raw;
    }

    //metodo che a partire da una stringa ritorna l'enumerazione corrispondente (serve per la serializzazione)
    public static MatchState from(String raw) {
        if(raw.equals(SCHEDULED.toString())) return SCHEDULED;
        if(raw.equals(PENDING.toString())) return PENDING;
        if(raw.equals(FINISHED.toString())) return FINISHED;

        return null;
    }
}
