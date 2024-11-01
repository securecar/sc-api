package com.securecar;

import io.github.cdimascio.dotenv.Dotenv;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.securecar package
        final ResourceConfig rc = new ResourceConfig().packages("com.securecar.resource");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Carrega variáveis de ambiente
        String dbUrl = System.getenv("DB_URL");
        String dbUsername = System.getenv("DB_USERNAME");
        String dbPassword = System.getenv("DB_PASSWORD");
        String dbDriver = System.getenv("DB_DRIVER");
    
        if (dbUrl == null || dbUsername == null || dbPassword == null || dbDriver == null) {
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
            if (dbUrl == null) {
                dbUrl = dotenv.get("DB_URL");
            }
            if (dbUsername == null) {
                dbUsername = dotenv.get("DB_USERNAME");
            }
            if (dbPassword == null) {
                dbPassword = dotenv.get("DB_PASSWORD");
            }
            if (dbDriver == null){
                dbDriver = dotenv.get("DB_DRIVER");
            }
        }
    
        // Define propriedades do sistema
        System.setProperty("DB_URL", dbUrl);
        System.setProperty("DB_USERNAME", dbUsername);
        System.setProperty("DB_PASSWORD", dbPassword);
        System.setProperty("DB_DRIVER", dbDriver);
    
        // Inicia o servidor
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started at %s\nPress Ctrl+C to stop...", BASE_URI));
    
        // Mantém o servidor rodando até que o processo seja interrompido
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.err.println("Servidor interrompido: " + e.getMessage());
        }
    }
}

