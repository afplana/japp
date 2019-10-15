package ao.jfpack.mongoutl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MongoUtility {

    private static final Map<String, MongoDatabase> databaseMap = new HashMap<>();
    private static final CodecRegistry codecRegistry;
    private static final MongoClient mongoClient;
    private static final MongoUtility mongoUtility = new MongoUtility();

    public static MongoUtility getInstance() {
        return Optional.of(mongoUtility).orElseGet(MongoUtility::new);
    }

    static {
        codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry()
                , CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        mongoClient = new MongoClient();
    }

    private MongoUtility() {
    }

    public static void closeMongoClient() {
        Optional.of(mongoClient).ifPresent(MongoClient::close);
    }

    public static MongoDatabase getDatabases(String database) {
        Optional<MongoDatabase> mongoDatabase = Optional.ofNullable(databaseMap.get(database));
        return mongoDatabase.orElseGet(createInstance(database));
    }

    private static Supplier<MongoDatabase> createInstance(String database) {
        return () -> {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
            mongoDatabase = mongoDatabase.withCodecRegistry(codecRegistry);
            databaseMap.putIfAbsent(database, mongoDatabase);
            return mongoDatabase;
        };
    }

    public static <T> MongoCollection<T> getBucket(String database, String bucket, Class<T> cls) {
        MongoDatabase mongoDatabase = getDatabases(database);
        return mongoDatabase.getCollection(bucket, cls);
    }


}
