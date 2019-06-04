package firebase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class Database {

    private final String PRIVATEKEYLOCATION = getPRIVATEKEYLOCATION();
    private static final String DATABASEURL = "https://iipsen-f7b65.firebaseio.com";
    private Firestore db;


    public Database() {

        try {
            FileInputStream serviceAccount =
                    new FileInputStream(PRIVATEKEYLOCATION);


            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(DATABASEURL)
                    .build();

            FirebaseApp.initializeApp(options);
            this.db = FirestoreClient.getFirestore();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Firestore getFirestoreDatabase() {
        return this.db;
    }

    public String getPRIVATEKEYLOCATION(){
        try {
            return getClass().getResource("/iipsen-f7b65-firebase-adminsdk-si9zo-13167bfb98.json").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}