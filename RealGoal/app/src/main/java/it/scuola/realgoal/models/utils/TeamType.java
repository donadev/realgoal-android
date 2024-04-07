package it.scuola.realgoal.models.utils;

/**
 * Created by donadev on 02/06/16.
 */
//tipo della squadra //casa-trasferta
public enum TeamType {
    //squadra di casa, squadra in trasferta
    HOME("home"), AWAY("away");

    private String _raw;

    TeamType(String raw) {
        _raw = raw;
    }

    @Override
    public String toString() {
        return _raw;
    }

    //metodo che a partire da una stringa ritorna l'enumerazione corrispondente (serve per la serializzazione)
    public static TeamType from(String raw) {
        if(raw.equals(HOME.toString())) return HOME;
        if(raw.equals(AWAY.toString())) return AWAY;

        return null;
    }
}
