package it.scuola.realgoal.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import it.scuola.realgoal.models.utils.EventType;
import it.scuola.realgoal.models.utils.MatchState;
import it.scuola.realgoal.models.utils.TeamType;

/**
 * Created by donadev on 01/06/16.
 */
public class Serializer {
    public static Gson initialize() {
        return new GsonBuilder().registerTypeAdapter(MatchState.class, new MatchStateSerializer())
                                .registerTypeAdapter(EventType.class, new EventTypeSerializer())
                                .registerTypeAdapter(TeamType.class, new TeamTypeSerializer())
                                .create();
    }

    static class MatchStateSerializer implements JsonDeserializer<MatchState> {

        @Override
        public MatchState deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String value = json.getAsString();
            return MatchState.from(value);
        }
    }

    static class EventTypeSerializer implements JsonDeserializer<EventType> {

        @Override
        public EventType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String value = json.getAsString();
            return EventType.from(value);
        }
    }

    static class TeamTypeSerializer implements JsonDeserializer<TeamType> {

        @Override
        public TeamType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String value = json.getAsString();
            return TeamType.from(value);
        }
    }
}
