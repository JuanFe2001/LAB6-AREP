package edu.eci.awsprimerlogservice;

import com.mongodb.client.MongoDatabase;

import java.util.Date;

import static spark.Spark.get;
import static spark.Spark.port;

public class LogService {

    
    public static void main(String... args) {
        MongoDatabase database = ConnectionDB.getDB();
        LogListed logDAO = new LogListed(database);
        port(getPort());
        get("/logservice", (req, res) -> {
            Date fechaActual = new Date();
            String fechaTexto = fechaActual.toString();
            logDAO.addLog(fechaTexto, req.queryParams("msg"));
            System.out.println(req.queryParams("msg"));
            res.type("application/json");
            return logDAO.listLogs();
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
