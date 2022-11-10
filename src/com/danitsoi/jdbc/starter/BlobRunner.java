package com.danitsoi.jdbc.starter;

import com.danitsoi.jdbc.starter.util.ConnectionManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;

public class BlobRunner {
    public static void main(String[] args) throws SQLException, IOException {
        //blob - bytea (binary large object)
        //clob - TEXT (character -.-)
        saveImage();
        getImage();
    }

    private static void getImage() throws SQLException, IOException {
        var sql = """
                SELECT image 
                FROM aircraft
                WHERE id = ?
                """;
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            }
            var image = resultSet.getBytes("image");
            Files.write(Path.of("resources", "boeing777_new.jpg"), image, StandardOpenOption.CREATE);
        }
    }

    private static void saveImage() throws SQLException, IOException {
        var sql = """
                UPDATE aircraft
                SET image = ?
                where id = 1
                """;
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setBytes(1, Files.readAllBytes(Path.of("resources", "boeing777.jpg")));
            preparedStatement.executeUpdate();
        }
    }
}
