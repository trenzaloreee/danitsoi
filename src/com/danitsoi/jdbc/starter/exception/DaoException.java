package com.danitsoi.jdbc.starter.exception;

import javax.management.relation.RelationNotFoundException;

public class DaoException extends RuntimeException {

    public DaoException(Throwable throwable){
        super(throwable);
    }
}
