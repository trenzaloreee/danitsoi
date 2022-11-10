package com.danitsoi.jdbc.starter;

import com.danitsoi.jdbc.starter.util.ConnectionManager;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionRunner {
    public static void main(String[] args) throws SQLException {
        long flightId = 8;
        var deleteFlightSql = "DELETE FROM flight WHERE id = " + flightId;
        var deleteTicketsSql = "DELETE FROM ticket WHERE flight_id = " + flightId;
        var createTableSql = "CREATE TABLE test4 (id SERIAL PRIMARY KEY )";
        Connection connection = null;
//        PreparedStatement deleteFlightStatement = null;
//        PreparedStatement deleteTicketsStatement = null;
        Statement statement = null;
        try {
            connection = ConnectionManager.get();
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            statement.addBatch(deleteTicketsSql);
            statement.addBatch(deleteFlightSql);
            statement.addBatch(createTableSql);

            var ints = statement.executeBatch();

            connection.commit();
//            deleteFlightStatement = connection.prepareStatement(deleteFlightSql);
//            deleteTicketsStatement = connection.prepareStatement(deleteTicketsSql);

            //!Важно!

//            deleteFlightStatement.setLong(1, flightId);
//            deleteTicketsStatement.setLong(1, flightId);
//
//            var deletedTicketsResult = deleteTicketsStatement.executeUpdate();
//            if (true) {
//                throw new RuntimeException("ooops");
//            }
//            var deletedFlightResul = deleteFlightStatement.executeUpdate();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}
